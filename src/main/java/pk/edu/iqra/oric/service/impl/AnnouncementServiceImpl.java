package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.Announcement;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.University;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.AnnouncementDTO;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.publicdto.PublicAnnouncementDTO;
import pk.edu.iqra.oric.repository.AnnouncementRepository;
import pk.edu.iqra.oric.repository.AnnouncementTypeRepository;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.service.*;
import pk.edu.iqra.oric.utility.Constants;
import pk.edu.iqra.oric.utility.ServiceConstants;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("announcements")
public class AnnouncementServiceImpl implements AnnouncementService {


    private AnnouncementRepository repository;
    private AnnouncementTypeRepository announcementTypeRepository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    private UniversityService universityService;

    private FileService fileService;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository repository,
                                   UserService userService,
                                   OricSessionRepository oricSessionRepository,
                                   FacultyService facultyService,
                                   AnnouncementTypeRepository announcementTypeRepository,
                                   UniversityService universityService,
                                   FileService fileService) {
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
        this.announcementTypeRepository = announcementTypeRepository;
        this.universityService = universityService;
        this.fileService = fileService;
    }

    @Override
    public List<Announcement> getResource(Integer oricSessionId) {
        return repository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<AnnouncementDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x -> new AnnouncementDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        Announcement classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        AnnouncementDTO dto = mapper.readValue(dtoString, AnnouncementDTO.class);

        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new Announcement();
            classObject.setCreatedOn(Instant.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = repository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        AnnouncementDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(Instant.now());

        if (dto.getFacultyId() != null) {
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }


        classObject.setAnnouncementType(announcementTypeRepository.findById(dto.getAnnouncementTypeId()).get());
        dto.setAnnouncementTypeName(classObject.getAnnouncementType().getName());


        dto.setId(repository.save(classObject).getId());

        return dto;
    }

    @Override
    public List<AnnouncementDTO> getResourceDTO(List<Announcement> classObjectList) {
        return classObjectList.stream().map(x -> new AnnouncementDTO(x)).collect(Collectors.toList());
    }

    @Override
    public List<Announcement> getResourceForRole(Integer oricSessionId, Integer campusId, String role) {
        if (role.equalsIgnoreCase(Constants.UNIVERSITY_ADMINISTRATOR_ROLE.toLowerCase())) {
            return repository.findOfOricSession(oricSessionId);
        }

        return repository.findOfCampus(campusId);
    }

    @Override
    public List<PublicAnnouncementDTO> getPublicAnnouncements(String universityId, Integer typeId) {

        University university = universityService.getUniversityByEncryptedId(universityId);
        return repository.findAnnouncementsOfUniversity(university.getId(), typeId, LocalDate.now().plusWeeks(1)).
                stream().
                map(x -> new PublicAnnouncementDTO(x,false)).
                collect(Collectors.toList());
    }

    @Override
    public PublicAnnouncementDTO getPublicAd(String universityId, Integer adId) {
        Announcement announcement = repository.findAnnouncementOfUniversity(universityId,adId);
        PublicAnnouncementDTO publicAnnouncementDTO = new PublicAnnouncementDTO();
        publicAnnouncementDTO.setLongDescription(announcement.getLongDescription());
        publicAnnouncementDTO.setTitle(announcement.getTitle());
        publicAnnouncementDTO.setId(announcement.getId());
        return publicAnnouncementDTO;
    }

    @Override
    public List<String> getPublicAdFiles(String universityId, Integer adId) throws IOException {
        OricSession oricSession = repository.findOricSessionOfAnnouncement(universityId,adId);
        String url = UtilityFunctions.getURLForDocumentUpload(oricSession.getId(),adId, ServiceConstants.ANNOUNCEMENTS);
        return fileService.getNamesOfAllFilesInDirectory(Path.of(url));
    }

    @Override
    public File getFileOfAd(String univId, Integer adId, String fileName) throws IOException {
        OricSession oricSession = repository.findOricSessionOfAnnouncement(univId,adId);
        String url = UtilityFunctions.getURLForDocumentUpload(oricSession.getId(),adId, ServiceConstants.ANNOUNCEMENTS);
        return fileService.getFileFromDirectory(Path.of(url),fileName);
    }
}
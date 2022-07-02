package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.Announcement;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.AnnouncementDTO;
import pk.edu.iqra.oric.repository.AnnouncementTypeRepository;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.AnnouncementRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.AnnouncementService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("announcements")
public class AnnouncementServiceImpl implements AnnouncementService {


    private AnnouncementRepository repository;
    private AnnouncementTypeRepository announcementTypeRepository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository repository,
                                   UserService userService,
                                   OricSessionRepository oricSessionRepository,
                                   FacultyService facultyService,
                                   AnnouncementTypeRepository announcementTypeRepository) {
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
        this.announcementTypeRepository = announcementTypeRepository;
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

        classObject.setAnnouncementType(announcementTypeRepository.findById(dto.getAnnouncementTypeId()).get());
        dto.setAnnouncementTypeName(classObject.getAnnouncementType().getName());


        dto.setId(repository.save(classObject).getId());

        return dto;
    }


}
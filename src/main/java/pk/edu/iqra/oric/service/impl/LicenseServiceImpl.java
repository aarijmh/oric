package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.License;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.LicenseDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.LicenseRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.LicenseService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.Constants;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("license")
public class LicenseServiceImpl implements LicenseService {

    private LicenseRepository repository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public LicenseServiceImpl(LicenseRepository repository,
                              UserService userService,
                              OricSessionRepository oricSessionRepository,
                              FacultyService facultyService) {
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
    }

    @Override
    public List<License> getResource(Integer oricSessionId) {
        return repository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<LicenseDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x -> new LicenseDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        License classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        LicenseDTO dto = mapper.readValue(dtoString, LicenseDTO.class);

        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new License();
            classObject.setCreatedOn(Instant.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = repository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        LicenseDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(Instant.now());

        List<Integer> userList = new ArrayList<>();

        if (dto.getInventorId() != null)
            userList.add(dto.getInventorId());
        if (dto.getCoInventorId() != null)
            userList.add(dto.getCoInventorId());

        Map<Integer, User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId, x -> x));
        if (dto.getInventorId() != null) {
            classObject.setInventor(userMap.get(dto.getInventorId()));
            dto.setInventorName(UserUtility.getNameFromUser(classObject.getInventor()));
        } else
            classObject.setInventor(null);
        if (dto.getCoInventorId() != null) {
            classObject.setCoInventor(userMap.get(dto.getCoInventorId()));
            dto.setCoInventorName(UserUtility.getNameFromUser(classObject.getCoInventor()));
        } else
            classObject.setCoInventor(null);

        if(dto.getFacultyId() != null && !dto.getFacultyId().equals(0)){
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }
        dto.setId(repository.save(classObject).getId());

        return dto;
    }

    @Override
    public List<LicenseDTO> getResourceDTO(List<License> classObjectList){
        return classObjectList.stream().map(x->new LicenseDTO(x)).collect(Collectors.toList());
    }

    @Override
    public List<License> getResourceForRole(Integer oricSessionId, Integer campusId, String role){
        if(role.equalsIgnoreCase(Constants.UNIVERSITY_ADMINISTRATOR_ROLE.toLowerCase())){
            return repository.findOfOricSession(oricSessionId);
        }

        return repository.findOfCampus(campusId);
    }
}
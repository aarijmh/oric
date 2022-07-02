package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.VisitRepresentative;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.VisitRepresentativeDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.VisitRepresentativeRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.VisitRepresentativeService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("visitrepresentative")
public class VisitRepresentativeServiceImpl implements VisitRepresentativeService {


    private VisitRepresentativeRepository repository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public VisitRepresentativeServiceImpl(VisitRepresentativeRepository repository,
                                          UserService userService,
                                          OricSessionRepository oricSessionRepository,
                                          FacultyService facultyService) {
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
    }

    @Override
    public List<VisitRepresentative> getResource(Integer oricSessionId) {
        return repository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<VisitRepresentativeDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x -> new VisitRepresentativeDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        VisitRepresentative classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        VisitRepresentativeDTO dto = mapper.readValue(dtoString, VisitRepresentativeDTO.class);

        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new VisitRepresentative();
            classObject.setCreatedOn(Instant.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = repository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        VisitRepresentativeDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(Instant.now());

        List<Integer> userList = new ArrayList<>();


        Map<Integer, User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId, x -> x));


        if(dto.getFacultyId() != null && !dto.getFacultyId().equals(0)){
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }

        dto.setId(repository.save(classObject).getId());

        return dto;
    }


}
package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.PolicyCase;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.PolicyCaseDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.PolicyCaseRepository;
import pk.edu.iqra.oric.repository.ResearchContractRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.PolicyService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("policy")
public class PolicyServiceImpl implements PolicyService {

    private PolicyCaseRepository repository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public PolicyServiceImpl(PolicyCaseRepository repository,
                                       UserService userService,
                                       OricSessionRepository oricSessionRepository,
                                       FacultyService facultyService){
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
    }

    @Override
    public List<PolicyCase> getResource(Integer oricSessionId) {
        return repository.findPoliciesOfOricSession(oricSessionId);
    }

    @Override
    public List<PolicyCaseDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x->new PolicyCaseDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        PolicyCase classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        PolicyCaseDTO dto = mapper.readValue(dtoString,PolicyCaseDTO.class);
        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new PolicyCase();
            classObject.setCreatedOn(Instant.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = repository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        PolicyCaseDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(Instant.now());

        List<Integer> userList = new ArrayList<>();

        if(dto.getPiId() != null)
            userList.add(dto.getPiId());
        if(dto.getCoPi1Id() != null)
            userList.add(dto.getCoPi1Id());
        if(dto.getCoPi2Id() != null)
            userList.add(dto.getCoPi2Id());

        Map<Integer,User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId, x->x));
        if(dto.getPiId() != null){
            classObject.setPi(userMap.get(dto.getPiId()));
            dto.setPiName(UserUtility.getNameFromUser(classObject.getPi()));
        }
        else
            classObject.setPi(null);
        if(dto.getCoPi1Id() != null) {
            classObject.setCoPi1(userMap.get(dto.getCoPi1Id()));
            dto.setCoPi1Name(UserUtility.getNameFromUser(classObject.getCoPi1()));
        }
        else
            classObject.setCoPi1(null);
        if(dto.getCoPi2Id() != null){
            classObject.setCoPi1(userMap.get(dto.getCoPi2Id()));
            dto.setCoPi2Name(UserUtility.getNameFromUser(classObject.getCoPi2()));
        }
        else
            classObject.setCoPi2(null);

        if(dto.getFacultyId() != null && !dto.getFacultyId().equals(0)){
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }

        dto.setId(repository.save(classObject).getId());

        return dto;
    }
}

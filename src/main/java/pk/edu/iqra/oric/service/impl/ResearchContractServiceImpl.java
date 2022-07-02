package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.ResearchContract;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.ResearchContractDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.ResearchContractRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.ResearchContractService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("researchcontract")
public class ResearchContractServiceImpl implements ResearchContractService {


    private ResearchContractRepository researchContractRepository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public ResearchContractServiceImpl(ResearchContractRepository researchContractRepository,
                                   UserService userService,
                                   OricSessionRepository oricSessionRepository,
                                   FacultyService facultyService){
        this.researchContractRepository = researchContractRepository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
    }

    @Override
    public List<ResearchContract> getResource(Integer oricSessionId) {
        return researchContractRepository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<ResearchContractDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x->new ResearchContractDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        ResearchContract classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        ResearchContractDTO dto = mapper.readValue(dtoString,ResearchContractDTO.class);

        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new ResearchContract();
            classObject.setCreatedOn(Instant.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = researchContractRepository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        ResearchContractDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(Instant.now());

        List<Integer> userList = new ArrayList<>();

        if(dto.getPiId() != null)
            userList.add(dto.getPiId());
        if(dto.getCoPiId() != null)
            userList.add(dto.getCoPiId());

        Map<Integer,User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId,x->x));
        if(dto.getPiId() != null) {
            classObject.setPi(userMap.get(dto.getPiId()));
            dto.setPiName(UserUtility.getNameFromUser(classObject.getPi()));
        }
        else
            classObject.setPi(null);
        if(dto.getCoPiId() != null) {
            classObject.setCoPi(userMap.get(dto.getCoPiId()));
            dto.setCoPiName(UserUtility.getNameFromUser(classObject.getCoPi()));
        }
        else
            classObject.setCoPi(null);



        if(dto.getFacultyId() != null && !dto.getFacultyId().equals(0)){
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }

        dto.setId(researchContractRepository.save(classObject).getId());

        return dto;
    }
}

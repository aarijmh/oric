package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.JointResearch;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.JointResearchDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.JointResearchRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.JointResearchService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("jointresearch")
public class JointResearchServiceImpl implements JointResearchService {


    private JointResearchRepository repository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public JointResearchServiceImpl(JointResearchRepository repository,
                                    UserService userService,
                                    OricSessionRepository oricSessionRepository,
                                    FacultyService facultyService) {
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
    }

    @Override
    public List<JointResearch> getResource(Integer oricSessionId) {
        return repository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<JointResearchDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x -> new JointResearchDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        JointResearch classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        JointResearchDTO dto = mapper.readValue(dtoString, JointResearchDTO.class);

        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new JointResearch();
            classObject.setCreatedOn(LocalDate.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = repository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        JointResearchDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(LocalDate.now());

        List<Integer> userList = new ArrayList<>();

        if (dto.getPrincipalInvestigatorId() != null)
            userList.add(dto.getPrincipalInvestigatorId());
        if (dto.getCoInvestigator1Id() != null)
            userList.add(dto.getCoInvestigator1Id());
        if (dto.getCoInvestigator2Id() != null)
            userList.add(dto.getCoInvestigator2Id());

        Map<Integer, User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId, x -> x));
        if (dto.getPrincipalInvestigatorId() != null) {
            classObject.setPrincipalInvestigator(userMap.get(dto.getPrincipalInvestigatorId()));
            dto.setPrincipalInvestigatorName(UserUtility.getNameFromUser(classObject.getPrincipalInvestigator()));
        } else
            classObject.setPrincipalInvestigator(null);
        if (dto.getCoInvestigator1Id() != null) {
            classObject.setCoInvestigator1(userMap.get(dto.getCoInvestigator1Id()));
            dto.setCoInvestigator1Name(UserUtility.getNameFromUser(classObject.getCoInvestigator1()));
        } else
            classObject.setCoInvestigator1(null);
        if (dto.getCoInvestigator2Id() != null) {
            classObject.setCoInvestigator2(userMap.get(dto.getCoInvestigator2Id()));
            dto.setCoInvestigator2Name(UserUtility.getNameFromUser(classObject.getCoInvestigator2()));
        } else
            classObject.setCoInvestigator2(null);

        if(dto.getFacultyId() != null){
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }
        dto.setId(repository.save(classObject).getId());

        return dto;
    }


}
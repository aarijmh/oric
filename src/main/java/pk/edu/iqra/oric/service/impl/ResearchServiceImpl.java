package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.Research;
import pk.edu.iqra.oric.domain.ResearchNonHec;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.ResearchDTO;
import pk.edu.iqra.oric.dto.ResearchNonHecDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.ResearchLinkRepository;
import pk.edu.iqra.oric.repository.ResearchRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.ResearchService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.Constants;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("research")
public class ResearchServiceImpl implements ResearchService {


    private ResearchRepository repository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public ResearchServiceImpl(ResearchRepository repository,
                                   UserService userService,
                                   OricSessionRepository oricSessionRepository,
                                   FacultyService facultyService){
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
    }

    @Override
    public List<Research> getResource(Integer oricSessionId) {
        return repository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<ResearchDTO> getResourceDTO(Integer oricSessionId) {

        return repository.findOfOricSession(oricSessionId).stream().map(x->new ResearchDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        Research classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        ResearchDTO dto = mapper.readValue(dtoString, ResearchDTO.class);

        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new Research();
            classObject.setCreatedOn(LocalDate.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = repository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        ResearchDTO.copyFromDto(dto, classObject);
        classObject.setUpdatedBy(creator);
        classObject.setUpdatedOn(LocalDate.now());

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

    @Override
    public List<ResearchDTO> getResourceDTO(List<Research> classObjectList){
        return classObjectList.stream().map(x->new ResearchDTO(x)).collect(Collectors.toList());
    }

    @Override
    public List<Research> getResourceForRole(Integer oricSessionId, Integer campusId, String role){
        if(role.equalsIgnoreCase(Constants.UNIVERSITY_ADMINISTRATOR_ROLE.toLowerCase())){
            return repository.findOfOricSession(oricSessionId);
        }

        return repository.findOfCampus(campusId);
    }
}

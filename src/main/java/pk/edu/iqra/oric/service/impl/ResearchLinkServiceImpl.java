package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.PolicyCase;
import pk.edu.iqra.oric.domain.ResearchLink;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.PolicyCaseDTO;
import pk.edu.iqra.oric.dto.ResearchLinkDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.ResearchLinkRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.ResearchLinkService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("researchlink")
public class ResearchLinkServiceImpl implements ResearchLinkService {

    private ResearchLinkRepository researchLinkRepository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public ResearchLinkServiceImpl(ResearchLinkRepository researchLinkRepository,
                                   UserService userService,
                                   OricSessionRepository oricSessionRepository,
                                   FacultyService facultyService){
        this.researchLinkRepository = researchLinkRepository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
    }

    @Override
    public List<ResearchLink> getResource(Integer oricSessionId) {
        return researchLinkRepository.findResearchLinksOfOricSession(oricSessionId);
    }

    @Override
    public List<ResearchLinkDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x->new ResearchLinkDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception{
        ResearchLink classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        ResearchLinkDTO dto = mapper.readValue(dtoString,ResearchLinkDTO.class);

        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new ResearchLink();
            classObject.setCreatedOn(Instant.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = researchLinkRepository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        ResearchLinkDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(Instant.now());

        List<Integer> userList = new ArrayList<>();

        if(dto.getPiId() != null)
            userList.add(dto.getPiId());

        Map<Integer,User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId,x->x));
        if(dto.getPiId() != null){
            classObject.setPi(userMap.get(dto.getPiId()));
            dto.setPiName(UserUtility.getNameFromUser(classObject.getPi()));
        }
        else
            classObject.setPi(null);


        if(dto.getFacultyId() != null && !dto.getFacultyId().equals(0)){
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }

        dto.setId(researchLinkRepository.save(classObject).getId());

        return dto;
    }
}

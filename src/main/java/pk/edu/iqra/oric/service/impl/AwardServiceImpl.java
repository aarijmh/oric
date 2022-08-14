package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.Award;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.AwardDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.AwardRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.AwardService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.Constants;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("award")
public class AwardServiceImpl implements AwardService {


    private AwardRepository repository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public AwardServiceImpl(AwardRepository repository,
                            UserService userService,
                            OricSessionRepository oricSessionRepository,
                            FacultyService facultyService) {
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
    }

    @Override
    public List<Award> getResource(Integer oricSessionId) {
        return repository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<AwardDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x -> new AwardDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        Award classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        AwardDTO dto = mapper.readValue(dtoString, AwardDTO.class);

        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new Award();
            classObject.setCreatedOn(Instant.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = repository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        AwardDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(Instant.now());

        List<Integer> userList = new ArrayList<>();

        if (dto.getAwardWinnerId() != null)
            userList.add(dto.getAwardWinnerId());

        Map<Integer, User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId, x -> x));
        if (dto.getAwardWinnerId() != null) {
            classObject.setAwardWinner(userMap.get(dto.getAwardWinnerId()));
            dto.setAwardWinnerName(UserUtility.getNameFromUser(classObject.getAwardWinner()));
        } else
            classObject.setAwardWinner(null);

        if(dto.getFacultyId() != null && !dto.getFacultyId().equals(0)){
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }
        dto.setId(repository.save(classObject).getId());

        return dto;
    }

    @Override
    public List<AwardDTO> getResourceDTO(List<Award> classObjectList){
        return classObjectList.stream().map(x->new AwardDTO(x)).collect(Collectors.toList());
    }

    @Override
    public List<Award> getResourceForRole(Integer oricSessionId, Integer campusId, String role){
        if(role.equalsIgnoreCase(Constants.UNIVERSITY_ADMINISTRATOR_ROLE.toLowerCase())){
            return repository.findOfOricSession(oricSessionId);
        }

        return repository.findOfCampus(campusId);
    }


}
package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.OricPosition;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.OricPositionDTO;
import pk.edu.iqra.oric.repository.OricPositionTitleRepository;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.OricPositionRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.OricPositionService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("positions")
public class OricPositionServiceImpl implements OricPositionService {


    private OricPositionRepository repository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    private OricPositionTitleRepository oricPositionTitleRepository;

    @Autowired
    public OricPositionServiceImpl(OricPositionRepository repository,
                                   UserService userService,
                                   OricSessionRepository oricSessionRepository,
                                   FacultyService facultyService,
                                   OricPositionTitleRepository oricPositionTitleRepository) {
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
        this.oricPositionTitleRepository = oricPositionTitleRepository;
    }

    @Override
    public List<OricPosition> getResource(Integer oricSessionId) {
        return repository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<OricPositionDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x -> new OricPositionDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        OricPosition classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        OricPositionDTO dto = mapper.readValue(dtoString, OricPositionDTO.class);

        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new OricPosition();
            classObject.setOricSession(oricSession);

        } else {
            classObject = repository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        OricPositionDTO.copyFromDto(dto, classObject);


        List<Integer> userList = new ArrayList<>();

        if (dto.getUserId() != null)
            userList.add(dto.getUserId());
        Map<Integer, User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId, x -> x));
        if (dto.getUserId() != null) {
            classObject.setUser(userMap.get(dto.getUserId()));
            dto.setUserName(UserUtility.getNameFromUser(classObject.getUser()));
        } else
            classObject.setUser(null);

        if(dto.getPositionId() != null){
            classObject.setPosition(oricPositionTitleRepository.findById(dto.getPositionId()).get());
            dto.setPositionName(classObject.getPosition().getName());
        }
        else{
            classObject.setPosition(null);
        }

        dto.setId(repository.save(classObject).getId());

        return dto;
    }


}
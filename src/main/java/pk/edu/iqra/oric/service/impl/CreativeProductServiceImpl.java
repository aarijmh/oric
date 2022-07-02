package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.CreativeProduct;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.CreativeProductDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.CreativeProductRepository;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.CreativeProductService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("creativeproduct")
public class CreativeProductServiceImpl implements CreativeProductService {


    private CreativeProductRepository repository;
    private UserService userService;

    private FacultyService facultyService;

    private OricSessionRepository oricSessionRepository;

    @Autowired
    public CreativeProductServiceImpl(CreativeProductRepository repository,
                                      UserService userService,
                                      OricSessionRepository oricSessionRepository,
                                      FacultyService facultyService) {
        this.repository = repository;
        this.userService = userService;
        this.oricSessionRepository = oricSessionRepository;
        this.facultyService = facultyService;
    }

    @Override
    public List<CreativeProduct> getResource(Integer oricSessionId) {
        return repository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<CreativeProductDTO> getResourceDTO(Integer oricSessionId) {
        return getResource(oricSessionId).stream().map(x -> new CreativeProductDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        CreativeProduct classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        CreativeProductDTO dto = mapper.readValue(dtoString, CreativeProductDTO.class);

        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new CreativeProduct();
            classObject.setCreatedOn(Instant.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = repository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        CreativeProductDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(Instant.now());

        List<Integer> userList = new ArrayList<>();

        if (dto.getLeadId() != null)
            userList.add(dto.getLeadId());
        if (dto.getCoLeadId() != null)
            userList.add(dto.getCoLeadId());

        Map<Integer, User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId, x -> x));
        if (dto.getLeadId() != null) {
            classObject.setLead(userMap.get(dto.getLeadId()));
            dto.setLeadName(UserUtility.getNameFromUser(classObject.getLead()));
        } else
            classObject.setLead(null);
        if (dto.getCoLeadId() != null) {
            classObject.setCoLead(userMap.get(dto.getCoLeadId()));
            dto.setCoLeadName(UserUtility.getNameFromUser(classObject.getCoLead()));
        } else
            classObject.setCoLead(null);

        if(dto.getFacultyId() != null && !dto.getFacultyId().equals(0)){
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }

        dto.setId(repository.save(classObject).getId());

        return dto;
    }


}
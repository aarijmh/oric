package pk.edu.iqra.oric.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pk.edu.iqra.oric.domain.Oric;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.University;
import pk.edu.iqra.oric.dto.OricDTO;
import pk.edu.iqra.oric.dto.OricSessionDTO;
import pk.edu.iqra.oric.dto.ResearchDTO;
import pk.edu.iqra.oric.dto.UniversityDTO;
import pk.edu.iqra.oric.repository.OricRepository;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.service.FileService;
import pk.edu.iqra.oric.service.OricService;
import pk.edu.iqra.oric.service.UniversityService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OricServiceImpl implements OricService {
    private UniversityService universityService;
    private OricRepository oricRepository;
    private OricSessionRepository oricSessionRepository;

    private UserService userService;

    private FileService fileService;

    @Autowired
    public OricServiceImpl(UserService userService,UniversityService universityService, OricRepository oricRepository, OricSessionRepository oricSessionRepository, FileService fileService) {
        this.universityService = universityService;
        this.oricRepository = oricRepository;
        this.oricSessionRepository = oricSessionRepository;
        this.userService = userService;
        this.fileService = fileService;
    }

    @Override
    public List<OricSessionDTO> getSessionsOfOricOfAdministrator(Integer administratorId) {

        University university = universityService.getUniversityOfAdministrator(administratorId);

        return oricSessionRepository.findOricSessionsOfUniversity(university.getId()).stream().map(x->new OricSessionDTO(x)).collect(Collectors.toList());

    }

    @Override
    public List<OricSessionDTO> getOpenSessionsOfOricOfUniversity(Integer universityId) {
        return oricSessionRepository.findOpenOricSessionsOfUniversity(universityId).stream().map(x->new OricSessionDTO(x)).collect(Collectors.toList());
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public OricSessionDTO saveOricSession(OricSessionDTO oricSessionDTO, Integer administrator) {
        OricSession oricSession = null;
        if(oricSessionDTO.getId() == null || oricSessionDTO.getId().equals(0)){
            oricSession = new OricSession();
            oricSession.setUniversity(universityService.getUniversityOfAdministrator(administrator));
        }
        else{
            oricSession = oricSessionRepository.findById(oricSessionDTO.getId()).get();
        }
        oricSession.setStartDate(UtilityFunctions.stringToLocalDate(oricSessionDTO.getStartDate()));
        oricSession.setEndDate(UtilityFunctions.stringToLocalDate(oricSessionDTO.getEndDate()));
        oricSession.setIsClosed(oricSessionDTO.getIsClosed());
        oricSession.setDescription(oricSessionDTO.getDescription());
        oricSession.setCreatedBy(userService.getUserByUserId(administrator));
        oricSession.setUpdated(LocalDate.now());

        oricSessionRepository.save(oricSession);

        oricSessionDTO.setId(oricSession.getId());

        return oricSessionDTO;
    }

    @Override
    public Oric getOricOfAdministrator(Integer administrator) {
        return oricRepository.findOricOfAdministrator(administrator);
    }

    @Override
    public OricDTO getOricDTOOfAdministrator(Integer administrator) {
        return new OricDTO(getOricOfAdministrator(administrator));
    }

    @Override
    public OricDTO saveOric(OricDTO oricDTO, Integer administrator) {
        Oric oric = oricRepository.findOricOfAdministrator(administrator);
        if(oric == null){
            oric = new Oric();
            oric.setUniversity(universityService.getUniversityOfAdministrator(administrator));
        }

        oric.setName(oricDTO.getName());
        oric.setAddress(oricDTO.getAddress());
        oric.setEmail(oricDTO.getEmail());
        oric.setBankAccountNumber(oricDTO.getBankAccount());
        oric.setWebpageFocalPerson(oricDTO.getFocalPersonWebsite());
        oric.setWebsite(oricDTO.getWebsite());
        oric.setWebsiteShort(oricDTO.getWebsiteShort());
        if(oricDTO.getFocal() != null)
            oric.setFocalPerson(userService.getUserByUserId(oricDTO.getFocal()));
        else
            oric.setFocalPerson(null);

        oricRepository.save(oric);

        oricDTO.setId(oric.getId());
        return oricDTO;
    }

    @Override
    public Boolean verifySessionRequestForUser(Integer userId, Integer oricSessionId) {
        return oricRepository.fincOricSessionByOricSessionIdAndUserId(oricSessionId,userId) != null;
    }


}

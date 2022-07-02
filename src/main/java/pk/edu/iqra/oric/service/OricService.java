package pk.edu.iqra.oric.service;

import org.springframework.web.multipart.MultipartFile;
import pk.edu.iqra.oric.domain.Oric;
import pk.edu.iqra.oric.dto.OricDTO;
import pk.edu.iqra.oric.dto.OricSessionDTO;
import pk.edu.iqra.oric.dto.ResearchDTO;

import java.util.List;

public interface OricService {
    List<OricSessionDTO> getSessionsOfOricOfAdministrator(Integer administratorId);
    OricSessionDTO saveOricSession(OricSessionDTO oricSessionDTO,Integer administrator);

    Oric getOricOfAdministrator(Integer administrator);

    OricDTO getOricDTOOfAdministrator(Integer administrator);

    OricDTO saveOric(OricDTO oricDTO, Integer administrator);

    Boolean verifySessionRequestForUser(Integer userId, Integer oricSessionId);

  }

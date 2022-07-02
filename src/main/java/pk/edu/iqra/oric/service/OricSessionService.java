package pk.edu.iqra.oric.service;

import org.springframework.web.multipart.MultipartFile;
import pk.edu.iqra.oric.domain.PolicyCase;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.PolicyCaseDTO;
import pk.edu.iqra.oric.dto.ResearchDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface OricSessionService {
    List<ResearchDTO> getResearches(Integer oricSessionId, Integer typeId);
    ResearchDTO saveResearch(Integer oricSessionId, Integer userId, ResearchDTO dto)  throws Exception;
    void deleteResearch(Integer oricSessionId, Integer userId, Integer proposalId);

    DtoInterface uploadResearchFiles(Integer oricSessionId, Integer userId, Integer typeId, String dto, List<MultipartFile> files) throws Exception;

    File getFileOfResearch(Integer oricSessionId, Integer researchId, String fileName, Integer typeId) throws IOException;

    void deleteFileOfResearch(Integer oricSessionId, Integer researchId, String fileName, Integer typeId) throws IOException;

    List<String> getFiles(Integer oricSessionId, Integer researchId,Integer typeId);

    List<PolicyCase> getPolicies(Integer oricSessionId);
    List<PolicyCaseDTO> getPoliciesDTO(Integer oricSessionId);

    PolicyCaseDTO savePolicy(Integer oricSessionId, Integer userId, String dto)  throws Exception;


}

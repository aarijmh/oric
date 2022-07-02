package pk.edu.iqra.oric.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pk.edu.iqra.oric.domain.AnnouncementType;
import pk.edu.iqra.oric.domain.OricPositionsTitle;
import pk.edu.iqra.oric.domain.ProposalType;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.FacultyDTO;
import pk.edu.iqra.oric.dto.ResearchDTO;
import pk.edu.iqra.oric.factory.ServiceFactory;
import pk.edu.iqra.oric.service.DataService;
import pk.edu.iqra.oric.service.FileService;
import pk.edu.iqra.oric.service.GenericResourceService;
import pk.edu.iqra.oric.service.OricSessionService;
import pk.edu.iqra.oric.utility.NavigationStore;
import pk.edu.iqra.oric.utility.NavigationUtility;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/data")
public class DataContoller {

    private DataService dataService;

    private OricSessionService oricSessionService;

    private ServiceFactory serviceFactory;

    private FileService fileService;

    @Autowired
    public DataContoller(DataService dataService,OricSessionService oricSessionService,
                         ServiceFactory serviceFactory, FileService fileService){
        this.dataService = dataService;
        this.oricSessionService = oricSessionService;
        this.serviceFactory = serviceFactory;
        this.fileService = fileService;
    }

    @GetMapping("/getFaculties")
    @ResponseBody
    public List<FacultyDTO> getFaculties(Principal principal){
        Integer id = UtilityFunctions.getIdFromPrincipal(principal);
        return dataService.getFacultyDTOForSelect(id);
    }


    @GetMapping("/getProposalTypes")
    @ResponseBody
    public List<ProposalType> getProposalTypes(Principal principal){
        return dataService.getProposalTypes();
    }

    @GetMapping("/getProposalType/{id}")
    @ResponseBody
    public ProposalType getProposalType(@PathVariable("id") Integer id, Principal principal){
        return dataService.getProposalType(id);
    }

    @PostMapping("/uploadFile/oricSession/{oricSessionId}/{resourceType}/")
    @ResponseBody
    public DtoInterface uploadFileResearch(@PathVariable("oricSessionId") Integer oricSessionId,
                                           @PathVariable("resourceType") String resourceType,
                                           String dtoString, List<MultipartFile> files,
                                           Principal principal) throws Exception {
        Integer id = UtilityFunctions.getIdFromPrincipal(principal);

        GenericResourceService service = serviceFactory.getService(resourceType.toLowerCase());

        NavigationStore store = NavigationUtility.navigationMap.get(resourceType.toLowerCase());

        return fileService.uploadFiles(oricSessionId,id,store.getType(),dtoString,files,service);

        // return oricSessionService.uploadResearchFiles(oricSessionId,id,typeId,dtoString,files);
    }

    @GetMapping("/openFileResearch/oricSession/{oricSession}/type/{typeId}/research/{research}/file/{fileName}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> showUploadFile(@PathVariable("oricSession") Integer oricSessionId,
                                                              @PathVariable("research") Integer researchId,
                                                              @PathVariable("fileName") String fileName,
                                                              @PathVariable("typeId") Integer typeId) throws IOException
    {
        File file = oricSessionService.getFileOfResearch(oricSessionId,researchId,fileName,typeId);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName().replace(" ", "%20"))
                .contentLength(file.length()).body(resource);
    }

    @GetMapping("/deleteFileResearch/oricSession/{oricSession}/type/{typeId}/research/{research}/file/{fileName}")
    @ResponseBody
    public void deleteUploadFile(@PathVariable("oricSession") Integer oricSessionId,
                                 @PathVariable("research") Integer researchId,
                                 @PathVariable("fileName") String fileName,
                                 @PathVariable("typeId") Integer typeId) throws IOException {
        oricSessionService.deleteFileOfResearch(oricSessionId,researchId,fileName,typeId);
    }

    @GetMapping("/getFiles/oricSessionId/{oricSessionId}/type/{typeId}/researchId/{researchId}/")
    @ResponseBody
    public List<String> getFiles(@PathVariable("oricSessionId") Integer oricSessionId,
                                          @PathVariable("researchId") Integer researchId,
                                 @PathVariable("typeId") Integer typeId) throws Exception {

        return oricSessionService.getFiles(oricSessionId,researchId,typeId);
    }

    @GetMapping("/getOricPositionTitles")
    @ResponseBody
    public List<OricPositionsTitle> getOricPositionTitles(){
        return dataService.getOricPositionsTitles();
    }


    @GetMapping("/getAnnouncementTypes")
    @ResponseBody
    public List<AnnouncementType> getAnnouncementTypes(){
        return dataService.getAnnouncementTypes();
    }
}

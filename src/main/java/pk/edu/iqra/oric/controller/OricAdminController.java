package pk.edu.iqra.oric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.PolicyCaseDTO;
import pk.edu.iqra.oric.dto.ResearchDTO;
import pk.edu.iqra.oric.dto.ResearchLinkDTO;
import pk.edu.iqra.oric.factory.ServiceFactory;
import pk.edu.iqra.oric.service.*;
import pk.edu.iqra.oric.utility.NavigationStore;
import pk.edu.iqra.oric.utility.NavigationUtility;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/oricAdmin")
public class OricAdminController {

    private OricService oricService;

    private OricSessionService oricSessionService;

    private ResearchLinkService researchLinkService;
    private ResearchContractService researchContractService;
    private PolicyService policyService;

    private ConsultancyContractService consultancyContractService;
    private OricReportService oricReportService;

    private ResearchNonHecService researchNonHecService;

    private ServiceFactory serviceFactory;

    private ResearchService researchService;

    @Autowired
    public OricAdminController(OricService oricService,OricSessionService oricSessionService,
                               ResearchLinkService researchLinkService,
                               ResearchContractService researchContractService,
                               PolicyService policyService,
                               ConsultancyContractService consultancyContractService,
                               OricReportService oricReportService,
                               ResearchNonHecService researchNonHecService,
                               ServiceFactory serviceFactory,ResearchService researchService){
        this.oricService = oricService;
        this.oricSessionService = oricSessionService;
        this.researchLinkService = researchLinkService;
        this.researchContractService = researchContractService;
        this.policyService = policyService;
        this.consultancyContractService = consultancyContractService;
        this.oricReportService = oricReportService;
        this.researchNonHecService = researchNonHecService;
        this.serviceFactory = serviceFactory;
        this.researchService = researchService;
    }

    @GetMapping("/showOricSession")
    public String showOricSession(@RequestParam Integer oricSessionId, Model model, Principal principal){
        model.addAttribute("oricSessionId",oricSessionId);
        return "oricAdmin/showOricSession";
    }

    @GetMapping("/oricSession/{oricSessionId}/showResearches/{typeId}")
    public String showProposalHEC(@PathVariable("oricSessionId") Integer oricSessionId,
                                  @PathVariable("typeId") Integer typeId, Model model, Principal principal){
        model.addAttribute("oricSessionId",oricSessionId);
        model.addAttribute("proposalTypeId",typeId);
        model.addAttribute("typeId",1);
        return "/oricAdmin/research";
    }

    @GetMapping("/oricSession/{oricSessionId}/showResearches/{typeId}/getResearches")
    @ResponseBody
    public List<ResearchDTO> getResearches(@PathVariable("oricSessionId") Integer oricSessionId,
                                           @PathVariable("typeId") Integer typeId){
        return oricSessionService.getResearches(oricSessionId,typeId);
    }

    @PostMapping("/oricSession/{oricSessionId}/saveResearch")
    @ResponseBody
    public ResearchDTO saveProposalHEC(@PathVariable("oricSessionId") Integer oricSessionId,
                                       @RequestBody ResearchDTO researchDTO,
                                       Principal principal) throws Exception {
        Integer id = UtilityFunctions.getIdFromPrincipal(principal);
        return oricSessionService.saveResearch(oricSessionId,id,researchDTO);
    }
    /*
            Policy Case Request
     */
    @GetMapping("/oricSession/{oricSessionId}/showPolicies")
    public String showPolicies(@PathVariable("oricSessionId") Integer oricSessionId,
                                  Model model, Principal principal){
        model.addAttribute("oricSessionId",oricSessionId);
        model.addAttribute("proposalTypeId",0);
        model.addAttribute("typeId",2);
        return "/oricAdmin/policy";
    }

    @GetMapping("/oricSession/{oricSessionId}/getPolicies")
    @ResponseBody
    public List<PolicyCaseDTO> getPolicies(@PathVariable("oricSessionId") Integer oricSessionId
                                          ){
        return oricSessionService.getPoliciesDTO(oricSessionId);
    }

    @PostMapping("/oricSession/{oricSessionId}/savePolicy")
    @ResponseBody
    public PolicyCaseDTO savePolicy(@PathVariable("oricSessionId") Integer oricSessionId,
                                       String policyCaseDTO,
                                       Principal principal) throws Exception {
        Integer id = UtilityFunctions.getIdFromPrincipal(principal);
        return oricSessionService.savePolicy(oricSessionId,id,policyCaseDTO);
    }
    /*
        End Policy Case Request
     */

    /*
          Research Link Request
   */
    @GetMapping("/oricSession/{oricSessionId}/showResource/{resourceType}")
    public String showResource(@PathVariable("oricSessionId") Integer oricSessionId,
                                    @PathVariable("resourceType") String resourceType,
                               Model model, Principal principal){
        model.addAttribute("oricSessionId",oricSessionId);
        if(NavigationUtility.navigationMap.containsKey(resourceType.toLowerCase())){
            NavigationStore store = NavigationUtility.navigationMap.get(resourceType.toLowerCase());
            model.addAttribute("proposalTypeId",0);
            model.addAttribute("typeId",store.getType());
            model.addAttribute("resourceType",resourceType);
            return store.getLandingPage();
        }
        return "access_denied";
    }

    @GetMapping("/oricSession/{oricSessionId}/getResource/{resourceType}")
    @ResponseBody
    public List<? extends DtoInterface> getResources(@PathVariable("oricSessionId") Integer oricSessionId,
                                           @PathVariable("resourceType") String resourceType
    ){
        return serviceFactory.getService(resourceType.toLowerCase()).getResourceDTO(oricSessionId);
    }

    @PostMapping("/oricSession/{oricSessionId}/saveResource/{resourceType}")
    @ResponseBody
    public DtoInterface saveResource(@PathVariable("oricSessionId") Integer oricSessionId,
                                    @PathVariable("resourceType") String resourceType,
                                    String dto,
                                    Principal principal) throws Exception {
        Integer id = UtilityFunctions.getIdFromPrincipal(principal);
        return serviceFactory.getService(resourceType.toLowerCase()).saveResource(oricSessionId,id,dto);
    }
    /*
        End Research Link Request
     */

    private  GenericResourceService serviceResolver(String resourceType){
        if(NavigationUtility.navigationMap.containsKey(resourceType.toLowerCase())) {
            NavigationStore store = NavigationUtility.navigationMap.get(resourceType.toLowerCase());
            switch (store.getType()) {
                case 2:
                    return policyService;
                case 3:
                    return researchLinkService;
                case 4:
                    return researchContractService;
                case 5:
                    return consultancyContractService;
                case 6:
                    return oricReportService;
                case 7:
                    return researchNonHecService;
                default:
                    return null;
            }
        }
        return null;
    }
}

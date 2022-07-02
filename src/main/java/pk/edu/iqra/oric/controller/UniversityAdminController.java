package pk.edu.iqra.oric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pk.edu.iqra.oric.dto.OricDTO;
import pk.edu.iqra.oric.dto.OricSessionDTO;
import pk.edu.iqra.oric.dto.UniversityDTO;
import pk.edu.iqra.oric.dto.UserDTO;
import pk.edu.iqra.oric.service.OricService;
import pk.edu.iqra.oric.service.UniversityService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/universityAdmin")
public class UniversityAdminController {

    private UserService userService;

    private UniversityService universityService;

    private OricService oricService;

    @Autowired
    public UniversityAdminController(UserService userService, UniversityService universityService, OricService oricService){
        this.userService = userService;
        this.universityService = universityService;
        this.oricService = oricService;
    }

    @GetMapping("/")
    public String getUniversityAdminPanel(){
        return "university_admin/university";
    }

    @GetMapping("/showUsers")
    public String showUserPanel(){
        return "university_admin/users";
    }

    @GetMapping("/getUsers")
    @ResponseBody
    public List<UserDTO> getUsers(Principal principal) throws  Exception{
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        return userService.getUsers(id);
    }

    @PostMapping ("/saveUser")
    @ResponseBody
    public UserDTO saveUser(@RequestBody UserDTO userDTO, Principal principal){
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        return userService.saveUser(userDTO,id);
    }

    @PostMapping ("/deleteUser")
    @ResponseBody
    public void deleteUser(Integer id){
        userService.deleteUser(id);
    }

    //
    @GetMapping("/getUniversity")
    @ResponseBody
    public UniversityDTO getUniversity(Principal principal) throws  Exception{
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        return universityService.getUniversityDTOOfAdministrator(id);
    }

    @PostMapping ("/saveUniversity")
    @ResponseBody
    public UniversityDTO saveUniversity(@RequestBody UniversityDTO universityDTO, Principal principal){
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        return universityService.saveUniversity(universityDTO);
    }

    @GetMapping("/showOric")
    public String showOric(Principal principal) throws  Exception{
        return "university_admin/oric";
    }

    @GetMapping ("/getOricSession")
    @ResponseBody
    public List<OricSessionDTO> getOricSession(Principal principal){
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        return oricService.getSessionsOfOricOfAdministrator(id);
    }

    @PostMapping ("/saveOricSession")
    @ResponseBody
    public OricSessionDTO saveOricSession(@RequestBody OricSessionDTO oricSessionDTO, Principal principal){
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        return oricService.saveOricSession(oricSessionDTO,id);
    }


    @GetMapping ("/getOricOfAdministrator")
    @ResponseBody
    public OricDTO getOricOfAdministrator(Principal principal){
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        return oricService.getOricDTOOfAdministrator(id);
    }

    @PostMapping ("/saveOric")
    @ResponseBody
    public OricDTO saveOric(@RequestBody  OricDTO oricDTO, Principal principal){
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        return oricService.saveOric(oricDTO,id);
    }
}

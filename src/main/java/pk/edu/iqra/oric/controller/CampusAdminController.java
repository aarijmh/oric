package pk.edu.iqra.oric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pk.edu.iqra.oric.dto.OricSessionDTO;
import pk.edu.iqra.oric.dto.UserDTO;
import pk.edu.iqra.oric.service.OricService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/campusAdmin")
public class CampusAdminController {
    private UserService userService;

    @Autowired
    public CampusAdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public String getCampusAdminPanel(Principal principal){

        return "campus_admin/campus";
    }
    @GetMapping("/showUsers")
    public String showUserPanel(){
        return "campus_admin/campus_users";
    }

    @PostMapping("/saveUser")
    @ResponseBody
    public UserDTO saveUser(@RequestBody UserDTO userDTO, Principal principal, HttpServletRequest request){
        Integer campusId = (Integer)request.getSession().getAttribute("campus_id");
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        UserDTO uDTO = userService.saveUser(userDTO,id);
        userService.saveUserCampus(campusId,userDTO.getId());
        return uDTO;
    }

    @GetMapping("/getUsers")
    @ResponseBody
    public List<UserDTO> getUsers(Principal principal, HttpServletRequest request) throws  Exception{
        Integer campusId = (Integer)request.getSession().getAttribute("campus_id");
        Integer id  = UtilityFunctions.getIdFromPrincipal(principal);
        return userService.getUsersOfCampus(campusId);
    }

    @GetMapping("/showFaculty")
    public String showFaculty(Principal principal) throws  Exception{
        return "campus_admin/campus_faculty";
    }

    @GetMapping("/showOric")
    public String showOric(Principal principal) throws  Exception{
        return "university_admin/oric";
    }


}

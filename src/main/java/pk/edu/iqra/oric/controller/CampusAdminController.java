package pk.edu.iqra.oric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/campusAdmin")
public class CampusAdminController {
    private UserService userService;

    @Autowired
    public CampusAdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public String getCampusAdminPanel(Principal principal, HttpServletRequest request){

        return "campus_admin/campus";
    }
}

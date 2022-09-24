package pk.edu.iqra.oric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pk.edu.iqra.oric.service.DataService;

@Controller
public class GenericController {
    private DataService dataService;

    @Autowired
    public GenericController(DataService dataService){
        this.dataService = dataService;
    }


    @GetMapping("/")
    public String toHome() {
        return "home";
    }

    @GetMapping("/showAnnouncement")
    public String toAnnouncement(@RequestParam Integer typeId, Model model) {
        model.addAttribute("typeName",dataService.getAnnouncementTypeName(typeId));
        model.addAttribute("typeId",typeId);
        return "public_announcement";
    }

    @GetMapping("/login")
    public String toLoginForm() {
        return "loginForm";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "access_denied";
    }
}

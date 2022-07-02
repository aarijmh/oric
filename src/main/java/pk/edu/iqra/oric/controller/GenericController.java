package pk.edu.iqra.oric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenericController {
    @GetMapping("/")
    public String toLogin() {
        return "loginForm";
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

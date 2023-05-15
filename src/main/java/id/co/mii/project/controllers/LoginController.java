package id.co.mii.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import id.co.mii.project.models.dto.requests.LoginRequest;
import id.co.mii.project.services.LoginService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @GetMapping
    public String loginPage(LoginRequest loginRequest) {
        return "Auth/index";
    }

    @PostMapping
    public String login(LoginRequest loginRequest) {
        if (!loginService.login(loginRequest)) {
            return "redirect:/login?error=true";
        }
        return "redirect:/xxx";
    }

}
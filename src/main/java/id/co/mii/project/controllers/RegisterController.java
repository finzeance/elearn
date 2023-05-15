package id.co.mii.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import id.co.mii.project.models.dto.requests.UserRequest;
import id.co.mii.project.services.RegisterService;
import lombok.AllArgsConstructor;

@Controller
// @RequestMapping("/register")
@AllArgsConstructor
public class RegisterController {

    private RegisterService registerService;

    @GetMapping("/register")
    public String registerPage(UserRequest userRequest) {
        return "Auth/register";
    }

    @GetMapping("/registerTrainer")
    public String registerTrainer(UserRequest userRequest) {
        return "Account/trainerAccount";
    }

    @GetMapping("/registerStudent")
    public String registerStudent(UserRequest userRequest) {
        return "Account/studentAccount";
    }

    @PostMapping("/register")
    public String register(UserRequest userRequest) {
        registerService.create(userRequest);
        return "redirect:/login";
    }
}

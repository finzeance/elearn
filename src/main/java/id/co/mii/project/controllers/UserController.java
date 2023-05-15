package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.User;
import id.co.mii.project.services.UserService;
import java.util.List;

@Controller
// @RequestMapping("/user")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class UserController {
    private UserService userService;

    @GetMapping("/user")
    public String index(Model model) {
        List<User> Users = userService.getAll();
        model.addAttribute("User", Users);
        return "User/index";
    }

    @GetMapping("/usercreate")
    public String createView(User Users, Model model) {
        return "User/create-form";
    }

    @PostMapping("/user")
    public String create(User Users) {
        userService.create(Users);
        return "redirect:/User";
    }

    @GetMapping("/accountupdate")
    public String updateView(Model model) {
        // model.addAttribute("User", userService.getById(id));
        return "Profile/updateAccount";
    }

    @PutMapping("/user/{id}")
    public String update(@PathVariable int id, User Users) {
        userService.update(id, Users);
        return "redirect:/User";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/User";
    }
}

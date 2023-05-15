package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.UserClass;
import id.co.mii.project.services.UserClassService;
import java.util.List;

@Controller
@RequestMapping("/userclass")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class UserClassController {
    private UserClassService userClassService;

    @GetMapping
    public String index(Model model) {
        List<UserClass> userClass = userClassService.getAll();
        model.addAttribute("UserClass", userClass);
        return "UserClass/index";
    }

    @GetMapping("/create")
    public String createView(UserClass userClass, Model model) {
        return "UserClass/create-form";
    }

    @PostMapping
    public String create(UserClass userClass) {
        userClassService.create(userClass);
        return "redirect:/UserClass";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("UserClass", userClassService.getById(id));
        return "UserClass/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, UserClass userClass) {
        userClassService.update(id, userClass);
        return "redirect:/UserClass";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userClassService.delete(id);
        return "redirect:/UserClass";
    }
}

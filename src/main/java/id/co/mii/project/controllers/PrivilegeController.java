package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.Privilege;
import id.co.mii.project.services.PrivilegeService;
import java.util.List;

@Controller
@RequestMapping("/privilege")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class PrivilegeController {
    private PrivilegeService privilegeService;

    @GetMapping
    public String index(Model model) {
        List<Privilege> privileges = privilegeService.getAll();
        model.addAttribute("Privilege", privileges);
        return "Privilege/index";
    }

    @GetMapping("/create")
    public String createView(Privilege privilege, Model model) {
        return "Privilege/create-form";
    }

    @PostMapping
    public String create(Privilege privilege) {
        privilegeService.create(privilege);
        return "redirect:/Privilege";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("Privilege", privilegeService.getById(id));
        return "Privilege/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Privilege privilege) {
        privilegeService.update(id, privilege);
        return "redirect:/Privilege";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        privilegeService.delete(id);
        return "redirect:/Privilege";
    }
}

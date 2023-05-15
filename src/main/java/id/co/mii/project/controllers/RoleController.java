package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.Role;
import id.co.mii.project.services.RoleService;
import java.util.List;

@Controller
@RequestMapping("/role")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class RoleController {
    private RoleService roleService;

    @GetMapping
    public String index(Model model) {
        List<Role> Roles = roleService.getAll();
        model.addAttribute("Role", Roles);
        return "Role/index";
    }

    @GetMapping("/create")
    public String createView(Role Roles, Model model) {
        return "Role/create-form";
    }

    @PostMapping
    public String create(Role Roles) {
        roleService.create(Roles);
        return "redirect:/Role";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("Role", roleService.getById(id));
        return "Role/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Role Roles) {
        roleService.update(id, Roles);
        return "redirect:/Role";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        roleService.delete(id);
        return "redirect:/ClassSegment";
    }
}

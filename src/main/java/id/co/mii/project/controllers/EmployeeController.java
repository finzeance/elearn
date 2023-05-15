package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.Employee;
import id.co.mii.project.services.EmployeeService;
import java.util.List;

@Controller
// @RequestMapping("/profile")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/profile")
    public String index(Model model) {
        return "Profile/profile";
    }

    @GetMapping("/profiletrainer")
    public String indexTrainer(Model model) {
        return "Profile/profileTrainer";
    }

    @GetMapping("/profilemanager")
    public String indexManager(Model model) {
        return "Profile/profileManager";
    }

    @GetMapping("/profilecreate")
    public String createView(Employee employee, Model model) {
        return "Employee/create-form";
    }

    @PostMapping("/profile")
    public String create(Employee employee) {
        employeeService.create(employee);
        return "redirect:/Employee";
    }

    @GetMapping("/profileupdate")
    public String updateView(Model model) {
        // model.addAttribute("Employee", employeeService.getById(id));
        return "Profile/updateProfile";
    }

    @PutMapping("/profile/{id}")
    public String update(@PathVariable int id, Employee employee) {
        employeeService.update(id, employee);
        return "redirect:/Employee";
    }

    @DeleteMapping("/profile/{id}")
    public String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/Employee";
    }
}

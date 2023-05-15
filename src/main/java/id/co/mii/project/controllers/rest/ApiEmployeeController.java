package id.co.mii.project.controllers.rest;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.co.mii.project.models.Employee;
import id.co.mii.project.services.EmployeeService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiEmployeeController {
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee create(@RequestBody @Valid Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable int id, @RequestBody @Valid Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public Employee create(@PathVariable int id) {
        return employeeService.delete(id);
    }
}

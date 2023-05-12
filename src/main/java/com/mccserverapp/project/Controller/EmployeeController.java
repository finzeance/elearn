package com.mccserverapp.project.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccserverapp.project.Model.Employee;
import com.mccserverapp.project.Model.dto.request.EmployeeRequest;
import com.mccserverapp.project.Service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
@PreAuthorize("hasRole('STUDENT')")
public class EmployeeController {

    private EmployeeService employeeService;

    @PreAuthorize("hasAuthority('READ_STUDENT')")
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_STUDENT')")
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_STUDENT')")
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PreAuthorize("hasAuthority('CREATE_STUDENT')")
    @PostMapping("/modelmapper")
    public Employee createWithModelMapper(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.createWithModelMapper(employeeRequest);
    }

    @PreAuthorize("hasAuthority('UPDATE_STUDENT')")
    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @PreAuthorize("hasAuthority('DELETE_STUDENT')")
    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable Integer id) {
        return employeeService.delete(id);
    }

}

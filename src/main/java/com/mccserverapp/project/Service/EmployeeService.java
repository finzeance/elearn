package com.mccserverapp.project.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mccserverapp.project.Model.Employee;
import com.mccserverapp.project.Model.Role;
import com.mccserverapp.project.Model.User;
import com.mccserverapp.project.Model.dto.request.EmployeeRequest;
import com.mccserverapp.project.Repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Integer id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employee not found!!"));

    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee createWithModelMapper(EmployeeRequest employeeRequest) {
        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        User user = modelMapper.map(employeeRequest, User.class);
        user.setPassword(passwordEncoder.encode(employeeRequest.getPassword()));

        List<Role> role = new ArrayList<>();
        role.add(roleService.getById(1));
        user.setRole(role);
        employee.setUser(user);
        user.setEmployee(employee);

        return employeeRepository.save(employee);
    }

    public Employee update(Integer id, Employee employee) {
        getById(id);
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee delete(Integer id) {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }

}

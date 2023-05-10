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
import com.mccserverapp.project.Model.UserClass;
import com.mccserverapp.project.Model.dto.request.UserRequest;
import com.mccserverapp.project.Repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private RoleService roleService;
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Data user not found!!!"));

    }

    public User create(User user) {
        List<Role> role = new ArrayList<>();
        role.add(roleService.getById(1));
        user.setRole(user.getRole());
        return userRepository.save(user);
    }

    public User createWithModelMapper(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        Employee employee = modelMapper.map(userRequest, Employee.class);

        // set password
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        List<Role> role = new ArrayList<>();
        role.add(roleService.getById(1));
        employee.setUser(user);

        user.setEmployee(employee);
        user.setRole(user.getRole());

        // List<Role> role = new ArrayList<>();
        // role.add(roleService.getById(1));
        // user.setRole(role);

        // employee.setUser(user);
        // user.setEmployee(employee);

        return userRepository.save(user);
    }

    public User update(Integer id, User user) {
        getById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    public User delete(Integer id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }

    public User addRole(Integer id, Role role) {
        User user = getById(id);
        List<Role> roles = user.getRole();
        roles.add(roleService.getById(role.getId()));
        user.setRole(roles);
        return userRepository.save(user);
    }

    // public User addClass(Integer id, Kelas kelas){
    // User user = getById(id);
    // List<UserClass> userClass = user.getUserClass();
    // userClass.add(userClass.getById(kelas.getId()));
    // user.setUserClass(userClass);
    // return userRepository.save(user);
    // }
}

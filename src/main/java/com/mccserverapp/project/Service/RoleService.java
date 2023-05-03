// package com.mccserverapp.project.Service;

// import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;

// import com.mccserverapp.project.Model.Role;
// import com.mccserverapp.project.Model.User;
// import com.mccserverapp.project.Repository.RoleRepository;
// import com.mccserverapp.project.Repository.UserRepository;

// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class RoleService {
// private RoleService roleService;
// private RoleRepository roleRepository;

// public List<Role> getAll() {
// return roleRepository.findAll();
// }

// public Role getById(Integer id) {
// return roleRepository
// .findById(id)
// .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role
// not found!!"));
// }

// public Role create(Role role) {
// return roleRepository.save(role);
// }

// public Role update(Integer id, Role role) {
// getById(id);
// role.setId(id);
// return roleRepository.save(role);
// }

// public Role delete(Integer id) {
// Role role = getById(id);
// roleRepository.delete(role);
// return role;
// }

// }

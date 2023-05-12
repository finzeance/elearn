package com.mccserverapp.project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mccserverapp.project.Model.Employee;
import com.mccserverapp.project.Model.Role;
import com.mccserverapp.project.Model.User;
import com.mccserverapp.project.Model.dto.request.LoginRequest;
import com.mccserverapp.project.Model.dto.request.RegisterRequest;
import com.mccserverapp.project.Model.dto.request.UserRequest;
import com.mccserverapp.project.Model.dto.response.LoginResponse;
import com.mccserverapp.project.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

        private AuthenticationManager authenticationManager;
        private UserRepository userRepository;
        private AppUserDetailService appUserDetailService;
        private ModelMapper modelMapper;
        private PasswordEncoder passwordEncoder;
        private RoleService roleService;

        public LoginResponse login(LoginRequest loginRequest) {
                // login request
                UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword());

                // set principle
                Authentication auth = authenticationManager.authenticate(authReq);
                SecurityContextHolder.getContext().setAuthentication(auth);

                User user = userRepository
                                .findByUsernameOrEmployee_Email(loginRequest.getUsername(), loginRequest.getUsername())
                                .get();

                UserDetails userDetails = appUserDetailService.loadUserByUsername(
                                loginRequest.getUsername());

                List<String> authorities = userDetails
                                .getAuthorities()
                                .stream()
                                .map(authority -> authority.getAuthority())
                                .collect(Collectors.toList());

                return new LoginResponse(
                                user.getUsername(),
                                user.getPassword(),
                                authorities);

        }

        // public User create(UserRequest userRequest) {
        // Employee employee = modelMapper.map(userRequest, Employee.class);
        // User user = modelMapper.map(userRequest, User.class);

        // // set password
        // user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        // // set role
        // List<Role> role = new ArrayList<>();
        // role.add(roleService.getById(1));
        // user.setRole(role);

        // employee.setUser(user);
        // user.setEmployee(employee);
        // return userRepository.save(user);
        // }

        public User create(RegisterRequest registerRequest) {
                // harus ditambahin try catch
                if (userRepository.findByUsername(registerRequest.getUsername()).isEmpty()) {
                        try {
                                Employee employee = modelMapper.map(registerRequest, Employee.class);
                                User user = modelMapper.map(registerRequest, User.class);

                                // set password
                                user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

                                // set role
                                List<Role> role = new ArrayList<>();
                                role.add(roleService.getById(1));
                                user.setRole(role);

                                employee.setUser(user);
                                user.setEmployee(employee);
                                return userRepository.save(user);
                        } catch (Exception e) {
                                return null;
                        }
                }
                return null;
        }

}

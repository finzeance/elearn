package com.mccserverapp.project.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccserverapp.project.Model.User;
import com.mccserverapp.project.Model.dto.request.LoginRequest;
import com.mccserverapp.project.Model.dto.request.RegisterRequest;
import com.mccserverapp.project.Model.dto.request.UserRequest;
import com.mccserverapp.project.Model.dto.response.LoginResponse;
import com.mccserverapp.project.Service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public User create(@RequestBody RegisterRequest registerRequest) {
        return authService.create(registerRequest);
    }

}

package com.mccserverapp.project.Model.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {

    private String name;
    private String phone;
    private String email;
    private String nik;
    private String username;
    private String password;
}

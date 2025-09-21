package com.password.manager.application.dto;

import lombok.Data;

@Data
public class PasswordRequest {
    private String service;
    private String username;
    private String password; // texto plano desde frontend (se cifra en backend)
}
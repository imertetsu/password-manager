package com.password.manager.application.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PasswordResponse {
    private Long id;
    private String service;
    private String username;
    private String password; // descifrado antes de devolver
    private LocalDateTime createdAt;
}

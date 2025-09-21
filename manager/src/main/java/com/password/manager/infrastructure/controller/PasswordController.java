package com.password.manager.infrastructure.controller;

import com.password.manager.application.dto.PasswordRequest;
import com.password.manager.application.dto.PasswordResponse;
import com.password.manager.application.service.PasswordService;
import com.password.manager.domain.model.PasswordEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passwords")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Para permitir llamadas desde Angular
public class PasswordController {

    private final PasswordService service;

    @PostMapping
    public ResponseEntity<PasswordResponse> create(@RequestBody PasswordRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PasswordResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}/reveal")
    public ResponseEntity<String> reveal(@PathVariable Long id) {
        return ResponseEntity.ok(service.revealPassword(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

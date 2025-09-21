package com.password.manager.application.service;

import com.password.manager.application.dto.PasswordRequest;
import com.password.manager.application.dto.PasswordResponse;
import com.password.manager.domain.model.PasswordEntry;
import com.password.manager.infrastructure.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PasswordService {

    private final PasswordRepository repository;
    private final CryptoService cryptoService;

    public PasswordResponse create(PasswordRequest request) {
        try {
            String encrypted = cryptoService.encrypt(request.getPassword());

            PasswordEntry entry = PasswordEntry.builder()
                    .service(request.getService())
                    .username(request.getUsername())
                    .passwordEnc(encrypted)
                    .build();

            PasswordEntry saved = repository.save(entry);

            return toResponse(saved, null);
        } catch (Exception e) {
            throw new RuntimeException("Error al cifrar la contraseña", e);
        }
    }

    public List<PasswordResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(entry -> toResponse(entry, null))
                .collect(Collectors.toList());
    }
    public String revealPassword(Long id) {
        PasswordEntry entry = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contraseña no encontrada"));
        try {
            return cryptoService.decrypt(entry.getPasswordEnc());
        } catch (Exception e) {
            throw new RuntimeException("Error al descifrar la contraseña", e);
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PasswordResponse toResponse(PasswordEntry entry, String passwordPlain) {
        return PasswordResponse.builder()
                .id(entry.getId())
                .service(entry.getService())
                .username(entry.getUsername())
                .password(passwordPlain)
                .createdAt(entry.getCreatedAt())
                .build();
    }
}

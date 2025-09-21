package com.password.manager.infrastructure.repository;

import com.password.manager.domain.model.PasswordEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<PasswordEntry, Long> {
}

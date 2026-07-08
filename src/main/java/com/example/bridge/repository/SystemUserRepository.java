package com.example.bridge.repository;

import com.example.bridge.entity.SystemUser;
import com.example.bridge.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {

    Optional<SystemUser> findByUsername(String username);

    List<SystemUser> findByRole(Role role);

    Optional<SystemUser> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
package com.lacertech.lacereats.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacertech.lacereats.database.model.RolesModel;

public interface RoleRepository extends JpaRepository<RolesModel, Integer> {
    Boolean existsByRole(String role);
}

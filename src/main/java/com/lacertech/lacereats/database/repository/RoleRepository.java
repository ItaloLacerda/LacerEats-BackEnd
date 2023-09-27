package com.lacertech.lacereats.database.repository;

import com.lacertech.lacereats.database.model.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface defines a repository for managing RolesModel entities.
 * It extends the JpaRepository interface, which provides basic CRUD operations for RolesModel.
 *
 * @author Italo Lacerda
 */
public interface RoleRepository extends JpaRepository<RolesModel, Integer> {
  boolean existsByRole(String role);
}

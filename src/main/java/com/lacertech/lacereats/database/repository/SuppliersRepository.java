package com.lacertech.lacereats.database.repository;

import com.lacertech.lacereats.database.model.SuppliersModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface defines a repository for managing SuppliersModel entities.
 * It extends the JpaRepository interface, which provides basic CRUD operations for SuppliersModel.
 *
 * @author Italo Lacerda
 */
public interface SuppliersRepository extends JpaRepository<SuppliersModel, Integer> {
    
}

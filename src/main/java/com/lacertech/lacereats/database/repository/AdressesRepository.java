package com.lacertech.lacereats.database.repository;

import com.lacertech.lacereats.database.model.AdressesModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface defines a repository for managing AdressesModel entities.
 * It extends the JpaRepository interface, which provides basic CRUD operations for AdressesModel.
 *
 * @author Italo Lacerda
 */
public interface AdressesRepository extends JpaRepository<AdressesModel, Integer> {
    
}

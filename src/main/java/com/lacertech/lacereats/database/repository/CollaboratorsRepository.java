package com.lacertech.lacereats.database.repository;

import com.lacertech.lacereats.database.model.CollaboratorsModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface defines a repository for managing CollaboratorsModel entities.
 * It extends the JpaRepository interface, which provides basic CRUD 
 * operations for CollaboratorsModel.
 *
 * @author Italo Lacerda
 */
public interface CollaboratorsRepository extends JpaRepository<CollaboratorsModel, Integer> {
    
}
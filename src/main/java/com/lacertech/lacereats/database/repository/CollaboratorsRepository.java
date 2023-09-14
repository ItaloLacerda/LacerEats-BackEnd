package com.lacertech.lacereats.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacertech.lacereats.database.model.CollaboratorsModel;

public interface CollaboratorsRepository extends JpaRepository<CollaboratorsModel, Integer> {
    
}
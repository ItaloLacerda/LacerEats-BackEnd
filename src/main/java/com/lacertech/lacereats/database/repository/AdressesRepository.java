package com.lacertech.lacereats.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacertech.lacereats.database.model.AdressesModel;

public interface AdressesRepository extends JpaRepository<AdressesModel, Integer> {
    
}

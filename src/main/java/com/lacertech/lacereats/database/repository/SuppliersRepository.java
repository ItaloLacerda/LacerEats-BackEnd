package com.lacertech.lacereats.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacertech.lacereats.database.model.SuppliersModel;

public interface SuppliersRepository extends JpaRepository<SuppliersModel, Integer> {
    
}

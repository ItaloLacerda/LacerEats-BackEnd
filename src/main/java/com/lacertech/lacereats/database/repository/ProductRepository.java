package com.lacertech.lacereats.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacertech.lacereats.database.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    
}


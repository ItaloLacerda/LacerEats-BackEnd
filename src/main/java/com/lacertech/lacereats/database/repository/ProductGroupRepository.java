package com.lacertech.lacereats.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacertech.lacereats.database.model.ProductGroupModel;

public interface ProductGroupRepository extends JpaRepository<ProductGroupModel, Integer> {
    Boolean existsByDescription(String description);
}
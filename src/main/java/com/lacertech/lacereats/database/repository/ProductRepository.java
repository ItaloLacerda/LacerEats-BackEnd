package com.lacertech.lacereats.database.repository;

import com.lacertech.lacereats.database.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface defines a repository for managing ProductModel entities.
 * It extends the JpaRepository interface, which provides basic CRUD operations for ProductModel.
 *
 * @author Italo Lacerda
 */
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
  boolean existsByDescription(String description);
  
  boolean existsByBarCode(String barCode);
}


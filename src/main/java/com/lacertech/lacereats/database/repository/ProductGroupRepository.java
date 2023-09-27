package com.lacertech.lacereats.database.repository;

import com.lacertech.lacereats.database.model.ProductGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface defines a repository for managing ProductGroupModel entities.
 * It extends the JpaRepository interface, which provides basic CRUD 
 * operations for ProductGroupModel.
 *
 * @author Italo Lacerda
 */
public interface ProductGroupRepository extends JpaRepository<ProductGroupModel, Integer> {
  boolean existsByDescription(String description);
}
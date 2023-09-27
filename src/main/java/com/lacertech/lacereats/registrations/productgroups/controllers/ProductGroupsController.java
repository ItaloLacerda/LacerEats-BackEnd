package com.lacertech.lacereats.registrations.productgroups.controllers;

import com.lacertech.lacereats.controllers.interfaces.CommonController;
import com.lacertech.lacereats.dto.productgroupsDTO.ProductGroupsDTO;
import com.lacertech.lacereats.dto.productgroupsDTO.ProductGroupsResponseDTO;
import com.lacertech.lacereats.registrations.productgroups.services.ProductGroupService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents a controller for handling product group-related 
 * HTTP requests and responses.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
@RestController
@RequestMapping(path = "/registrations/product groups", produces = "application/json")
public class ProductGroupsController 
    implements CommonController<ProductGroupsResponseDTO, ProductGroupsDTO> {

  @Autowired
  private ProductGroupService productGroupService;
  
  @GetMapping
  public ResponseEntity<List<ProductGroupsResponseDTO>> searchAll() {
    return new ResponseEntity<>(productGroupService.searchAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProductGroupsResponseDTO> register(
      @RequestBody 
      @Valid 
      ProductGroupsDTO productGroup
  ) {
    ProductGroupsResponseDTO newProductGroup = productGroupService.post(productGroup);
    return new ResponseEntity<>(newProductGroup, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductGroupsResponseDTO> searchById(@PathVariable Integer id) {
    return new ResponseEntity<>(productGroupService.searchById(id), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductGroupsResponseDTO> update(
      @PathVariable 
      Integer id, 
      @RequestBody 
      @Valid 
      ProductGroupsDTO productGroup
  ) {
    return new ResponseEntity<>(productGroupService.update(id, productGroup), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    productGroupService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

package com.lacertech.lacereats.registrations.products.controllers;

import com.lacertech.lacereats.controllers.interfaces.CommonController;
import com.lacertech.lacereats.dto.productDTO.ProductDTO;
import com.lacertech.lacereats.dto.productDTO.ProductResponseDTO;
import com.lacertech.lacereats.registrations.products.services.ProductService;
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
 * This class represents a controller for handling product-related HTTP requests and responses.
 *
 * @author Italo Lacerda
 * @since 2.0 
 */
@RestController
@RequestMapping(path = "/registrations/product")
public class ProductController implements CommonController<ProductResponseDTO, ProductDTO> {

  @Autowired
  private ProductService productService;
  
  @GetMapping
  public ResponseEntity<List<ProductResponseDTO>> searchAll() {
    return new ResponseEntity<>(productService.searchAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProductResponseDTO> register(@RequestBody @Valid ProductDTO product) {
    ProductResponseDTO newProduct = productService.post(product);
    return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponseDTO> searchById(@PathVariable Integer id) {
    ProductResponseDTO product = productService.searchById(id); 
    return new ResponseEntity<>(product, HttpStatus.OK); 
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductResponseDTO> update(
      @PathVariable Integer id,
      @RequestBody ProductDTO product
  ) {
    ProductResponseDTO updatedProduct = productService.update(id, product);
    return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

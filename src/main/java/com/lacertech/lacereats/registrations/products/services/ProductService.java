package com.lacertech.lacereats.registrations.products.services;

import com.lacertech.lacereats.database.model.ProductModel;
import com.lacertech.lacereats.database.repository.ProductGroupRepository;
import com.lacertech.lacereats.database.repository.ProductRepository;
import com.lacertech.lacereats.dto.productDTO.ProductDTO;
import com.lacertech.lacereats.dto.productDTO.ProductResponseDTO;
import com.lacertech.lacereats.exceptions.ExistingAttributeException;
import com.lacertech.lacereats.exceptions.IdNotFoundException;
import com.lacertech.lacereats.services.interfaces.CommonService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class represents a service for managing product-related operations.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
@Getter
@Service
public class ProductService implements CommonService<ProductResponseDTO, ProductDTO> {
    
  @Autowired
  private ProductRepository productRepository ;

  @Autowired
  private ProductGroupRepository productGroupRepository;

  private final String objectName;
  private final String idNotFoundMensage;

  private ProductService() {
    objectName = "ProductService";
    idNotFoundMensage = "Id not found, please enter a valid id.";
  }

  /**
   * Creates a new product based on the provided ProductDTO.
   *
   * @param productDTO The ProductDTO containing product information.
   * @return A ProductResponseDTO representing the created product.
   * @throws ExistingAttributeException  if the description or barCode provided is 
   *     already registered.
   */
  public ProductResponseDTO post(ProductDTO productDTO) {

    if (productIsValid(productDTO.description(), productDTO.barCode())) {

      ProductModel productData = new ProductModel(
          productDTO.description(),
          productDTO.barCode(),
          productDTO.costPrice(),
          productDTO.salePrice(),
          productDTO.productGroup(),
          productDTO.status()
          );

      ProductModel product = productRepository.save(productData);
      return ProductResponseDTO.turnsIntoDTO(product);

    }

    return null;
  }

  /**
   * Retrieves a list of all products.
   *
   * @return A list of ProductResponseDTO objects representing all products.
   */
  public List<ProductResponseDTO> searchAll() {
    List<ProductModel> listProducts = productRepository.findAll();
    return listProducts.stream()
                        .map(ProductResponseDTO::new)
                        .collect(Collectors.toList());
  }

  /**
   * Retrieves a product by its unique identifier (ID).
   *
   * @param id The ID of the product to retrieve.
   * @return A ProductResponseDTO representing the retrieved product.
   * @throws IdNotFoundException if the provided ID is not found.
   */
  public ProductResponseDTO searchById(Integer id) {
     
    if (productRepository.existsById(id)) {
      return new ProductResponseDTO(productRepository.findById(id).get());       
    } else {
      throw new IdNotFoundException(idNotFoundMensage, objectName);
    }
  }

  /**
   * Updates an existing product based on the provided ID and ProductDTO.
   *
   * @param id      The ID of the product to update.
   * @param product The ProductDTO containing updated product information.
   * @return A ProductResponseDTO representing the updated product.
   * @throws IdNotFoundException if the provided ID is not found.
   * @throws ExistingAttributeException  if the description or barCode provided is 
   *     already registered.
   */
  public ProductResponseDTO update(Integer id, ProductDTO product) {

    ProductModel productModel = productRepository.getReferenceById(id);

    if (productModel != null 
        && updateIsValid(product.description(), product.barCode(), productModel)) {

      ProductModel productData = new ProductModel(
          id,
          product.description(),
          product.ncm(),
          product.barCode(),
          product.costPrice(),
          product.salePrice(),
          product.productGroup(),
          product.status());
  
      ProductModel saveProduct = productRepository.save(productData);
      return ProductResponseDTO.turnsIntoDTO(saveProduct);

    } else {

      throw new IdNotFoundException(idNotFoundMensage, objectName);
    
    }
  }

  /**
   * Deletes a product by its unique identifier (ID).
   *
   * @param id The ID of the product to delete.
   * @throws IdNotFoundException if the provided ID is not found.
   */
  public void delete(Integer id) {
    if (productRepository.existsById(id)) {
      productRepository.deleteById(id);       
    } else {
      throw new IdNotFoundException(idNotFoundMensage, objectName);
    }
  }

  private boolean validDescription(String description) {
    if (productRepository.existsByDescription(description)) {
      throw new ExistingAttributeException(
        "Description in use, please enter a new value.",
        objectName, 
        "description");
    }

    return true;
  }

  private boolean validateBarCode(String barCode) {
    if (productRepository.existsByBarCode(barCode)) {
      throw new ExistingAttributeException(
        "BarCode in use, please enter a new value.",
        objectName, 
        "barCode");
    }

    return true;
  } 

  private boolean productIsValid(String description, String barCode) {
    return validDescription(description) && validateBarCode(barCode);
  }

  private boolean updateIsValid(String newDescription, String newBarCode, ProductModel product) {
    
    if (!newDescription.equals(product.getDescription())) {
      validDescription(newDescription);
    }

    if (!newBarCode.equals(product.getBarCode())) {
      validateBarCode(newBarCode);
    }

    return true;
  }
}
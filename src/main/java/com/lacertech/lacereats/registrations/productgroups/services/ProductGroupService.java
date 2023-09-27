package com.lacertech.lacereats.registrations.productgroups.services;

import com.lacertech.lacereats.database.model.ProductGroupModel;
import com.lacertech.lacereats.database.repository.ProductGroupRepository;
import com.lacertech.lacereats.dto.productgroupsDTO.ProductGroupsDTO;
import com.lacertech.lacereats.dto.productgroupsDTO.ProductGroupsResponseDTO;
import com.lacertech.lacereats.exceptions.ExistingAttributeException;
import com.lacertech.lacereats.exceptions.IdNotFoundException;
import com.lacertech.lacereats.services.interfaces.CommonService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class represents a service for managing product group-related operations.
 *
 * @author Italo Lacerda
 * @since 2.0 
 */
@Getter
@Service
public class ProductGroupService 
    implements CommonService<ProductGroupsResponseDTO, ProductGroupsDTO> {
    
  @Autowired
  private ProductGroupRepository productGroupRepository;  
  private final String objectName;
  private final String idNotFoundMensage;  

  private ProductGroupService() {
    objectName = "ProductGroupService";
    idNotFoundMensage = "Id not found, please enter a valid id.";
  } 

  /**
   * Creates a new product group based on the provided ProductGroupsDTO.
   *
   * @param productGroup The ProductGroupsDTO containing product group information.
   * @return A ProductGroupsResponseDTO representing the created product group.
   * @throws ExistingAttributeException if the description already exists.
   */
  public ProductGroupsResponseDTO post(ProductGroupsDTO productGroup) {
    
    if (!productGroupRepository.existsByDescription(productGroup.description())) {
      ProductGroupModel productGroupData = new ProductGroupModel(
          productGroup.description(),
          productGroup.showInMobile(),
          productGroup.showInTerminal(),
          productGroup.status());

      return ProductGroupsResponseDTO.turnsIntoDTO(productGroupRepository.save(productGroupData));
    } else {
      throw new ExistingAttributeException(
        "Description in use, please enter a new value.", objectName, "description");
    }
  }

  /**
   * Retrieves a list of all product groups.
   *
   * @return A list of ProductGroupsResponseDTO objects representing all product groups.
   */
  public List<ProductGroupsResponseDTO> searchAll() {
    List<ProductGroupModel> listProductGroup = productGroupRepository.findAll();
    return listProductGroup.stream()
                           .map(ProductGroupsResponseDTO::new)
                           .collect(Collectors.toList());
  }

  /**
   * Retrieves a product group by its unique identifier (ID).
   *
   * @param id The ID of the product group to retrieve.
   * @return A ProductGroupsResponseDTO representing the retrieved product group.
   * @throws IdNotFoundException if the provided ID is not found.
   */
  public ProductGroupsResponseDTO searchById(Integer id) {
    
    if(productGroupRepository.existsById(id)) {
      return ProductGroupsResponseDTO.turnsIntoDTO(productGroupRepository.findById(id).get());
    } else {
      throw new IdNotFoundException(idNotFoundMensage, objectName);
    }
  }

  /**
   * Updates an existing product group based on the provided ID and ProductGroupsDTO.
   *
   * @param id The ID of the product group to update.
   * @param productGroup The ProductGroupsDTO containing updated product group information.
   * @return A ProductGroupsResponseDTO representing the updated product group.
   * @throws IdNotFoundException if the provided ID is not found.
   * @throws ExistingAttributeException if the description already exists.
   */
  public ProductGroupsResponseDTO update(Integer id, ProductGroupsDTO productGroup) {
    
    if (productGroupRepository.existsById(id)) {
      if (!productGroupRepository.existsByDescription(productGroup.description())) {  
        ProductGroupModel productGroupData = new ProductGroupModel(
            productGroup.description(),
            productGroup.showInMobile(),
            productGroup.showInTerminal(),
            productGroup.status());

        return ProductGroupsResponseDTO.turnsIntoDTO(productGroupRepository.save(productGroupData));
      } else {
        throw new ExistingAttributeException(
            "Description in use, please enter a new value.", objectName, "description");
      }

    } else {
      throw new IdNotFoundException(idNotFoundMensage, objectName);
    }
  }

  /**
   * Deletes a product group by its unique identifier (ID).
   *
   * @param id The ID of the product group to delete.
   * @throws IdNotFoundException if the provided ID is not found.
   */
  public void delete(Integer id) {
    if (productGroupRepository.existsById(id)) {
      productGroupRepository.deleteById(id);
    } else {
      throw new IdNotFoundException(idNotFoundMensage, objectName);
    }
  }

}
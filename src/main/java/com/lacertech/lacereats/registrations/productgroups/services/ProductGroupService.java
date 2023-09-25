package com.lacertech.lacereats.registrations.productgroups.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacertech.lacereats.database.model.ProductGroupModel;
import com.lacertech.lacereats.database.repository.ProductGroupRepository;
import com.lacertech.lacereats.dto.productgroupsDTO.ProductGroupsDTO;
import com.lacertech.lacereats.dto.productgroupsDTO.ProductGroupsResponseDTO;
import com.lacertech.lacereats.exceptions.ExistingAttributeException;
import com.lacertech.lacereats.exceptions.IdNotFoundException;
import com.lacertech.lacereats.services.interfaces.CommonService;

import lombok.Getter;

@Getter
@Service
public class ProductGroupService implements CommonService<ProductGroupsResponseDTO, ProductGroupsDTO> {
    
    @Autowired
    private ProductGroupRepository productGroupRepository;

    private final String objectName;
    private final String idNotFoundMensage;

    private ProductGroupService() {
        objectName = "ProductGroupService";
        idNotFoundMensage = "Id not found, please enter a valid id.";
    }

    public ProductGroupsResponseDTO post(ProductGroupsDTO productGroup) {
        if (!productGroupRepository.existsByDescription(productGroup.description())) {
            ProductGroupModel productGroupData = new ProductGroupModel(productGroup.description(), productGroup.showInMobile(), productGroup.showInTerminal(), productGroup.status());
            return ProductGroupsResponseDTO.turnsIntoDTO(productGroupRepository.save(productGroupData));
        } else {
            throw new ExistingAttributeException("Description in use, please enter a new value.", objectName, "description");
        }
    }

    public List<ProductGroupsResponseDTO> searchAll() {
        List<ProductGroupModel> listProductGroup = productGroupRepository.findAll();
        return listProductGroup.stream()
                               .map(ProductGroupsResponseDTO::new)
                               .collect(Collectors.toList());
    }

    public ProductGroupsResponseDTO searchById(Integer id) {
        if(productGroupRepository.existsById(id)) {
            return ProductGroupsResponseDTO.turnsIntoDTO(productGroupRepository.findById(id).get());
        } else {
            throw new IdNotFoundException(idNotFoundMensage, objectName);
        }
    }

    public ProductGroupsResponseDTO update(Integer id, ProductGroupsDTO productGroup) {
        if(productGroupRepository.existsById(id)) {
            if (!productGroupRepository.existsByDescription(productGroup.description())) {

            ProductGroupModel productGroupData = new ProductGroupModel(productGroup.description(), productGroup.showInMobile(), productGroup.showInTerminal(), productGroup.status());
            return ProductGroupsResponseDTO.turnsIntoDTO(productGroupRepository.save(productGroupData));
            } else {
                throw new ExistingAttributeException("Description in use, please enter a new value.", objectName, "description");
            }

        } else {
            throw new IdNotFoundException(idNotFoundMensage, objectName);
        }
    }

    public void delete(Integer id) {
        if (productGroupRepository.existsById(id)) {
            productGroupRepository.deleteById(id);
        } else {
            throw new IdNotFoundException(idNotFoundMensage, objectName);
        }
    }

}
package com.lacertech.lacereats.registrations.productgroups.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacertech.lacereats.database.model.ProductGroupModel;
import com.lacertech.lacereats.database.repository.ProductGroupRepository;
import com.lacertech.lacereats.dto.productgroupsDTO.ProductGroupsDTO;

@Service
public class ProductGroupService {
    
    @Autowired
    private ProductGroupRepository productGroupRepository;

    public void create(ProductGroupsDTO productGroup) {
        ProductGroupModel productGroupData = new ProductGroupModel(productGroup.description(), productGroup.showInMobile(), productGroup.showInTerminal(), true);
        productGroupRepository.save(productGroupData);
        return;
    }

    public List<ProductGroupsDTO> searchAll() {
        List<ProductGroupModel> listProductGroup = productGroupRepository.findAll();
        return listProductGroup.stream()
                               .map(ProductGroupsDTO::new)
                               .collect(Collectors.toList());
    }

    public ProductGroupsDTO searchById(Integer id) {
        
        return new ProductGroupsDTO(productGroupRepository.findById(id).get());
    }

    public void update(ProductGroupsDTO productGroup) {
        ProductGroupModel productGroupData = new ProductGroupModel(productGroup.id(), productGroup.description(), productGroup.showInMobile(), productGroup.showInTerminal(), productGroup.status());
        productGroupRepository.save(productGroupData);
        return;
    }

    public void delete(Integer id) {
        productGroupRepository.deleteById(id);
        return;
    }
}
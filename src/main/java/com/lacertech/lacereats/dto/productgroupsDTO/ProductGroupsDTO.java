package com.lacertech.lacereats.dto.productgroupsDTO;

import com.lacertech.lacereats.database.model.ProductGroupModel;

public record ProductGroupsDTO(Integer id, String description, Boolean showInMobile, Boolean showInTerminal, Boolean status) {
    
    public ProductGroupsDTO(ProductGroupModel productGroup) {
        this(productGroup.getId(), productGroup.getDescription(), productGroup.getShowInMobile(), productGroup.getShowInTerminal(), productGroup.getStatus());
    }
}

package com.lacertech.lacereats.dto.productgroupsDTO;

import com.lacertech.lacereats.database.model.ProductGroupModel;

public record ProductGroupsResponseDTO(Integer id, String description, Boolean showInMobile, Boolean showInTerminal, Boolean status) {
    public ProductGroupsResponseDTO(ProductGroupModel productGroup) {
        this(productGroup.getId(), productGroup.getDescription(), productGroup.getShowInMobile(), productGroup.getShowInTerminal(), productGroup.getStatus());
    }

    public static ProductGroupsResponseDTO turnsIntoDTO(ProductGroupModel productGroup) {
        return new ProductGroupsResponseDTO(productGroup.getId(), productGroup.getDescription(), productGroup.getShowInMobile(), productGroup.getShowInTerminal(), productGroup.getStatus());
    }
}

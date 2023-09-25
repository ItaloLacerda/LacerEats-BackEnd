package com.lacertech.lacereats.dto.productgroupsDTO;

import com.lacertech.lacereats.database.model.ProductGroupModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductGroupsDTO(
    @NotBlank(message = "{description.not.blank}") 
    String description,

    @NotNull(message = "{showInMobile.not.null}") 
    Boolean showInMobile,

    @NotNull(message = "{showInTerminal.not.null}") 
    Boolean showInTerminal,
    
    @NotNull(message = "{status.not.null}")
    Boolean status) {

    public ProductGroupsDTO(ProductGroupModel productGroup) {
        this(productGroup.getDescription(), productGroup.getShowInMobile(), productGroup.getShowInTerminal(), productGroup.getStatus());
    }
}

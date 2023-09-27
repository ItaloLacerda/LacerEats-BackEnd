package com.lacertech.lacereats.dto.productDTO;

import com.lacertech.lacereats.database.model.ProductGroupModel;
import com.lacertech.lacereats.database.model.ProductModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
    @NotBlank(message = "{description.not.blank}")
    String description, 
    String ncm, 
    @NotNull(message = "{costPrice.not.null}")
    Float costPrice,
    @NotNull(message = "{salePrice.not.null}") 
    Float salePrice, 
    String barCode, 
    @NotNull(message = "{status.not.null}")
    Boolean status,
    @NotNull(message = "{productGroup.not.blank}") 
    ProductGroupModel productGroup) {
    
    public ProductDTO(ProductModel product) {
        this(product.getDescription(), product.getNcm(), product.getCostPrice(), product.getSalePrice(), product.getBarCode(), product.getStatus(), product.getProductGroup());
    }
}

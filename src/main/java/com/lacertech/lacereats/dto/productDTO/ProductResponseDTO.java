package com.lacertech.lacereats.dto.productDTO;

import com.lacertech.lacereats.database.model.ProductGroupModel;
import com.lacertech.lacereats.database.model.ProductModel;

public record ProductResponseDTO(
    Integer id, 
    String description, 
    String ncm, 
    Float costPrice, 
    Float salePrice, 
    String barCode, 
    Boolean status, 
    ProductGroupModel productGroup) {
    
    public ProductResponseDTO(ProductModel product) {
        this(product.getId(), product.getDescription(), product.getNcm(), product.getCostPrice(), product.getSalePrice(), product.getBarCode(), product.getStatus(), product.getProductGroup());
    }

    public static ProductResponseDTO turnsIntoDTO(ProductModel product) {
        return new ProductResponseDTO(product.getId(), product.getDescription(), product.getNcm(), product.getCostPrice(), product.getSalePrice(), product.getBarCode(), product.getStatus(), product.getProductGroup());
    }
}

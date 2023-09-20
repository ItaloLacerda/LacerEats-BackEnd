package com.lacertech.lacereats.database.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_products")
    private Integer id;

    @Column(length = 90, nullable = false, unique = true)
    private String description;

    @Column
    private String ncm;

    @Column(name = "cost_price", nullable = false)
    private Float costPrice; 

    @Column(name = "sale_price", nullable = false)
    private Float salePrice;
    
    @Column(length = 45, name = "bar_code", nullable = false, unique = true)
    private String barCode;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_product_group", nullable = false)
    private ProductGroupModel productGroup;

    @ManyToMany(mappedBy = "products")
    private Set<SuppliersModel> suppliers;

    public ProductModel() {}

    public ProductModel(
        String description,
        String barCode,
        Float costPrice,
        Float salePrice,
        ProductGroupModel productGroup,
        Boolean status
        ) {
        this.description = description;
        this.barCode = barCode;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.productGroup = productGroup;
        this.status = status;    
    }

    public ProductModel(Integer id, String description, String ncm,String barCode, Float costPrice, Float salePrice,
            ProductGroupModel productGroup, Boolean status) {
        this.id = id;
        this.description = description;
        this.ncm = ncm;
        this.barCode = barCode;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.productGroup = productGroup;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public Float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ProductGroupModel getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroupModel productGroup) {
        this.productGroup = productGroup;
    }

    public Set<SuppliersModel> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<SuppliersModel> suppliers) {
        this.suppliers = suppliers;
    }
}

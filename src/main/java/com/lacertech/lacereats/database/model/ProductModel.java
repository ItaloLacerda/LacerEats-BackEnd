package com.lacertech.lacereats.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


/**
 * This class represents a product model in the system.
 * A product has various information including description, barcode, cost price,
 * selling price, product group, status and associated suppliers.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
@Getter
@Setter
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
  
  @Column(length = 45, name = "bar_code", unique = true)
  private String barCode;

  @Column(nullable = false)
  private Boolean status;

  @ManyToOne
  @JoinColumn(name = "id_product_group", nullable = false)
  private ProductGroupModel productGroup;

  @ManyToMany(mappedBy = "products")
  private Set<SuppliersModel> suppliers;

  public ProductModel() {}
  /**
   * Constructor to create a new product.
   *
   * @param description The product description.
   * @param barCode The product barcode.
   * @param costPrice The product cost price.
   * @param salePrice The product sale price.
   * @param productGroup The product group to which the product belongs.
   * @param status The product status.
   */

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

  /**
   * Constructor to create a product with an existing ID.
   *
   * @param id The unique ID of the product.
   * @param description The product description.
   * @param ncm The NCM of the product.
   * @param barCode The product barcode.
   * @param costPrice The product cost price.
   * @param salePrice The product sale price.
   * @param productGroup The product group to which the product belongs.
   * @param status The product status.
   */
  
  public ProductModel(
      Integer id, 
      String description,
      String ncm,
      String barCode,
      Float costPrice,
      Float salePrice,
      ProductGroupModel productGroup,
      Boolean status
  ) {
    this.id = id;
    this.description = description;
    this.ncm = ncm;
    this.barCode = barCode;
    this.costPrice = costPrice;
    this.salePrice = salePrice;
    this.productGroup = productGroup;
    this.status = status; 
  }
}

package com.lacertech.lacereats.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

/**
 * This class represents a product group model entity.
 * It is used to store information about product groups in the application.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
@Entity
@Getter
@Table(name = "product_group")
public class ProductGroupModel {
    
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_product_group")
  private Integer id;

  @Column(length = 45, nullable = false, unique = true)
  private String description;

  @Column(name = "show_in_mobile", nullable = false)
  private Boolean showInMobile;

  @Column(name = "show_in_terminal", nullable = false)
  private Boolean showInTerminal;

  @Column(nullable = false)
  private Boolean status;

  public ProductGroupModel() {}

  /**
   * Constructor for creating a new product group.
   *
   * @param description    The description of the product group.
   * @param showInMobile   Indicates whether the product group is shown in the mobile application.
   * @param showInTerminal Indicates whether the product group is shown in the terminal application.
   * @param status         The status of the product group.
   */
  public ProductGroupModel(
      String description,
      Boolean showInMobile,
      Boolean showInTerminal,
      boolean status
  ) {
    this.description = description;
    this.showInMobile = showInMobile;
    this.showInTerminal = showInTerminal;
    this.status = status;
  }

  /**
   * Constructor for creating a product group with an existing ID.
   *
   * @param id             The unique identifier for the product group.
   * @param description    The description of the product group.
   * @param showInMobile   Indicates whether the product group is shown in the mobile application.
   * @param showInTerminal Indicates whether the product group is shown in the terminal application.
   * @param status         The status of the product group.
   */
  public ProductGroupModel(
      Integer id,
      String description,
      Boolean showInMobile,
      Boolean showInTerminal,
      Boolean status
  ) {
    this.id = id;
    this.description = description;
    this.showInMobile = showInMobile;
    this.showInTerminal = showInTerminal;
    this.status = status;
  }
}

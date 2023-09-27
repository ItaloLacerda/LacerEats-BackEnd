package com.lacertech.lacereats.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;


/**
 * This class represents a supplier model entity.
 * It is used to store information about suppliers in the application.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
@Entity
@Getter
@Table(name = "suppliers")
public class SuppliersModel {
    
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_supplier")
  private Integer id;

  @Column(length = 60, name = "supplier_name", nullable = false)
  private String supplierName;

  @Column(length = 60, name = "fantasy_name", nullable = false)
  private String fantasyName;

  @Column(length = 45, name = "email", nullable = false)
  private String email;

  @Column(length = 11, name = "cell_phone", nullable = false)
  private Long cellPhone;

  @Column(length = 2, name = "state_registration")
  private String stateRegistration;
  
  @Column(length = 14, name = "cnpj", nullable = false, unique = true)
  private Long cpnj;

  @Column(length = 60)
  private String site;

  @Column(nullable = false)
  private Boolean status;

  @ManyToOne
  @JoinColumn(name = "id_adresses")
  private AdressesModel adresses;

  @ManyToMany
  @JoinTable(name = "product_supplier_relationship",
            joinColumns = @JoinColumn(name = "id_suppliers"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
  private Set<ProductModel> products;

  public SuppliersModel() {}

  /**
   * Constructor for creating a supplier with an existing ID.
   *
   * @param id               The unique identifier for the supplier.
   * @param supplierName     The name of the supplier.
   * @param fantasyName      The fantasy name of the supplier.
   * @param email            The email address of the supplier.
   * @param cellPhone        The cell phone number of the supplier.
   * @param stateRegistration The state registration of the supplier.
   * @param cpnj             The CNPJ of the supplier.
   * @param site             The website URL of the supplier.
   * @param status           The status of the supplier.
   * @param adresses         The address of the supplier.
   */
  public SuppliersModel(
      Integer id,
      String supplierName,
      String fantasyName,
      String email,
      Long cellPhone,
      String stateRegistration,
      Long cpnj,
      String site,
      Boolean status,
      AdressesModel adresses
  ) {
    this.id = id;
    this.supplierName = supplierName;
    this.fantasyName = fantasyName;
    this.email = email;
    this.cellPhone = cellPhone;
    this.stateRegistration = stateRegistration;
    this.cpnj = cpnj;
    this.site = site;
    this.status = status;
    this.adresses = adresses;
  }

  /**
   * Constructor for creating a new supplier.
   *
   * @param supplierName     The name of the supplier.
   * @param fantasyName      The fantasy name of the supplier.
   * @param email            The email address of the supplier.
   * @param cellPhone        The cell phone number of the supplier.
   * @param stateRegistration The state registration of the supplier.
   * @param cpnj             The CNPJ of the supplier.
   * @param site             The website URL of the supplier.
   * @param status           The status of the supplier.
   * @param adresses         The address of the supplier.
   */
  public SuppliersModel(
      String supplierName,
      String fantasyName,
      String email,
      Long cellPhone,
      String stateRegistration,
      Long cpnj,
      String site,
      Boolean status,
      AdressesModel adresses
  ) {
    this.supplierName = supplierName;
    this.fantasyName = fantasyName;
    this.email = email;
    this.cellPhone = cellPhone;
    this.stateRegistration = stateRegistration;
    this.cpnj = cpnj;
    this.site = site;
    this.status = status;
    this.adresses = adresses;
  }
}

package com.lacertech.lacereats.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

/**
 * This class represents an address model entity.
 * It is used to store information about addresses in the application.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
@Entity
@Getter
@Table(name = "adresses")
public class AdressesModel {
    
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_adresse")
  private Integer id;

  @Column(length = 8, name = "zip_code", nullable = false, unique = true)
  private String zipCode;

  @Column(length = 45, nullable = false)
  private String city;

  @Column(length = 60, name = "public_place", nullable = false)
  private String publicPlace;

  @Column(length = 60, name = "neighborhood", nullable = false)
  private String neighborhood;

  @Column(length = 2, nullable = false)
  private String state;

  public AdressesModel() {}

  /**
   * Constructor for creating a new address.
   *
   * @param zipCode     The ZIP code of the address.
   * @param city        The city where the address is located.
   * @param publicPlace The public place (e.g., street name) of the address.
   * @param neighborhood The neighborhood of the address.
   * @param state       The state abbreviation of the address.
   */
  public AdressesModel(
      String zipCode,
      String city,
      String publicPlace,
      String neighborhood,
      String state
  ) {
    this.zipCode = zipCode;
    this.city = city;
    this.publicPlace = publicPlace;
    this.neighborhood = neighborhood;
    this.state = state;
  }

  /**
   * Constructor for creating an address with an existing ID.
   *
   * @param id          The unique identifier for the address.
   * @param zipCode     The ZIP code of the address.
   * @param city        The city where the address is located.
   * @param publicPlace The public place (e.g., street name) of the address.
   * @param neighborhood The neighborhood of the address.
   * @param state       The state abbreviation of the address.
   */
  public AdressesModel(
      Integer id, 
      String zipCode, 
      String city, 
      String publicPlace, 
      String neighborhood,
      String state
  ) {
    this.id = id;
    this.zipCode = zipCode;
    this.city = city;
    this.publicPlace = publicPlace;
    this.neighborhood = neighborhood;
    this.state = state;
  }
}

package com.lacertech.lacereats.dto.adresses;

import com.lacertech.lacereats.database.model.AdressesModel;

/**
 * This class represents a Data Transfer Object (DTO) for responding with address information.
 * It is used to encapsulate address data for sending as a response in the application.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
public record AdressesResponseDto(
    Integer id,
    String zipCode,
    String city,
    String publicPlace,
    String neighborhood,
    String state
) {

  /**
   * Constructor to create an AdressesResponseDto from an AdressesModel.
   *
   * @param adresses The AdressesModel from which to create the DTO.
   */
  public AdressesResponseDto(AdressesModel adresses) {
    this(adresses.getId(),
        adresses.getZipCode(),
        adresses.getCity(),
        adresses.getPublicPlace(),
        adresses.getNeighborhood(),
        adresses.getState());
  }

  /**
   * Static factory method to create an AdressesResponseDto from an AdressesModel.
   *
   * @param adresses The AdressesModel from which to create the DTO.
   * @return An instance of AdressesResponseDto.
   */
  public static AdressesResponseDto turnsIntoDto(AdressesModel adresses) {
    return new AdressesResponseDto(
        adresses.getId(),
        adresses.getZipCode(),
        adresses.getCity(),
        adresses.getPublicPlace(),
        adresses.getNeighborhood(),
        adresses.getState());
  }
}
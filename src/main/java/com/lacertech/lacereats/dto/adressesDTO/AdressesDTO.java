package com.lacertech.lacereats.dto.adressesDTO;

import com.lacertech.lacereats.database.model.AdressesModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * This class represents a Data Transfer Object (DTO) for address information.
 * It is used to encapsulate address data for input and output in the application.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
public record AdressesDTO(
    
    @NotBlank(message = "{zipCode.not.blank}")
    @Size(max = 8, min = 8, message = "{zipCode.size}")
    String zipCode,

    @NotBlank(message = "{city.not.blank}")
    String city,

    @NotBlank(message = "{publicPlace.not.blank}")
    String publicPlace,

    @NotBlank(message = "{neighborhood.not.blank}")
    String neighborhood,

    @NotBlank(message = "{state.not.blank}")
    String state
) {

  /**
   * Constructor to create an AdressesDTO from an AdressesModel.
   *
   * @param adresses The AdressesModel from which to create the DTO.
   */
  public AdressesDTO(AdressesModel adresses) {
    this(adresses.getZipCode(),
        adresses.getCity(),
        adresses.getPublicPlace(),
        adresses.getNeighborhood(),
        adresses.getState());
  }
}

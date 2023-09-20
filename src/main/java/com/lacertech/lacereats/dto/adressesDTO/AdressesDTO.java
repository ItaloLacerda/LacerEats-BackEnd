package com.lacertech.lacereats.dto.adressesDTO;

import com.lacertech.lacereats.database.model.AdressesModel;

public record AdressesDTO(Integer id, String zipCode, String city, String publicPlace, String neighborhood, String state) {
    public AdressesDTO(AdressesModel adresses) {
        this(adresses.getId(), adresses.getZipCode(), adresses.getCity(), adresses.getPublicPlace(), adresses.getNeighborhood(), adresses.getState());
    }
}

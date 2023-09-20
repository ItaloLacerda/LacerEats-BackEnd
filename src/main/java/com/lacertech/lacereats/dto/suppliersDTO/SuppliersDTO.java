package com.lacertech.lacereats.dto.suppliersDTO;

import com.lacertech.lacereats.database.model.AdressesModel;
import com.lacertech.lacereats.database.model.SuppliersModel;

public record SuppliersDTO(
    Integer id,
    String supplierName,
    String fantasyName,
    String email,
    Long cellPhone,
    String stateRegistration,
    Long cpnj,
    String site,
    Boolean status,
    AdressesModel adresses) {
    public SuppliersDTO(SuppliersModel suppliers) {
        this(
            suppliers.getId(),
            suppliers.getSupplierName(),
            suppliers.getFantasyName(),
            suppliers.getEmail(),
            suppliers.getCellPhone(),
            suppliers.getStateRegistration(),
            suppliers.getCpnj(),
            suppliers.getSite(),
            suppliers.getStatus(),
            suppliers.getAdresses()
            );
    }
}

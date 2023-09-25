package com.lacertech.lacereats.dto.rolesDTO;

import com.lacertech.lacereats.database.model.RolesModel;

public record RoleResponseDTO(Integer id, String role, Boolean status) {
     public RoleResponseDTO(RolesModel role) {
        this(role.getId(), role.getRole(), role.getStatus());
    }

    public static RoleResponseDTO turnsIntoDTO(RolesModel role) {
        return new RoleResponseDTO(role.getId(), role.getRole(), role.getStatus());
    }
}

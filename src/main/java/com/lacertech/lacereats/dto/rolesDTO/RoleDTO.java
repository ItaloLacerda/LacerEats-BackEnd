package com.lacertech.lacereats.dto.rolesDTO;

import com.lacertech.lacereats.database.model.RolesModel;

public record RoleDTO(Integer id, String role, Boolean status) {
    
    public RoleDTO(RolesModel role) {
        this(role.getId(), role.getRole(), role.getStatus());
    }
}

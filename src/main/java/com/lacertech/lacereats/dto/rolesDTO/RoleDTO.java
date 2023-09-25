package com.lacertech.lacereats.dto.rolesDTO;

import com.lacertech.lacereats.database.model.RolesModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RoleDTO(@NotBlank(message = "{role.not.blank}") String role, @NotNull(message = "{status.not.null}") Boolean status) {
    
    public RoleDTO(RolesModel role) {
        this(role.getRole(), role.getStatus());
    }
}

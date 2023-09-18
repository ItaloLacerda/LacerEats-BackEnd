package com.lacertech.lacereats.registrations.roles.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacertech.lacereats.database.model.RolesModel;
import com.lacertech.lacereats.database.repository.RoleRepository;
import com.lacertech.lacereats.dto.rolesDTO.RoleDTO;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    public void postRole(String role) {
        RolesModel roleData = new RolesModel(role, true);
        roleRepository.save(roleData);
        return;
    }

    public List<RoleDTO> getRole() {
        List<RolesModel> listRoles = roleRepository.findAll();
        return listRoles.stream()
                        .map( RoleDTO::new)
                        .collect(Collectors.toList());
    }

    public RoleDTO searchRoleById(Integer id) {
        
        return new RoleDTO(roleRepository.findById(id).get());
    }

    public void updateRole(RoleDTO role) {
        RolesModel roleData = new RolesModel(role.id(), role.role(), role.status());
        roleRepository.save(roleData);
        return;
    }

    
    public void updateRole(Integer id, Boolean status) {
        RoleDTO role = searchRoleById(id);

        RolesModel roleData = new RolesModel(id, role.role() ,status);
        roleRepository.save(roleData);
        return;
    }

    public void updateRole(Integer id, String newRole) {
        RoleDTO role = searchRoleById(id);

        RolesModel roleData = new RolesModel(id, newRole, role.status());
        roleRepository.save(roleData);
        return;
    }
    
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
        return;
    }
}

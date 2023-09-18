package com.lacertech.lacereats.registrations.roles.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.lacertech.lacereats.dto.rolesDTO.RoleDTO;
import com.lacertech.lacereats.registrations.roles.services.RoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/registrations/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    
    @GetMapping
    public List<RoleDTO> searchAllRoles(){
        return roleService.getRole();
    }

    @PostMapping
    public void registerRole(@RequestBody RoleDTO role) {
        roleService.postRole(role.role());
        return;
    }

    @GetMapping("/{id}")
    public RoleDTO searchRoleById(@PathVariable Integer id) {
        return roleService.searchRoleById(id);
    }


    @PutMapping
    public void updateRole(@RequestBody RoleDTO role) {
        roleService.updateRole(role);
        return;
    }

    @PutMapping("/{id}")
    public void updateRole(@PathVariable Integer id,@RequestBody RoleDTO role) {
        if (role.role() != null) {
            roleService.updateRole(id, role.role());
            return;
        }

        if (role.status() != null) {
            roleService.updateRole(id, role.status());
            return;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);
        return;
    }


}

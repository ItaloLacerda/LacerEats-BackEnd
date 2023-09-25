package com.lacertech.lacereats.registrations.roles.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.lacertech.lacereats.controllers.interfaces.CommonController;
import com.lacertech.lacereats.dto.rolesDTO.RoleDTO;
import com.lacertech.lacereats.dto.rolesDTO.RoleResponseDTO;
import com.lacertech.lacereats.registrations.roles.services.RoleService;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/registrations/role", produces = "application/json")
public class RoleController implements CommonController<RoleResponseDTO, RoleDTO> {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> searchAll(){
        return new ResponseEntity<>(roleService.searchAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> register(@RequestBody @Valid RoleDTO role) {
        RoleResponseDTO creatingNewRole = roleService.post(role);
        return new ResponseEntity<>(creatingNewRole, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> searchById(@PathVariable Integer id) {
        return new ResponseEntity<>(roleService.searchById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> update(@PathVariable Integer id,@RequestBody @Valid RoleDTO role) {
            return new ResponseEntity<>(roleService.update(id, role), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.lacertech.lacereats.registrations.roles.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacertech.lacereats.database.model.RolesModel;
import com.lacertech.lacereats.database.repository.RoleRepository;
import com.lacertech.lacereats.dto.rolesDTO.RoleDTO;
import com.lacertech.lacereats.dto.rolesDTO.RoleResponseDTO;
import com.lacertech.lacereats.exceptions.ExistingAttributeException;
import com.lacertech.lacereats.exceptions.IdNotFoundException;
import com.lacertech.lacereats.services.interfaces.CommonService;

import lombok.Getter;

@Service
@Getter
public class RoleService implements CommonService<RoleResponseDTO, RoleDTO> {

    @Autowired
    private RoleRepository roleRepository;

    private final String objectName;
    private final String idNotFoundMensage;

    private RoleService() {
        objectName = "RoleService";
        idNotFoundMensage = "Id not found, please enter a valid id.";
    }

    public RoleResponseDTO post(RoleDTO role) {
        if (!roleRepository.existsByRole(role.role())) {
            RolesModel roleData = new RolesModel(role.role(), role.status());
            return RoleResponseDTO.turnsIntoDTO(roleRepository.save(roleData));
        } else {
            throw new ExistingAttributeException("Role in use, please enter a new value.", objectName, "role");
        }
    }

    public List<RoleResponseDTO> searchAll() {
        List<RolesModel> listRoles = roleRepository.findAll();
        return listRoles.stream()
                        .map( RoleResponseDTO::new)
                        .collect(Collectors.toList());
    }

    public RoleResponseDTO searchById(Integer id) {
        if(roleRepository.existsById(id)) {
            return new RoleResponseDTO(roleRepository.findById(id).get());
        } else {
            throw new IdNotFoundException(idNotFoundMensage, objectName);
        }
    }

    public RoleResponseDTO update(Integer id, RoleDTO role) {
        if(roleRepository.existsById(id)) {
            if(!roleRepository.existsByRole(role.role())) {
                RolesModel roleData = new RolesModel(id, role.role(), role.status());
                return RoleResponseDTO.turnsIntoDTO(roleRepository.save(roleData)); 
            } else {
                throw new ExistingAttributeException("Role in use, please enter a new value.", objectName, "role");
            }
        } else {
            throw new IdNotFoundException(idNotFoundMensage, objectName);
        }
    }

    public void delete(Integer id) {
        if (roleRepository.existsById(id)){
            roleRepository.deleteById(id);
        } else {
            throw new IdNotFoundException(idNotFoundMensage, objectName);
        }
    }
}

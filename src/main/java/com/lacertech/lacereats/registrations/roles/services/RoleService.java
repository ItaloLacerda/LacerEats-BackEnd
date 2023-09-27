package com.lacertech.lacereats.registrations.roles.services;

import com.lacertech.lacereats.database.model.RolesModel;
import com.lacertech.lacereats.database.repository.RoleRepository;
import com.lacertech.lacereats.dto.rolesDTO.RoleDTO;
import com.lacertech.lacereats.dto.rolesDTO.RoleResponseDTO;
import com.lacertech.lacereats.exceptions.ExistingAttributeException;
import com.lacertech.lacereats.exceptions.IdNotFoundException;
import com.lacertech.lacereats.services.interfaces.CommonService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class represents a service for managing role-related operations.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
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

  /**
   * Creates a new role based on the provided RoleDTO.
   *
   * @param role The RoleDTO containing role information.
   * @return A RoleResponseDTO representing the created role.
   * @throws ExistingAttributeException if the role already exists.
   */
  public RoleResponseDTO post(RoleDTO role) {

    if (!roleRepository.existsByRole(role.role())) {

      RolesModel roleData = new RolesModel(role.role(), role.status());
      return RoleResponseDTO.turnsIntoDTO(roleRepository.save(roleData));

    } else {
      throw new ExistingAttributeException(
        "Role in use, please enter a new value.", objectName, "role");
    }

  }  

  /**
   * Retrieves a list of all roles.
   *
   * @return A list of RoleResponseDTO objects representing all roles.
   */
  public List<RoleResponseDTO> searchAll() {
    List<RolesModel> listRoles = roleRepository.findAll();
    return listRoles.stream()
                    .map(RoleResponseDTO::new)
                    .collect(Collectors.toList());
  }

  /**
   * Retrieves a role by its unique identifier (ID).
   *
   * @param id The ID of the role to retrieve.
   * @return A RoleResponseDTO representing the retrieved role.
   * @throws IdNotFoundException if the provided ID is not found.
   */
  public RoleResponseDTO searchById(Integer id) {
    
    if (roleRepository.existsById(id)) {
      
      return new RoleResponseDTO(roleRepository.findById(id).get());
    
    } else {
      throw new IdNotFoundException(idNotFoundMensage, objectName);
    }
  }

  /**
   * Updates an existing role based on the provided ID and RoleDTO.
   *
   * @param id   The ID of the role to update.
   * @param role The RoleDTO containing updated role information.
   * @return A RoleResponseDTO representing the updated role.
   * @throws IdNotFoundException       if the provided ID is not found.
   * @throws ExistingAttributeException if the role already exists.
   */
  public RoleResponseDTO update(Integer id, RoleDTO role) {
    if (roleRepository.existsById(id)) {
      if (!roleRepository.existsByRole(role.role())) {
        RolesModel roleData = new RolesModel(id, role.role(), role.status());
        return RoleResponseDTO.turnsIntoDTO(roleRepository.save(roleData)); 
      } else {
        throw new ExistingAttributeException(
            "Role in use, please enter a new value.", objectName, "role");
      }
    } else {
      throw new IdNotFoundException(idNotFoundMensage, objectName);
    }
  }

  /**
   * Deletes a role by its unique identifier (ID).
   *
   * @param id The ID of the role to delete.
   * @throws IdNotFoundException if the provided ID is not found.
   */
  public void delete(Integer id) {
    if (roleRepository.existsById(id)) {
      roleRepository.deleteById(id);
    } else {
      throw new IdNotFoundException(idNotFoundMensage, objectName);
    }
  }
}

package com.lacertech.lacereats.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

/**
 * This class represents a role model entity.
 * It is used to store information about roles in the application.
 *
 * @author Italo Lacerda
 * @since 2.0
 */
@Entity
@Getter
@Table(name = "roles")
public class RolesModel {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_roles")

  private Integer id;  
  @Column(length = 45, nullable = false, unique = true)
  private String role;

  @Column(nullable = false)
  private Boolean status;

  
  public RolesModel() {}

  /**
   * Constructor for creating a new role.
   *
   * @param role   The name of the role.
   * @param status The status of the role.
   */
  public RolesModel(String role, boolean status) {
    this.role = role;
    this.status = status;
  } 

  /**
   * Constructor for creating a role with an existing ID.
   *
   * @param id     The unique identifier for the role.
   * @param role   The name of the role.
   * @param status The status of the role.
   */
  public RolesModel(Integer id, String role, Boolean status) {
    this.id = id;
    this.role = role;
    this.status = status;
  }  
}

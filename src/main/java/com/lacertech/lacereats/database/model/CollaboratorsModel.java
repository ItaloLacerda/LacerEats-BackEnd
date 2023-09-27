package com.lacertech.lacereats.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;

/**
 * This class represents a collaborator model entity.
 * It is used to store information about collaborators in the application.
 *
 * @author Italo Lacerda
 * @since 2.0 
 */
@Entity
@Getter
@Table(name = "collaborators")
public class CollaboratorsModel {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_roles")
  private Integer id;

  @Column(length = 20, name = "first_name", nullable = false)
  private String firstName;

  @Column(length = 60, name = "last_name", nullable = false)
  private String lastName;

  @Column(length = 45, name = "personal_email", nullable = false, unique = true)
  private String personalEmail;

  @Column(length = 45, name = "busiess_email", unique = true)
  private String busiessEmail;

  @Column(length = 11, name = "cell_phone", nullable = false)
  private Long cellPhone;

  @Column(name = "dateOfBirth", nullable = false)
  private Date dateOfBirth;

  @Column(length = 11, name = "cpf", nullable = false, unique = true)
  private Long cpf;

  @Column(length = 11, name = "rg", unique = true)
  private Integer rg;

  @Column(nullable = false)
  private Boolean status;

  @ManyToOne
  @JoinColumn(name = "id_role", 
              nullable = false)
  private RolesModel role;  
  
  @ManyToOne
  @JoinColumn(name = "id_adresses")
  private AdressesModel adresses;  
  
  public CollaboratorsModel() {}  
  
  /**
   * Constructor for creating a new collaborator.
   *
   * @param firstName     The first name of the collaborator.
   * @param lastName      The last name of the collaborator.
   * @param personalEmail The personal email of the collaborator.
   * @param busiessEmail  The business email of the collaborator.
   * @param cellPhone     The cell phone number of the collaborator.
   * @param dateOfBirth   The date of birth of the collaborator.
   * @param cpf           The CPF of the collaborator.
   * @param rg            The RG of the collaborator.
   * @param status        The status of the collaborator.
   * @param role          The role of the collaborator.
   */
  public CollaboratorsModel(
      String firstName,
      String lastName,
      String personalEmail,
      String busiessEmail,
      Long cellPhone,
      Date dateOfBirth,
      Long cpf,
      Integer rg,
      Boolean status,
      RolesModel role
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.personalEmail = personalEmail;
    this.busiessEmail = busiessEmail;
    this.cellPhone = cellPhone;
    this.dateOfBirth = dateOfBirth;
    this.cpf = cpf;
    this.rg = rg;
    this.status = status;
    this.role = role;
  } 
  
  /**
   * Constructor for creating a collaborator with an existing ID.
   *
   * @param id            The unique identifier for the collaborator.
   * @param firstName     The first name of the collaborator.
   * @param lastName      The last name of the collaborator.
   * @param personalEmail The personal email of the collaborator.
   * @param busiessEmail  The business email of the collaborator.
   * @param cellPhone     The cell phone number of the collaborator.
   * @param dateOfBirth   The date of birth of the collaborator.
   * @param cpf           The CPF of the collaborator.
   * @param rg            The RG of the collaborator.
   * @param status        The status of the collaborator.
   * @param role          The role of the collaborator.
   */
  public CollaboratorsModel(
      Integer id,
      String firstName,
      String lastName,
      String personalEmail,
      String busiessEmail,
      Long cellPhone,
      Date dateOfBirth,
      Long cpf,
      Integer rg,
      Boolean status,
      RolesModel role
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.personalEmail = personalEmail;
    this.busiessEmail = busiessEmail;
    this.cellPhone = cellPhone;
    this.dateOfBirth = dateOfBirth;
    this.cpf = cpf;
    this.rg = rg;
    this.status = status;
    this.role = role;
  }
}

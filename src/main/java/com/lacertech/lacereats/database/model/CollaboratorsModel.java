package com.lacertech.lacereats.database.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "collaborators")
public class CollaboratorsModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles")
    private Integer id;

    @Column(length = 20,
            name = "first_name", 
            nullable = false)
    private String firstName;

    @Column(length = 60, 
            name = "last_name", 
            nullable = false)
    private String lastName;

    @Column(length = 45, 
            name = "personal_email", 
            nullable = false, 
            unique = true)
    private String personalEmail;

    @Column(length = 45, 
            name = "busiess_email", 
            unique = true)
    private String busiessEmail;

    @Column(length = 11, 
            name = "cell_phone", 
            nullable = false)
    private Long cellPhone;

    @Column(name = "dateOfBirth", 
            nullable = false)
    private Date dateOfBirth;

    @Column(length = 11, 
            name = "cpf", 
            nullable = false, 
            unique = true)
    private Long cpf;

    @Column(length = 11, 
            name = "rg", 
            unique = true)
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
        RolesModel role) {
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
        RolesModel role) {
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

    public AdressesModel getAdresses() {
        return adresses;
    }

    public void setAdresses(AdressesModel adresses) {
        this.adresses = adresses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getBusiessEmail() {
        return busiessEmail;
    }

    public void setBusiessEmail(String busiessEmail) {
        this.busiessEmail = busiessEmail;
    }

    public Long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public RolesModel getRole() {
        return role;
    }

    public void setRole(RolesModel role) {
        this.role = role;
    }
}

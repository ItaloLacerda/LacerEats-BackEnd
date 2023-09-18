package com.lacertech.lacereats.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
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

    public RolesModel(Integer id, String role) {
        this.id = id;
        this.role = role; 
    }

    public RolesModel(String role, boolean status) {
        this.role = role;
        this.status = status;
    }

    public RolesModel(Integer id, Boolean status) {
        this.id = id;
        this.status = status;
    }

    public RolesModel(Integer id, String role, Boolean status) {
        this.id = id;
        this.role = role;
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }  
}

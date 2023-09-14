package com.lacertech.lacereats.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_group")
public class ProductGroupModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product_group")
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String description;

    @Column(name = "show_in_mobile", nullable = false)
    private Boolean showInMobile;

    @Column(name = "show_in_terminal", nullable = false)
    private Boolean showInTerminal;

    @Column(nullable = false)
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getShowInMobile() {
        return showInMobile;
    }

    public void setShowInMobile(Boolean showInMobile) {
        this.showInMobile = showInMobile;
    }

    public Boolean getShowInTerminal() {
        return showInTerminal;
    }

    public void setShowInTerminal(Boolean showInTerminal) {
        this.showInTerminal = showInTerminal;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

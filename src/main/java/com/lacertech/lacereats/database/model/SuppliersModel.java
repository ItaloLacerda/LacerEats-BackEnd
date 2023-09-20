package com.lacertech.lacereats.database.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "suppliers")
public class SuppliersModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_supplier")
    private Integer id;

    @Column(length = 60, name = "supplier_name", nullable = false)
    private String supplierName;

    @Column(length = 60, name = "fantasy_name", nullable = false)
    private String fantasyName;

    @Column(length = 45, name = "email", nullable = false)
    private String email;

    @Column(length = 11, name = "cell_phone", nullable = false)
    private Long cellPhone;

    @Column(length = 2, name = "state_registration")
    private String stateRegistration;
    
    @Column(length = 14, name = "cnpj", nullable = false, unique = true)
    private Long cpnj;

    @Column(length = 60)
    private String site;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_adresses")
    private AdressesModel adresses;

    @ManyToMany
    @JoinTable(name = "product_supplier_relationship",
                joinColumns = @JoinColumn(name = "id_suppliers"),
                inverseJoinColumns = @JoinColumn(name = "id_product"))
    private Set<ProductModel> products;

    public SuppliersModel() {}

    public SuppliersModel(
        Integer id,
        String supplierName,
        String fantasyName,
        String email,
        Long cellPhone,
        String stateRegistration,
        Long cpnj,
        String site,
        Boolean status,
        AdressesModel adresses
        ) {
            this.id = id;
            this.supplierName = supplierName;
            this.fantasyName = fantasyName;
            this.email = email;
            this.cellPhone = cellPhone;
            this.stateRegistration = stateRegistration;
            this.cpnj = cpnj;
            this.site = site;
            this.status = status;
            this.adresses = adresses;
    }

    public SuppliersModel(
        String supplierName,
        String fantasyName,
        String email,
        Long cellPhone,
        String stateRegistration,
        Long cpnj,
        String site,
        Boolean status,
        AdressesModel adresses
        ) {
            this.supplierName = supplierName;
            this.fantasyName = fantasyName;
            this.email = email;
            this.cellPhone = cellPhone;
            this.stateRegistration = stateRegistration;
            this.cpnj = cpnj;
            this.site = site;
            this.status = status;
            this.adresses = adresses;
    }

    public Set<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductModel> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public Long getCpnj() {
        return cpnj;
    }

    public void setCpnj(Long cpnj) {
        this.cpnj = cpnj;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AdressesModel getAdresses() {
        return adresses;
    }

    public void setAdresses(AdressesModel adresses) {
        this.adresses = adresses;
    }
}

package com.lacertech.lacereats.registrations.productgroups.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacertech.lacereats.dto.productgroupsDTO.ProductGroupsDTO;
import com.lacertech.lacereats.registrations.productgroups.services.ProductGroupService;

@RestController
@RequestMapping(path = "/registrations/product groups")
public class ProductGroupsController {

    @Autowired
    private ProductGroupService productGroupService;
    
    @GetMapping
    public List<ProductGroupsDTO> searchAllRoles(){
        return productGroupService.searchAll();
    }

    @PostMapping
    public void registerRole(@RequestBody ProductGroupsDTO ProductGroup) {
        productGroupService.create(ProductGroup);
        return;
    }

    @GetMapping("/{id}")
    public ProductGroupsDTO searchRoleById(@PathVariable Integer id) {
        return productGroupService.searchById(id);
    }


    @PutMapping
    public void updateRole(@RequestBody ProductGroupsDTO productGroup) {
        productGroupService.update(productGroup);
        return;
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Integer id) {
        productGroupService.delete(id);
        return;
    }
}

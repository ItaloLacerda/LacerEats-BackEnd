package com.lacertech.lacereats.registrations.suppliers.controllers;

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

import com.lacertech.lacereats.dto.suppliersDTO.SuppliersDTO;
import com.lacertech.lacereats.registrations.suppliers.services.SuppliersService;

@RestController
@RequestMapping(path = "/registrations/supplie")
public class SuppliersController {

    @Autowired
    private SuppliersService suppliersService;
    
    @GetMapping
    public List<SuppliersDTO> searchAll(){
        return suppliersService.searchAll();
    }

    @PostMapping
    public void register(@RequestBody SuppliersDTO suppliers) {
        suppliersService.create(suppliers);
        return;
    }

    @GetMapping("/{id}")
    public SuppliersDTO searchById(@PathVariable Integer id) {
        return suppliersService.searchById(id);
    }

    @PutMapping
    public void update(@RequestBody SuppliersDTO supplie) {
        suppliersService.update(supplie);
        return;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        suppliersService.delete(id);
        return;
    }
}

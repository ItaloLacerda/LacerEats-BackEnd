package com.lacertech.lacereats.registrations.adresses.controllers;

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

import com.lacertech.lacereats.dto.adressesDTO.AdressesDTO;
import com.lacertech.lacereats.registrations.adresses.services.AdressesService;

@RestController
@RequestMapping(path = "/registrations/adresses")
public class AdressesController {

    @Autowired
    private AdressesService adressesService;
    
    @GetMapping
    public List<AdressesDTO> searchAll(){
        return adressesService.searchAll();
    }

    @PostMapping
    public void register(@RequestBody AdressesDTO adresses) {
        adressesService.create(adresses);
        return;
    }

    @GetMapping("/{id}")
    public AdressesDTO searchById(@PathVariable Integer id) {
        return adressesService.searchById(id);
    }

    @PutMapping
    public void update(@RequestBody AdressesDTO adresses) {
        adressesService.update(adresses);
        return;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        adressesService.delete(id);
        return;
    }
}

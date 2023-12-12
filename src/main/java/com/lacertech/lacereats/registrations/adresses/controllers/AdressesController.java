package com.lacertech.lacereats.registrations.adresses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacertech.lacereats.controllers.interfaces.CommonController;
import com.lacertech.lacereats.dto.adressesDTO.AdressesDTO;
import com.lacertech.lacereats.dto.adressesDTO.AdressesResponseDto;
import com.lacertech.lacereats.registrations.adresses.services.AdressesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/registrations/adresses")
public class AdressesController implements CommonController<AdressesResponseDto, AdressesDTO> {

    @Autowired
    private AdressesService adressesService;
    
    @GetMapping
    public ResponseEntity<List<AdressesResponseDto>> searchAll(){
        return new ResponseEntity<>(adressesService.searchAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AdressesResponseDto> register(@RequestBody AdressesDTO adresses) {
        AdressesResponseDto creatingNewAdresses = adressesService.create(adresses); 
        return new ResponseEntity<>(creatingNewAdresses , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdressesResponseDto> searchById(@PathVariable Integer id) {
        AdressesResponseDto adresses = adressesService.searchById(id); 
        return new ResponseEntity<>(adresses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdressesResponseDto> update(
        @PathVariable 
        Integer id,
        @RequestBody
        @Valid  
        AdressesDTO adresses) {
        
        AdressesResponseDto adressesUpdate = adressesService.update(id, adresses);
        return new ResponseEntity<>(adressesUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        adressesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.lacertech.lacereats.registrations.adresses.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacertech.lacereats.database.model.AdressesModel;
import com.lacertech.lacereats.database.repository.AdressesRepository;
import com.lacertech.lacereats.dto.adressesDTO.AdressesDTO;
import com.lacertech.lacereats.dto.adressesDTO.AdressesResponseDto;



@Service
public class AdressesService {
    
    @Autowired
    private AdressesRepository adressesRepository;

    public AdressesResponseDto create(AdressesDTO adressesDTO) {
        AdressesModel data = new AdressesModel(
            adressesDTO.zipCode(), 
            adressesDTO.city(), 
            adressesDTO.publicPlace(), 
            adressesDTO.neighborhood(), 
            adressesDTO.state());
            
            return AdressesResponseDto.turnsIntoDto(adressesRepository.save(data));
        }
    

    public List<AdressesResponseDto> searchAll() {
        List<AdressesModel> listAdresse = adressesRepository.findAll();
        return listAdresse.stream()
                           .map(AdressesResponseDto::new)
                           .collect(Collectors.toList());
    }

    public AdressesResponseDto searchById(Integer id) {
        
        return new AdressesResponseDto(adressesRepository.findById(id).get());
    }

    public AdressesResponseDto update(Integer id, AdressesDTO adresses) {
        AdressesModel adresseData = new AdressesModel(
            id,
            adresses.zipCode(),
            adresses.city(),
            adresses.publicPlace(),
            adresses.neighborhood(),
            adresses.state());
        
        return AdressesResponseDto.turnsIntoDto(adressesRepository.save(adresseData));
    }

    public void delete(Integer id) {
        adressesRepository.deleteById(id);
        return;
    }
}
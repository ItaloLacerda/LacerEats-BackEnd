package com.lacertech.lacereats.registrations.adresses.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacertech.lacereats.database.model.AdressesModel;
import com.lacertech.lacereats.database.repository.AdressesRepository;
import com.lacertech.lacereats.dto.adressesDTO.AdressesDTO;



@Service
public class AdressesService {
    
    @Autowired
    private AdressesRepository adressesRepository;

    public void create(AdressesDTO adressesDTO) {
        AdressesModel data = new AdressesModel(
            adressesDTO.zipCode(), 
            adressesDTO.city(), 
            adressesDTO.publicPlace(), 
            adressesDTO.neighborhood(), 
            adressesDTO.state());
            adressesRepository.save(data);
        }
    

    public List<AdressesDTO> searchAll() {
        List<AdressesModel> listAdresse = adressesRepository.findAll();
        return listAdresse.stream()
                           .map(AdressesDTO::new)
                           .collect(Collectors.toList());
    }

    public AdressesDTO searchById(Integer id) {
        
        return new AdressesDTO(adressesRepository.findById(id).get());
    }

    public void update(AdressesDTO adressesDTO) {
        AdressesModel adresseData = new AdressesModel(
            adressesDTO.id(),
            adressesDTO.zipCode(),
            adressesDTO.city(),
            adressesDTO.publicPlace(),
            adressesDTO.neighborhood(),
            adressesDTO.state());
        adressesRepository.save(adresseData);
        return;
    }

    public void delete(Integer id) {
        adressesRepository.deleteById(id);
        return;
    }
}
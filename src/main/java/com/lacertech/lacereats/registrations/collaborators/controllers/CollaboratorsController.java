package com.lacertech.lacereats.registrations.collaborators.controllers;

import java.text.ParseException;
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

import com.lacertech.lacereats.dto.collaboratorsDTO.CollaboratorsDTO;
import com.lacertech.lacereats.registrations.collaborators.services.CollaboratorsService;;

@RestController
@RequestMapping(path = "/registrations/collaborator")
public class CollaboratorsController {

    @Autowired
    private CollaboratorsService collaboratorsService;
    
    @GetMapping
    public List<CollaboratorsDTO> searchAll(){
        return collaboratorsService.searchAll();
    }

    @PostMapping
    public void register(@RequestBody CollaboratorsDTO collaborators) throws ParseException {
        System.out.println(collaborators.dateOfBirth());
        collaboratorsService.create(collaborators);
        return;
    }

    @GetMapping("/{id}")
    public CollaboratorsDTO searchById(@PathVariable Integer id) {
        return collaboratorsService.searchById(id);
    }

    @PutMapping
    public void update(@RequestBody CollaboratorsDTO collaborators) throws ParseException {
        collaboratorsService.update(collaborators);
        return;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        collaboratorsService.delete(id);
        return;
    }
}

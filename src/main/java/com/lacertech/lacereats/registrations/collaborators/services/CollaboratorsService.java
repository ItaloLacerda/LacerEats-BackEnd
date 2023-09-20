package com.lacertech.lacereats.registrations.collaborators.services;

import java.text.ParseException;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacertech.lacereats.database.model.CollaboratorsModel;
import com.lacertech.lacereats.database.repository.CollaboratorsRepository;
import com.lacertech.lacereats.database.repository.RoleRepository;
import com.lacertech.lacereats.dto.collaboratorsDTO.CollaboratorsDTO;
import com.lacertech.lacereats.globalutils.date.DateTimeFormatter;

@Service
public class CollaboratorsService {
    
    @Autowired
    private CollaboratorsRepository collaboratorsRepository ;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DateTimeFormatter dateTimeFormatter;

    public void create(CollaboratorsDTO collaboratorsDTO) throws ParseException {

        if(roleRepository.existsById(collaboratorsDTO.role().getId())) {
            CollaboratorsModel data = new CollaboratorsModel(
                collaboratorsDTO.firstName(),
                collaboratorsDTO.lastName(),
                collaboratorsDTO.personalEmail(),
                collaboratorsDTO.busiessEmail(),
                collaboratorsDTO.cellPhone(),
                dateTimeFormatter.parseDate(collaboratorsDTO.dateOfBirth()),
                collaboratorsDTO.cpf(),
                collaboratorsDTO.rg(),
                collaboratorsDTO.status(),
                collaboratorsDTO.role()
            );
            collaboratorsRepository.save(data);
        } else {
            System.out.println("Aprenda a fazer exeção");
        }
        return;
    }

    public List<CollaboratorsDTO> searchAll() {
        List<CollaboratorsModel> listCollaborators = collaboratorsRepository.findAll();
        return listCollaborators.stream()
                            .map(CollaboratorsDTO::new)
                            .collect(Collectors.toList());
    }

    public CollaboratorsDTO searchById(Integer id) {
        
        return new CollaboratorsDTO(collaboratorsRepository.findById(id).get());
    }

    public void update(CollaboratorsDTO collaboratorsDTO) throws ParseException {

        CollaboratorsModel data = new CollaboratorsModel(
            collaboratorsDTO.id(),
            collaboratorsDTO.firstName(),
            collaboratorsDTO.lastName(),
            collaboratorsDTO.personalEmail(),
            collaboratorsDTO.busiessEmail(),
            collaboratorsDTO.cellPhone(),
            dateTimeFormatter.parseDate(collaboratorsDTO.dateOfBirth()),
            collaboratorsDTO.cpf(),
            collaboratorsDTO.rg(),
            collaboratorsDTO.status(),
            collaboratorsDTO.role()
        );
        collaboratorsRepository.save(data);
        return;
    }

    public void delete(Integer id) {
        collaboratorsRepository.deleteById(id);
        return;
    }
}
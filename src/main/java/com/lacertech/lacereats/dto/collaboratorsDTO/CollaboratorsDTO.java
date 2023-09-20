package com.lacertech.lacereats.dto.collaboratorsDTO;

import com.lacertech.lacereats.database.model.CollaboratorsModel;
import com.lacertech.lacereats.database.model.RolesModel;
import com.lacertech.lacereats.globalutils.date.DateTimeFormatter;

public record CollaboratorsDTO(
    Integer id, 
    String firstName, 
    String lastName, 
    String personalEmail, 
    String busiessEmail, 
    Long cellPhone, 
    String dateOfBirth, 
    Long cpf, 
    Integer rg, 
    Boolean status, 
    RolesModel role) {
    
    
    static DateTimeFormatter dateTimeFormatter = new DateTimeFormatter();

    public CollaboratorsDTO(CollaboratorsModel collaborators) {
        
        this(
            collaborators.getId(),
            collaborators.getFirstName(),
            collaborators.getLastName(),
            collaborators.getPersonalEmail(),
            collaborators.getBusiessEmail(),
            collaborators.getCellPhone(),
            dateTimeFormatter.formatDate(collaborators.getDateOfBirth()),
            collaborators.getCpf(),
            collaborators.getRg(),
            collaborators.getStatus(),
            collaborators.getRole());
        }

}

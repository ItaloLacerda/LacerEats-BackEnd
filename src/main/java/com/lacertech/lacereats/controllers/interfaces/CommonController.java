package com.lacertech.lacereats.controllers.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CommonController<ResponseDTO, DTO> {

    ResponseEntity<List<ResponseDTO>> searchAll();
    ResponseEntity<ResponseDTO> register(DTO dto);
    ResponseEntity<ResponseDTO> searchById(Integer id);
    ResponseEntity<ResponseDTO> update(Integer id, DTO dto);
    ResponseEntity<Void> deleteRole(Integer id);
}

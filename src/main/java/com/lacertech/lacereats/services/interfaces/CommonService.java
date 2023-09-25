package com.lacertech.lacereats.services.interfaces;

import java.util.List;

public interface CommonService<ResponseDTO, DTO> {
    
    String getObjectName();
    String getIdNotFoundMensage();
    ResponseDTO post(DTO dto);
    List<ResponseDTO> searchAll();
    ResponseDTO searchById(Integer id);
    ResponseDTO update(Integer id, DTO dto);
    void delete(Integer id);
}

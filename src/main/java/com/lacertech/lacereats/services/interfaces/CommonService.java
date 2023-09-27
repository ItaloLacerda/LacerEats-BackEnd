package com.lacertech.lacereats.services.interfaces;

import java.util.List;

/**
 * This interface defines common methods for services that handle business 
 * logic and operations on resources.
 *
 * @param <ResponseDTO> The response DTO type representing the resource.
 * @param <DTO> The DTO type used for creating or updating the resource.
 */
public interface CommonService<ResponseDTO, DTO> {
    
  String getObjectName();

  String getIdNotFoundMensage();

  ResponseDTO post(DTO dto);

  List<ResponseDTO> searchAll();

  ResponseDTO searchById(Integer id);

  ResponseDTO update(Integer id, DTO dto);

  void delete(Integer id);

}

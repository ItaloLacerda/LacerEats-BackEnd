package com.lacertech.lacereats.controllers.interfaces;

import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * This interface defines common methods for controllers that handle HTTP 
 * requests and responses for resources.
 *
 * @param <ResponseDTO> The response DTO type representing the resource.
 * @param <DTO> The DTO type used for creating or updating the resource.
 */
public interface CommonController<ResponseDTO, DTO> {

  ResponseEntity<List<ResponseDTO>> searchAll();

  ResponseEntity<ResponseDTO> register(DTO dto);

  ResponseEntity<ResponseDTO> searchById(Integer id);

  ResponseEntity<ResponseDTO> update(Integer id, DTO dto);

  ResponseEntity<Void> delete(Integer id);
}

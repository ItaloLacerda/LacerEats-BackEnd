package com.lacertech.lacereats.exceptions.responseerror;

import java.util.List;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String message;
    private final int code;
    private final HttpStatusCode status;
    private final String objectName;
    private final List<ErrorObject> errors;
}

package com.lacertech.lacereats.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final String field;
    private final String objectName;

    public BusinessException(String field, String message, String objectName) {
        super(message);
        this.field = field;
        this.objectName = objectName;
    }
}

package com.lacertech.lacereats.exceptions;

public class IdNotFoundException extends BusinessException {

    private final static String field = "id";

    public IdNotFoundException(String message, String objectName) {
		super(field, message, objectName);
	}

	public IdNotFoundException(String mensagem, String objectName ,Object ... params) {
		super(field, String.format(mensagem, params), objectName);
	}
}

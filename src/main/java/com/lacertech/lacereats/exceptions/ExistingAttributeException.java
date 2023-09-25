package com.lacertech.lacereats.exceptions;

public class ExistingAttributeException extends BusinessException {

    public ExistingAttributeException(String message, String objectName, String field) {
		super(field, message, objectName);
	}

	public ExistingAttributeException(String mensagem, String objectName , String field, Object ... params) {
		super(field, String.format(mensagem, params), objectName);
	}
}
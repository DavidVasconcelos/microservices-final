package br.com.fiap.microservicesfinal.exception;

public class InvalidTransactionException extends RuntimeException {

	public InvalidTransactionException() {
		super();
	}

	public InvalidTransactionException(final String message) {
		super(message);
	}

}
package com.github.hexagonoframework.core.exception;

/**
 * Exception comum para o framework
 */
public class HexagonoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HexagonoException() {
		super();
	}

	public HexagonoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HexagonoException(String message, Throwable cause) {
		super(message, cause);
	}

	public HexagonoException(String message) {
		super(message);
	}

	public HexagonoException(Throwable cause) {
		super(cause);
	}
	
}

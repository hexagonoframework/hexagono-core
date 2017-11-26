package com.github.hexagonoframework.core.exception;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;

/**
 * Classe para erros simples, contendo tipo e parametros a serem interpolados para compor mensagem 
 *
 */
public class Error {

	private ErrorType type;
	private Object[] parameters;

	private Error(ErrorType type, Object... parameters) {
		this.type = type;
		this.parameters = parameters;
	}

	/**
	 * Obtem instancia de Error
	 * @param type
	 * @param parameters paremetros a serem interpolados na mensagem
	 * @return Error error instance
	 */
	public static Error of(ErrorType type, Object... parameters) {
		return new Error(type, parameters);
	}

	public ErrorType getType() {
		return type;
	}

	public String getMessage() {
		return MessageFormat.format(type.getPattern(), parameters);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Error error = (Error) o;
		return Objects.equals(type, error.type) && Arrays.equals(parameters, error.parameters);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, Arrays.hashCode(parameters));
	}

	@Override
	public String toString() {
		return "Error{" + "type=" + type + ", parameters=" + Arrays.toString(parameters) + ", message=" + getMessage()
				+ '}';
	}
}

package com.github.hexagonoframework.core.exception;

import static com.github.hexagonoframework.core.exception.ErrorTest.TestErrorType.ERRO_COM_PARAMETROS;
import static com.github.hexagonoframework.core.exception.ErrorTest.TestErrorType.ERRO_SEM_PARAMETRO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ErrorTest {

	enum TestErrorType implements ErrorType {

		ERRO_SEM_PARAMETRO("Mensagem de erro sem parametros"), ERRO_COM_PARAMETROS("Mensagem de erro com parametros 1={0} e 2={1}");

		private String pattern;

		private TestErrorType(String pattern) {
			this.pattern = pattern;
		}

		@Override
		public String getPattern() {
			return pattern;
		}
	}
	
	@Test
	public void testEquals() {
		Error error = Error.of(ERRO_SEM_PARAMETRO);
		assertTrue(error.equals(error));
		assertFalse(error.equals(null));
		assertFalse(error.equals((Object) ""));
	}
	
	@Test
	public void testHashCode() {
		Error error1 = Error.of(ERRO_SEM_PARAMETRO);
		Error error2 = Error.of(ERRO_SEM_PARAMETRO);
		assertEquals(error1.hashCode(), error2.hashCode());
	}
	
	@Test
	public void testToString() {
		Error error1 = Error.of(ERRO_SEM_PARAMETRO);
		Error error2 = Error.of(ERRO_SEM_PARAMETRO);
		assertEquals(error1.toString(), error2.toString());
	}
	
	@Test
	public void deveObterMesmoType() {
		ErrorType type = ERRO_SEM_PARAMETRO;
		Error error = Error.of(type);
		assertEquals(error.getType(), type);
	}

	@Test
	public void deveObterMesmaMensagemDoTemplate() {
		ErrorType type = ERRO_SEM_PARAMETRO;
		Error error = Error.of(type);
		String message = error.getMessage();
		assertEquals(type.getPattern(), message);
	}

	@Test
	public void deveObterMesmaMensagemSimples() {
		ErrorType type = ERRO_SEM_PARAMETRO;
		Error error = Error.of(type);
		String message = error.getMessage();
		assertEquals("Mensagem de erro sem parametros", message);
	}

	@Test
	public void deveObterMesmaMensagemComParametros() {
		ErrorType type = ERRO_COM_PARAMETROS;
		Error error = Error.of(type, 1, 2);
		String message = error.getMessage();
		assertEquals("Mensagem de erro com parametros 1=1 e 2=2", message);
	}

	@Test
	public void deveSerMesmoErro() {
		ErrorType type = ERRO_COM_PARAMETROS;
		Error error1 = Error.of(type, 1, 1);
		Error error2 = Error.of(type, 1, 1);
		assertTrue(error1.equals(error2));
	}

	@Test
	public void deveSerErroDiferente() {
		Error error1 = Error.of(ERRO_SEM_PARAMETRO);
		Error error2 = Error.of(ERRO_COM_PARAMETROS);
		assertFalse(error1.equals(error2));
	}

	@Test
	public void naoDeveSerMesmoErroQuandoParametrosDiferentes() {
		Error error1 = Error.of(ERRO_COM_PARAMETROS, 1, 1);
		Error error2 = Error.of(ERRO_COM_PARAMETROS, 2, 2);
		assertFalse(error1.equals(error2));
	}
}

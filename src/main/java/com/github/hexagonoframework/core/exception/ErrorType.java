package com.github.hexagonoframework.core.exception;

/**
 * Interface para tipo de erro 
 */
public interface ErrorType {

    /**
     * Retorna o pattern da mensagem a ser interpolado
     * @return String pattern de mensagem a ser interpolado
     */
    String getPattern();
    
}

package com.kumulus.desafio.exception;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 7081809898152877190L;

    public NegocioException(String mensagem) {
        super(mensagem);
    }
}

package com.lucasballonecker.transacoes_simplificado.infrastructure.exceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String mensagem) {
        super(mensagem);
    }
}

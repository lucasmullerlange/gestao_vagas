package br.com.lucaslange.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(String message) {
        super("usuario já existe");
    }
}

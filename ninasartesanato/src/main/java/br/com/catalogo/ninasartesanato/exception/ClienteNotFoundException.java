package br.com.catalogo.ninasartesanato.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(String message) {
        super(message);
    }
    
    public ClienteNotFoundException(Long id) {
        super("Cliente não encontrado com o ID: " + id);
    }   
    
}

package br.com.catalogo.ninasartesanato.exception;

public class EnderecoNotFoundException extends RuntimeException {

    public EnderecoNotFoundException(String message) {
        super(message);
    }
    
    public EnderecoNotFoundException(Long id) {
        super("Endereco não encontrado com o ID: " + id);
    }   
    
}

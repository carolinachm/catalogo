package br.com.catalogo.ninasartesanato.exception;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(String message) {
        super(message);
    }
    
    public CategoriaNotFoundException(Long id) {
        super("Categoria não encontrada com o ID: " + id);
    }
}

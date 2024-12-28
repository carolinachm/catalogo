package br.com.catalogo.ninasartesanato.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.catalogo.ninasartesanato.exception.CategoriaNotFoundException;
import br.com.catalogo.ninasartesanato.model.Categoria;
import br.com.catalogo.ninasartesanato.repository.CategoriaRepository;

@Service                       
public class CategoriaService {
    
    private static final Logger logger = LoggerFactory.getLogger(CategoriaService.class);
    
    @Autowired 
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrarCategoria(Categoria categoria) {
        if (categoria.getDescricao() == null || categoria.getDescricao().trim().isEmpty()) {
            logger.error("Tentativa de cadastrar categoria com descrição vazia");
            throw new IllegalArgumentException("O nome da categoria não pode ser vazio");
        }
        logger.info("Cadastrando nova categoria: {}", categoria.getDescricao());
        return categoriaRepository.save(categoria);
    }
    
    public List<Categoria> listarCategorias() {
        logger.info("Listando todas as categorias");
        return categoriaRepository.findAll();
    }
    
    public Categoria buscarPorId(Long id) {
        if (id == null) {
            logger.error("Tentativa de buscar categoria com ID nulo");
            throw new IllegalArgumentException("ID da categoria não pode ser nulo");
        }
        logger.info("Buscando categoria por ID: {}", id);
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new CategoriaNotFoundException(id));
    }
    
    public Categoria atualizarCategoria(Categoria categoria) {
        if (categoria.getId() == null) {
            logger.error("Tentativa de atualizar categoria com ID nulo");
            throw new IllegalArgumentException("ID da categoria não pode ser nulo para atualização");
        }
        if (categoria.getDescricao() == null || categoria.getDescricao().trim().isEmpty()) {
            logger.error("Tentativa de atualizar categoria com descrição vazia");
            throw new IllegalArgumentException("O nome da categoria não pode ser vazio");
        }
        
        // Verifica se a categoria existe
        buscarPorId(categoria.getId());
        
        logger.info("Atualizando categoria ID: {} com nova descrição: {}", categoria.getId(), categoria.getDescricao());
        return categoriaRepository.save(categoria);
    }
    
    public void excluirCategoria(Long id) {
        if (id == null) {
            logger.error("Tentativa de excluir categoria com ID nulo");
            throw new IllegalArgumentException("ID da categoria não pode ser nulo");
        }
        // Verifica se a categoria existe antes de excluir
        buscarPorId(id);
        logger.info("Excluindo categoria com ID: {}", id);
        categoriaRepository.deleteById(id);
        logger.info("Categoria excluída com sucesso - ID: {}", id);
    }
}

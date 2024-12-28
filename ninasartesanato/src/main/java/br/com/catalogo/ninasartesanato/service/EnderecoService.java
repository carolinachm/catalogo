package br.com.catalogo.ninasartesanato.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catalogo.ninasartesanato.model.Endereco;
import br.com.catalogo.ninasartesanato.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    private static final Logger logger = LoggerFactory.getLogger(EnderecoService.class);

    public Endereco cadastrarEndereco(Endereco endereco) {
        if(endereco.getCep() == null || endereco.getCep().trim().isEmpty()) {
            logger.info("Tentativa de cadastrar endereco com cep vazio");
            throw new IllegalArgumentException("O cep do endereco nao pode ser vazio");
        }
        logger.info("Cadastrando novo endereco: {}", endereco.getCep());
        return enderecoRepository.save(endereco);
    }
    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }
    public Endereco buscarPorId(Long id) {
        if (id == null) {
            logger.error("Tentativa de buscar endereco com ID nulo");
            throw new IllegalArgumentException("ID do endereco nao pode ser nulo");
        }
        logger.info("Buscando endereco por ID: {}", id);    
        return enderecoRepository.findById(id).orElse(null);
    }
    public Endereco atualizarEndereco(Endereco endereco) {
        if (endereco.getId() == null) {
            logger.error("Tentativa de atualizar endereco com ID nulo");
            throw new IllegalArgumentException("ID do endereco nao pode ser nulo para atualizacao");
        }
        if(endereco.getCep() == null || endereco.getCep().trim().isEmpty()) {
            logger.info("Tentativa de atualizar endereco com cep vazio");
            throw new IllegalArgumentException("O cep do endereco nao pode ser vazio");
        }
        logger.info("Atualizando endereco ID: {} com cep: {}", endereco.getId(), endereco.getCep());
        return enderecoRepository.save(endereco);
    }
    public void excluirEndereco(Long id) {
        if (id == null) {
            logger.error("Tentativa de excluir endereco com ID nulo");
            throw new IllegalArgumentException("ID do endereco nao pode ser nulo");
        }
        logger.info("Excluindo endereco com ID: {}", id);
        enderecoRepository.deleteById(id);
    }    
}
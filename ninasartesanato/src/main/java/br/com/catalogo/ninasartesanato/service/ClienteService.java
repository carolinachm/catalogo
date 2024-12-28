package br.com.catalogo.ninasartesanato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.catalogo.ninasartesanato.exception.ClienteNotFoundException;
import br.com.catalogo.ninasartesanato.model.Cliente;
import br.com.catalogo.ninasartesanato.repository.ClienteRepository;

@Service
public class ClienteService {
    
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente cadastrarCliente(Cliente cliente) {
        validarCliente(cliente);
        logger.info("Cadastrando novo cliente: {}", cliente.getNome());
        return clienteRepository.save(cliente);
    }
    
    public List<Cliente> listarClientes() {
        logger.info("Listando todos os clientes");
        return clienteRepository.findAll();
    }
    
    public Cliente buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID do cliente nao pode ser nulo");
        }
        logger.info("Buscando cliente por ID: {}", id);
        return clienteRepository.findById(id)
            .orElseThrow(() -> {
                logger.error("Cliente não encontrado com ID: {}", id);
                return new ClienteNotFoundException(id);
            });
    }
    
    public Cliente atualizarCliente(Cliente cliente) {
        if (cliente.getId() == null) {
            logger.error("Tentativa de atualizar cliente com ID nulo");
            throw new IllegalArgumentException("ID do cliente não pode ser nulo para atualização");
        }
        validarCliente(cliente);
        
        // Verifica se o cliente existe
        buscarPorId(cliente.getId());
        
        logger.info("Atualizando cliente ID: {} - Nome: {}", cliente.getId(), cliente.getNome());
        return clienteRepository.save(cliente);
    }
    
    public void excluirCliente(Long id) {
        if (id == null) {
            logger.error("Tentativa de excluir cliente com ID nulo");
            throw new IllegalArgumentException("ID do cliente não pode ser nulo");
        }
        // Verifica se o cliente existe antes de excluir
        buscarPorId(id);
        logger.info("Excluindo cliente com ID: {}", id);
        clienteRepository.deleteById(id);
        logger.info("Cliente excluído com sucesso - ID: {}", id);
    }
    
    private void validarCliente(Cliente cliente) {
        if (cliente == null) {
            logger.error("Tentativa de processar cliente nulo");
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            logger.error("Tentativa de processar cliente com nome vazio");
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio");
        }
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            logger.error("Tentativa de processar cliente com email vazio");
            throw new IllegalArgumentException("Email do cliente não pode ser vazio");
        }
        // Adicione outras validações conforme necessário
        logger.debug("Cliente validado com sucesso: {}", cliente.getNome());
    }
}

package br.com.catalogo.ninasartesanato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.catalogo.ninasartesanato.model.ItensPedido;

@Repository
public interface ItensPedidoRepsoitory extends JpaRepository<ItensPedido, Long>{
    
}

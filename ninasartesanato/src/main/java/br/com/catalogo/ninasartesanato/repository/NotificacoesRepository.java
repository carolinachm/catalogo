package br.com.catalogo.ninasartesanato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.catalogo.ninasartesanato.model.Notificacoes;

@Repository
public interface NotificacoesRepository extends JpaRepository<Notificacoes, Long>{
    
}

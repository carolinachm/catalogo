package br.com.catalogo.ninasartesanato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.catalogo.ninasartesanato.model.Promocoes;

@Repository
public interface PromocoesRepository extends JpaRepository<Promocoes, Long>{
    
}

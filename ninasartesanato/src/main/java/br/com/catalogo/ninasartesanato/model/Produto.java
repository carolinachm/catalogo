package br.com.catalogo.ninasartesanato.model;

import java.math.BigDecimal;
import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="produto")
@Data
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Blob imagem_url;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}

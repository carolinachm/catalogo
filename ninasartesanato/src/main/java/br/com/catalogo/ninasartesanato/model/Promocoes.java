package br.com.catalogo.ninasartesanato.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "promocoes")
@Data
public class Promocoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private BigDecimal desconto;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private LocalDateTime inicioPromocao;
    private LocalDateTime fimPromocao;
}

package br.com.catalogo.ninasartesanato.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.catalogo.ninasartesanato.enumerador.StatusPagamentos;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pagamentos")
@Data
public class Pagamentos {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private StatusPagamentos statusPagamento;

    private String metodoPagamento;
    private LocalDateTime dataPagamento;
    private BigDecimal valorPago;
    
}

package br.com.catalogo.ninasartesanato.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="endereco")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Usuario usuario;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String cep;
    private String pais;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}

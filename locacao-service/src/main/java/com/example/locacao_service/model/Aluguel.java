package com.example.locacao_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "aluguel")
@Getter
@Setter
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private BigInteger pessoaId;

    private BigInteger carroId;

    @ManyToOne(fetch = FetchType.LAZY)
    private ApoliceSeguro apoliceSeguro;

    private LocalDateTime dataPedido;

    private LocalDateTime dataEntrega;

    private LocalDateTime dataDevolucao;

    private BigDecimal valorTotal;

    private Status status;
}

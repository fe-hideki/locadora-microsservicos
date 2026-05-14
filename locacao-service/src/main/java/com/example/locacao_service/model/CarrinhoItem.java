package com.example.locacao_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "carrinho_item")
@Getter
@Setter
public class CarrinhoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Carrinho carrinho;

    private BigInteger carroId;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private BigDecimal valorEstimado;
}

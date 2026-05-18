package com.example.locacao_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "apolice_seguro")
@Getter
@Setter
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorFranquia;

    private Boolean protecaoTerceiro;

    private Boolean protecaoCausasNaturais;

    private Boolean protecaoRoubo;
}

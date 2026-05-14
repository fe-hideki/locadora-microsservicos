package com.example.veiculo_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;

    @Enumerated(EnumType.STRING)
    private StatusCarro status = StatusCarro.DISPONIVEL;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloCarro modelo;

    @ManyToMany
    private List<Acessorio> acessorios;
}

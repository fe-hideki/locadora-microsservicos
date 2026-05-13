package com.example.veiculo_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloCarro modelo;

    @ManyToMany
    private List<Acessorio> acessorios;

    public void setModelo(@NotNull Long modeloId) {
    }
}

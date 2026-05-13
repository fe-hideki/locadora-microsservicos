package com.example.veiculo_service.dto.carro;

import com.example.veiculo_service.dto.acessorio.AcessorioDTO;
import com.example.veiculo_service.model.ModeloCarro;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CarroResponseDTO {
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private ModeloCarro modelo;
    private List<AcessorioDTO> acessorios;
}

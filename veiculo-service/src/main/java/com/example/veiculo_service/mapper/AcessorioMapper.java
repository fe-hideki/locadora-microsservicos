package com.example.veiculo_service.mapper;

import com.example.veiculo_service.dto.acessorio.AcessorioRequestDTO;
import com.example.veiculo_service.dto.acessorio.AcessorioResponseDTO;
import com.example.veiculo_service.model.Acessorio;
import org.springframework.stereotype.Component;

@Component
public class AcessorioMapper {

    public Acessorio toEntity(AcessorioRequestDTO dto) {
        Acessorio acessorio = new Acessorio();
        acessorio.setDescricao(dto.getDescricao());
        return acessorio;
    }

    public AcessorioResponseDTO toResponseDTO(Acessorio acessorio) {
        AcessorioResponseDTO dto = new AcessorioResponseDTO();
        dto.setId(acessorio.getId());
        dto.setDescricao(acessorio.getDescricao());
        return dto;
    }
}

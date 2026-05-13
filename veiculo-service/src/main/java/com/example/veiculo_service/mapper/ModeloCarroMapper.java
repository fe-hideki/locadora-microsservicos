package com.example.veiculo_service.mapper;

import com.example.veiculo_service.dto.modelo.ModeloCarroRequestDTO;
import com.example.veiculo_service.dto.modelo.ModeloCarroResponseDTO;
import com.example.veiculo_service.model.ModeloCarro;

public class ModeloCarroMapper {

    private ModeloCarroResponseDTO toModeloDTO(ModeloCarro m) {
        ModeloCarroResponseDTO dto = new ModeloCarroResponseDTO();
        dto.setId(m.getId());
        dto.setDescricao(m.getDescricao());
        dto.setFabricanteNome(m.getFabricante().getNome());
        dto.setCategoriaNome(m.getCategoria().name());
        return dto;
    }
}

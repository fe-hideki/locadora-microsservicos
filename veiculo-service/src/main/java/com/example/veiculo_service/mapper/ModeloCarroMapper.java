package com.example.veiculo_service.mapper;

import com.example.veiculo_service.dto.modelo.ModeloCarroRequestDTO;
import com.example.veiculo_service.dto.modelo.ModeloCarroResponseDTO;
import com.example.veiculo_service.model.Fabricante;
import com.example.veiculo_service.model.ModeloCarro;
import com.example.veiculo_service.repository.FabricanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ModeloCarroMapper {

    private final FabricanteRepository fabricanteRepository;

    public ModeloCarro toEntity(ModeloCarroRequestDTO dto) {
        Fabricante fabricante = fabricanteRepository.findById(dto.getFabricanteId())
                .orElseThrow(() -> new RuntimeException("Fabricante não encontrado"));

        ModeloCarro modelo = new ModeloCarro();
        modelo.setDescricao(dto.getDescricao());
        modelo.setCategoria(dto.getCategoria());
        modelo.setFabricante(fabricante);

        return modelo;
    }

    public ModeloCarroResponseDTO toDTO(ModeloCarro m) {
        ModeloCarroResponseDTO dto = new ModeloCarroResponseDTO();
        dto.setId(m.getId());
        dto.setDescricao(m.getDescricao());
        dto.setFabricanteNome(m.getFabricante().getNome());
        dto.setCategoriaNome(m.getCategoria().name());
        return dto;
    }
}

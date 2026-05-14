package com.example.veiculo_service.service;

import com.example.veiculo_service.dto.fabricante.FabricanteRequestDTO;
import com.example.veiculo_service.dto.fabricante.FabricanteResponseDTO;
import com.example.veiculo_service.model.Fabricante;
import com.example.veiculo_service.repository.FabricanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FabricanteService {
    private final FabricanteRepository fabricanteRepository;

    public FabricanteResponseDTO cadastrar (FabricanteRequestDTO dto){
        if (fabricanteRepository.existsByNomeIgnoreCase(dto.getNome())) {
            throw new RuntimeException("Fabricante já cadastrado");
        }

        Fabricante fabricante = new Fabricante();
        fabricante.setNome(dto.getNome());

        return toDTO(fabricanteRepository.save(fabricante));
    }

    public List<FabricanteResponseDTO> listar() {
        return fabricanteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public FabricanteResponseDTO buscarPorId(Long id) {
        Fabricante fabricante = fabricanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fabricante não encontrado"));
        return toDTO(fabricante);
    }

    private FabricanteResponseDTO toDTO(Fabricante f) {
        FabricanteResponseDTO dto = new FabricanteResponseDTO();
        dto.setId(f.getId());
        dto.setNome(f.getNome());
        return dto;
    }
}

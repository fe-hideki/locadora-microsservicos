package com.example.veiculo_service.service;

import com.example.veiculo_service.dto.modelo.ModeloCarroRequestDTO;
import com.example.veiculo_service.dto.modelo.ModeloCarroResponseDTO;
import com.example.veiculo_service.mapper.ModeloCarroMapper;
import com.example.veiculo_service.model.ModeloCarro;
import com.example.veiculo_service.repository.ModeloRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModeloCarroService {

    private final ModeloRepository modeloRepository;
    private final ModeloCarroMapper modeloCarroMapper;

    public ModeloCarroResponseDTO cadastrar(ModeloCarroRequestDTO dto) {
        if (modeloRepository.existsByDescricaoIgnoreCase(dto.getDescricao())) {
            throw new IllegalArgumentException("Modelo já cadastrado");
        }
        ModeloCarro modelo = modeloCarroMapper.toEntity(dto);
        return modeloCarroMapper.toDTO(modeloRepository.save(modelo));
    }

    public List<ModeloCarroResponseDTO> listar() {
        return modeloRepository.findAll()
                .stream()
                .map(modeloCarroMapper::toDTO)
                .toList();
    }

    public ModeloCarroResponseDTO buscarPorId(Long id) {
        ModeloCarro modelo = modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));
        return modeloCarroMapper.toDTO(modelo);
    }
}

package com.example.veiculo_service.service;

import com.example.veiculo_service.dto.acessorio.AcessorioRequestDTO;
import com.example.veiculo_service.dto.acessorio.AcessorioResponseDTO;
import com.example.veiculo_service.dto.fabricante.FabricanteRequestDTO;

import com.example.veiculo_service.mapper.AcessorioMapper;
import com.example.veiculo_service.model.Acessorio;
import com.example.veiculo_service.repository.AcessorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcessorioService {

    private final AcessorioRepository acessorioRepository;
    private final AcessorioMapper acessorioMapper;

    public AcessorioResponseDTO cadastrar (AcessorioRequestDTO dto){
        if (acessorioRepository.existsByDescricaoIgnoreCase(dto.getDescricao())) {
            throw new RuntimeException("Acessório já cadastrado");
        }

        Acessorio acessorio = acessorioMapper.toEntity(dto);
        return acessorioMapper.toResponseDTO(acessorioRepository.save(acessorio));
    }

    public List<AcessorioResponseDTO> listar() {
        return acessorioRepository.findAll()
                .stream()
                .map(acessorioMapper::toResponseDTO)
                .toList();
    }

    public AcessorioResponseDTO buscarPorId(Long id) {
        Acessorio acessorio = acessorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acessório não encontrado"));
        return acessorioMapper.toResponseDTO(acessorio);
    }
}

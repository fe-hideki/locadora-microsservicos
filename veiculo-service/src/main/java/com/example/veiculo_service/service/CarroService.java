package com.example.veiculo_service.service;

import com.example.veiculo_service.dto.carro.CarroRequestDTO;
import com.example.veiculo_service.dto.carro.CarroResponseDTO;
import com.example.veiculo_service.mapper.CarroMapper;
import com.example.veiculo_service.model.Carro;
import com.example.veiculo_service.model.ModeloCarro;
import com.example.veiculo_service.model.StatusCarro;
import com.example.veiculo_service.repository.AcessorioRepository;
import com.example.veiculo_service.repository.CarroRepository;
import com.example.veiculo_service.repository.ModeloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;

    public CarroResponseDTO cadastrar(CarroRequestDTO dto) {
        if (carroRepository.existsByPlaca(dto.getPlaca())) {
            throw new RuntimeException("Placa já cadastrada");
        }
        if (carroRepository.existsByChassi(dto.getChassi())) {
            throw new RuntimeException("Chassi já cadastrado");
        }

        Carro carro = carroMapper.toEntity(dto);
        return carroMapper.toResponseDTO(carroRepository.save(carro));
    }

    public List<CarroResponseDTO> listar() {
        return carroRepository.findAll()
                .stream()
                .map(carroMapper::toResponseDTO)
                .toList();
    }

    public CarroResponseDTO buscarPorId(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
        return carroMapper.toResponseDTO(carro);
    }

    public CarroResponseDTO reservar(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        if (carro.getStatus() == StatusCarro.RESERVADO) {
            throw new RuntimeException("Carro já reservado");
        }

        carro.setStatus(StatusCarro.RESERVADO);
        return carroMapper.toResponseDTO(carroRepository.save(carro));
    }

    public List<CarroResponseDTO> buscarPorCategoria(String categoria) {
        return carroRepository.findAll()
                .stream()
                .filter(carro -> carro.getModelo().getCategoria().name().equalsIgnoreCase(categoria))
                .map(carroMapper::toResponseDTO)
                .toList();
    }
}

package com.example.veiculo_service.service;

import com.example.veiculo_service.dto.carro.CarroRequestDTO;
import com.example.veiculo_service.dto.carro.CarroResponseDTO;
import com.example.veiculo_service.mapper.CarroMapper;
import com.example.veiculo_service.model.Carro;
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
    private final AcessorioRepository acessorioRepository;
    private final CarroRepository carroRepository;
    private final ModeloRepository modeloRepository;

    public CarroResponseDTO cadastrar(CarroRequestDTO dto){
        if (carroRepository.findByPlaca(dto.getPlaca()).isEmpty() && carroRepository.findByChassi(dto.getChassi()).isEmpty()){
            throw new RuntimeException("Modelo não encontrado");
        }

        Carro carro = CarroMapper.toEntity(dto);
        Carro carroSalvo = carroRepository.save(carro);

        return CarroMapper.toResponseDTO(carroSalvo);
    }


    public List<CarroResponseDTO> listar() {
        if (carroRepository.findAll().isEmpty()){
            throw new RuntimeException("Nenhum carro encontrado");
        }
        List<Carro> carros = carroRepository.findAll();
        return carros.stream()
                .map(CarroMapper::toResponseDTO)
                .toList();
    }


    public CarroResponseDTO buscarPorId(Long id){
        Optional<Carro> carroOptional = carroRepository.findById(id);
        if (carroOptional.isEmpty()){
            throw new RuntimeException("Carro não encontrado");
        }
        Carro carro = carroOptional.get();
        return CarroMapper.toResponseDTO(carro);
    }


}

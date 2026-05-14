package com.example.veiculo_service.mapper;

import com.example.veiculo_service.dto.carro.CarroRequestDTO;
import com.example.veiculo_service.dto.carro.CarroResponseDTO;
import com.example.veiculo_service.model.Carro;
import com.example.veiculo_service.model.ModeloCarro;
import com.example.veiculo_service.model.StatusCarro;
import com.example.veiculo_service.repository.AcessorioRepository;
import com.example.veiculo_service.repository.ModeloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarroMapper {

    private final ModeloRepository modeloRepository;
    private final AcessorioRepository acessorioRepository;

    public Carro toEntity(CarroRequestDTO dto) {
        ModeloCarro modelo = modeloRepository.findById(dto.getModeloId())
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));

        Carro carro = new Carro();
        carro.setPlaca(dto.getPlaca());
        carro.setChassi(dto.getChassi());
        carro.setCor(dto.getCor());
        carro.setValorDiaria(dto.getValorDiaria());
        carro.setModelo(modelo.getId());
        carro.setStatus(StatusCarro.DISPONIVEL);
        carro.setAcessorios(acessorioRepository.findAllById(dto.getAcessorioIds()));

        return carro;
    }

    public CarroResponseDTO toResponseDTO(Carro carro) {
        CarroResponseDTO dto = new CarroResponseDTO();
        dto.setId(carro.getId());
        dto.setPlaca(carro.getPlaca());
        dto.setChassi(carro.getChassi());
        dto.setCor(carro.getCor());
        dto.setValorDiaria(carro.getValorDiaria());
        dto.setStatus(carro.getStatus());
        dto.setModelo(carro.getModelo());
        dto.setAcessorios(carro.getAcessorios());
        return dto;
    }
}

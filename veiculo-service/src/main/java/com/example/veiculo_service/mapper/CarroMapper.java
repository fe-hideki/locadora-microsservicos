package com.example.veiculo_service.mapper;

import com.example.veiculo_service.dto.carro.CarroRequestDTO;
import com.example.veiculo_service.dto.carro.CarroResponseDTO;
import com.example.veiculo_service.model.Carro;

public class CarroMapper {
    public static Carro toEntity(CarroRequestDTO dto) {
        Carro carro = new Carro();
        carro.setPlaca(dto.getPlaca());
        carro.setChassi(dto.getChassi());
        carro.setModelo(dto.getModeloId());

        return carro;
    }

    public static CarroResponseDTO toResponseDTO(Carro carro) {

        CarroResponseDTO dto = new CarroResponseDTO();

        dto .setId(carro.getId());
        dto.setPlaca(carro.getPlaca());
        dto.setChassi(carro.getChassi());
        dto.setModelo(carro.getModelo());


        return dto;
    }
}

package com.example.cliente_service.mappers;

import com.example.cliente_service.dtos.MotoristaRequestDto;
import com.example.cliente_service.dtos.MotoristaResponseDto;
import com.example.cliente_service.model.Motorista;
import org.springframework.stereotype.Component;

@Component
public class MotoristaMapper {

    public Motorista toEntity(MotoristaRequestDto dto) {
        if (dto == null) return null;

        Motorista motorista = new Motorista();

        motorista.setNome(dto.getNome());
        motorista.setDataNascimento(dto.getDataNascimento());
        motorista.setCpf(dto.getCpf());
        motorista.setSexo(dto.getSexo());


        motorista.setNumeroCnh(dto.getNumeroCnh());
        motorista.setEmail(dto.getEmail());

        return motorista;
    }

    public MotoristaResponseDto toResponseDTO(Motorista motorista) {
        if (motorista == null) return null;

        MotoristaResponseDto dto = new MotoristaResponseDto();
        dto.setId(motorista.getId());
        dto.setNome(motorista.getNome());
        dto.setEmail(motorista.getEmail());
        dto.setCpf(motorista.getCpf());
        dto.setNumeroCnh(motorista.getNumeroCnh());

        return dto;
    }
}
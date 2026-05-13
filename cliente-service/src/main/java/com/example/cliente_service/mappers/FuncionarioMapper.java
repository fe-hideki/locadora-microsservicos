package com.example.cliente_service.mappers;

import com.example.cliente_service.dtos.FuncionarioRequestDto;
import com.example.cliente_service.dtos.FuncionarioResponseDto;
import com.example.cliente_service.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario toEntity(FuncionarioRequestDto dto) {
        if (dto == null) return null;

        Funcionario func = new Funcionario();
        func.setNome(dto.getNome());
        func.setDataNascimento(dto.getDataNascimento());
        func.setCpf(dto.getCpf());
        func.setSexo(dto.getSexo());
        func.setMatricula(dto.getMatricula());

        return func;
    }

    public FuncionarioResponseDto toResponseDTO(Funcionario func) {
        if (func == null) return null;

        FuncionarioResponseDto dto = new FuncionarioResponseDto();
        dto.setId(func.getId());
        dto.setNome(func.getNome());
        dto.setCpf(func.getCpf());
        dto.setMatricula(func.getMatricula());

        return dto;
    }
}

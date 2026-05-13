package com.example.cliente_service.dtos;

import lombok.Data;

@Data
public class FuncionarioResponseDto {

    private Long id;
    private String nome;
    private String matricula;
    private String cpf;
}

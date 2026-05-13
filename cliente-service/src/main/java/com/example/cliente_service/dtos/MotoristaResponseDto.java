package com.example.cliente_service.dtos;

import lombok.Data;

@Data
public class MotoristaResponseDto {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String numeroCnh;

}

package com.example.cliente_service.dtos;

import com.example.cliente_service.model.Sexo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FuncionarioRequestDto {

    @NotBlank
    private String nome;

    private LocalDate dataNascimento;

    @NotBlank
    private String cpf;

    private Sexo sexo;

    @NotBlank
    private String matricula;
}
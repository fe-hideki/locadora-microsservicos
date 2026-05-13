package com.example.cliente_service.dtos;

import com.example.cliente_service.model.Sexo;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class MotoristaRequestDto {
    
    @NotBlank
    @Size(max = 150)
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    @CPF
    @Pattern(regexp = "\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    private String cpf;

    @NotNull
    private Sexo sexo;

    @NotBlank
    private String numeroCnh;

    @NotBlank
    @Email
    private String email;
}
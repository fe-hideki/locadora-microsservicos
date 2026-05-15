package com.example.cliente_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "motorista")
@PrimaryKeyJoinColumn(name = "pessoa_id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Motorista extends Pessoa {

    @Column(name = "numero_cnh", nullable = false, length = 20)
    private String numeroCnh;

    @Column(unique = true, nullable = false, length = 150)
    private String email;
}
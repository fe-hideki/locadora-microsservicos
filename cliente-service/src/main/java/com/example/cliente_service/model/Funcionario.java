package com.example.cliente_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "pessoa_id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa {

   @Column(unique = true, nullable = false, length = 20)
   private String matricula;
}
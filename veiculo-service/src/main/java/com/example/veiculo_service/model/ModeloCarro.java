package com.example.veiculo_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ModeloCarro {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @OneToMany
    @JsonIgnore
    private List<Carro> carros;
}

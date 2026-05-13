package com.example.veiculo_service.repository;

import com.example.veiculo_service.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}

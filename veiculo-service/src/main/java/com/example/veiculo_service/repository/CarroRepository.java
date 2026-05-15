package com.example.veiculo_service.repository;

import com.example.veiculo_service.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    boolean existsByPlaca(String placa);
    boolean existsByChassi(String chassi);
}

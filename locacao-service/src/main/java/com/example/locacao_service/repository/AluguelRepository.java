package com.example.locacao_service.repository;

import com.example.locacao_service.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}

package com.example.locacao_service.repository;

import com.example.locacao_service.model.ApoliceSeguro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ApoliceSeguroRepository extends JpaRepository<ApoliceSeguro, BigInteger> {
}

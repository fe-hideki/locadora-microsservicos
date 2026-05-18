package com.example.locacao_service.repository;

import com.example.locacao_service.model.CarrinhoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CarrinhoItemRepository extends JpaRepository<CarrinhoItem, Long> {
}

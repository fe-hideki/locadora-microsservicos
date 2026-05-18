package com.example.locacao_service.repository;

import com.example.locacao_service.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}

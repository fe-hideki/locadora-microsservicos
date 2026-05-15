package com.example.locacao_service.repository;

import com.example.locacao_service.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PagamentoRepository extends JpaRepository<Pagamento, BigInteger> {
}

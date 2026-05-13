package com.example.veiculo_service.repository;

import com.example.veiculo_service.model.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository  extends JpaRepository<ModeloCarro,Long> {
}

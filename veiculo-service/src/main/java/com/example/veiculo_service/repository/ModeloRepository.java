package com.example.veiculo_service.repository;

import com.example.veiculo_service.model.Categoria;
import com.example.veiculo_service.model.Fabricante;
import com.example.veiculo_service.model.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository  extends JpaRepository<ModeloCarro,Long> {
    List<ModeloCarro> findByCategoria(Categoria categoria);
    List<ModeloCarro> findByFabricante(Fabricante fabricante);
}

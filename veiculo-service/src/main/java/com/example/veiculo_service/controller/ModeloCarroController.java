package com.example.veiculo_service.controller;

import com.example.veiculo_service.dto.modelo.ModeloCarroRequestDTO;
import com.example.veiculo_service.dto.modelo.ModeloCarroResponseDTO;
import com.example.veiculo_service.service.ModeloCarroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
@RequiredArgsConstructor
public class ModeloCarroController {
    private final ModeloCarroService modeloCarroService;

    @PostMapping
    public ResponseEntity<ModeloCarroResponseDTO> cadastrar(@Valid @RequestBody ModeloCarroRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modeloCarroService.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ModeloCarroResponseDTO>> listar() {
        return ResponseEntity.ok(modeloCarroService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloCarroResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(modeloCarroService.buscarPorId(id));
    }
}

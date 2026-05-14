package com.example.veiculo_service.controller;

import com.example.veiculo_service.dto.fabricante.FabricanteRequestDTO;
import com.example.veiculo_service.dto.fabricante.FabricanteResponseDTO;
import com.example.veiculo_service.service.FabricanteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabricantes")
@RequiredArgsConstructor
public class FabricanteController {
    private final FabricanteService fabricanteService;

    @PostMapping
    public ResponseEntity<FabricanteResponseDTO> cadastrar(@Valid @RequestBody FabricanteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteService.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<FabricanteResponseDTO>> listar() {
        return ResponseEntity.ok(fabricanteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fabricanteService.buscarPorId(id));
    }
}

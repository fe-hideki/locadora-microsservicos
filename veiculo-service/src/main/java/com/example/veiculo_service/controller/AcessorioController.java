package com.example.veiculo_service.controller;

import com.example.veiculo_service.dto.acessorio.AcessorioRequestDTO;
import com.example.veiculo_service.dto.acessorio.AcessorioResponseDTO;
import com.example.veiculo_service.service.AcessorioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acessorios")
@RequiredArgsConstructor
public class AcessorioController {

    private final AcessorioService acessorioService;

    @PostMapping
    public ResponseEntity<AcessorioResponseDTO> cadastrar(@Valid @RequestBody AcessorioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(acessorioService.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AcessorioResponseDTO>> listar() {
        return ResponseEntity.ok(acessorioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcessorioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(acessorioService.buscarPorId(id));
    }
}

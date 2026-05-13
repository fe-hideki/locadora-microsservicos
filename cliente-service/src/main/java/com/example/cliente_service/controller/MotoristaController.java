package com.example.cliente_service.controller;

import com.example.cliente_service.dtos.MotoristaRequestDto;
import com.example.cliente_service.dtos.MotoristaResponseDto;
import com.example.cliente_service.service.MotoristaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class MotoristaController {
    private final MotoristaService service;

    @PostMapping
    public ResponseEntity<MotoristaResponseDto> cadastrar(
            @RequestBody @Valid MotoristaRequestDto dto) {
        var response = service.cadastrar(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaResponseDto> buscar(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}


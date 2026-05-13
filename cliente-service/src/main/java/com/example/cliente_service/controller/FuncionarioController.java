package com.example.cliente_service.controller;

import com.example.cliente_service.dtos.FuncionarioRequestDto;
import com.example.cliente_service.dtos.FuncionarioResponseDto;
import com.example.cliente_service.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {
    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> cadastrar(
            @RequestBody @Valid FuncionarioRequestDto dto) {
        var response = service.cadastrar(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


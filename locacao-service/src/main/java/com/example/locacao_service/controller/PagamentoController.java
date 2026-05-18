package com.example.locacao_service.controller;

import com.example.locacao_service.dto.pagamento.PagamentoRequestDto;
import com.example.locacao_service.dto.pagamento.PagamentoResponseDto;
import com.example.locacao_service.mapper.PagamentoMapper;
import com.example.locacao_service.model.Pagamento;
import com.example.locacao_service.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<PagamentoResponseDto>> findAll(){
        List<PagamentoResponseDto> list = PagamentoMapper.toResponse(
                pagamentoService.findAll()
        );

        if (list.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDto> findById(@PathVariable BigInteger id){
        return ResponseEntity.ok(PagamentoMapper.toResponse(pagamentoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PagamentoResponseDto> create(@RequestBody
                                                           @Valid
                                                           PagamentoRequestDto pagamentoRequestDto){
        return ResponseEntity.status(201).body(PagamentoMapper.toResponse(pagamentoService.save(pagamentoRequestDto)));
    }
}

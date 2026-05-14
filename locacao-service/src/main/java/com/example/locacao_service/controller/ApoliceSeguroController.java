package com.example.locacao_service.controller;

import com.example.locacao_service.dto.apolice.ApoliceSeguroRequestDto;
import com.example.locacao_service.dto.apolice.ApoliceSeguroResponseDto;
import com.example.locacao_service.mapper.ApoliceMapper;
import com.example.locacao_service.service.ApoliceSeguroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ApoliceSeguroController {

    @Autowired
    private ApoliceSeguroService apoliceSeguroService;

    @GetMapping
    public ResponseEntity<List<ApoliceSeguroResponseDto>> listar(){
        List<ApoliceSeguroResponseDto> list = ApoliceMapper
                .toResponse(apoliceSeguroService.findAll());

        if (list.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApoliceSeguroResponseDto> getById(@PathVariable BigInteger id){
        return ResponseEntity.status(200)
                .body(ApoliceMapper.toResponse(apoliceSeguroService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApoliceSeguroResponseDto> save(@RequestBody
                                                             @Valid
                                                             ApoliceSeguroRequestDto request){
        return ResponseEntity.status(201)
                .body(ApoliceMapper.toResponse(apoliceSeguroService.save(request)));
    }
}

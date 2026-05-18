package com.example.locacao_service.controller;

import com.example.locacao_service.dto.carrinho.CarrinhoRequestDto;
import com.example.locacao_service.dto.carrinho.CarrinhoResponseDto;
import com.example.locacao_service.mapper.CarrinhoMapper;
import com.example.locacao_service.service.CarrinhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<List<CarrinhoResponseDto>> getCarrinhos(){
        List<CarrinhoResponseDto> list = CarrinhoMapper
                .toResponse(carrinhoService.getCarrinhos());

        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoResponseDto> getCarrinhoById(@PathVariable Long id){
        return ResponseEntity.ok()
                .body(CarrinhoMapper.toResponse(carrinhoService.getCarrinhosPorId(id)));
    }

    @PostMapping
    public ResponseEntity<CarrinhoResponseDto> criar(@RequestBody
                                                         @Valid
                                                         CarrinhoRequestDto carrinhoRequestDto){
        return ResponseEntity.ok()
                .body(CarrinhoMapper.toResponse(carrinhoService.criar(carrinhoRequestDto)));
    }
}

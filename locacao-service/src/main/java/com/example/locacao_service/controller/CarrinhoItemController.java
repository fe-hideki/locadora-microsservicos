package com.example.locacao_service.controller;

import com.example.locacao_service.dto.carrinho_item.CarrinhoItemRequestDto;
import com.example.locacao_service.dto.carrinho_item.CarrinhoItemResponseDto;
import com.example.locacao_service.mapper.CarrinhoItemMapper;
import com.example.locacao_service.mapper.CarrinhoMapper;
import com.example.locacao_service.model.CarrinhoItem;
import com.example.locacao_service.service.CarrinhoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/carrinho-item")
public class CarrinhoItemController {

    @Autowired
    private CarrinhoItemService carrinhoItemService;

    @GetMapping
    public ResponseEntity<List<CarrinhoItemResponseDto>> listar(){
        List<CarrinhoItemResponseDto> list = CarrinhoItemMapper.toResponse(carrinhoItemService.findAll());

        if (list.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoItemResponseDto> listarPorId(@PathVariable BigInteger id){
        return ResponseEntity.ok()
                .body(CarrinhoItemMapper.toResponse(carrinhoItemService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CarrinhoItemResponseDto>  create(@RequestBody
                                                               @Valid
                                                               CarrinhoItemRequestDto request){
        return ResponseEntity.ok().body(CarrinhoItemMapper.toResponse(carrinhoItemService.save(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrinhoItemResponseDto> finalizar(@PathVariable BigInteger id){
        return ResponseEntity.ok().body(CarrinhoItemMapper.toResponse(carrinhoItemService.finalizar(id)));
    }
}

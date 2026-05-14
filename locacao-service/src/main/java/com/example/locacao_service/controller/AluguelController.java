package com.example.locacao_service.controller;

import com.example.locacao_service.dto.aluguel.AluguelRequestDto;
import com.example.locacao_service.dto.aluguel.AluguelResponseDto;
import com.example.locacao_service.mapper.AluguelMapper;
import com.example.locacao_service.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping
    public ResponseEntity<List<AluguelResponseDto>> getAluguel(){
        List<AluguelResponseDto> list = AluguelMapper
                .toResponse(aluguelService.findAll());

        if (list.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelResponseDto> getAluguelById(@PathVariable BigInteger id){
        return ResponseEntity.status(200)
                .body(AluguelMapper.toResponse(aluguelService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<AluguelResponseDto> cadastrarAluguel(@RequestBody
                                                                   @Valid
                                                                   AluguelRequestDto dto){
        return ResponseEntity.status(201)
                .body(AluguelMapper.toResponse(aluguelService.save(dto)));
    }

    @PutMapping("/{id}/pago")
    public ResponseEntity<AluguelResponseDto> pagamento(@PathVariable BigInteger id){
        return ResponseEntity.status(200)
                .body(AluguelMapper.toResponse(aluguelService.pagar(id)));
    }

    @PutMapping("/{id}/entregue")
    public ResponseEntity<AluguelResponseDto> entregue(@PathVariable BigInteger id){
        return ResponseEntity.status(200)
                .body(AluguelMapper.toResponse(aluguelService.entregar(id)));
    }

    @PutMapping("/{id}/devolvido")
    public ResponseEntity<AluguelResponseDto> devolvido(@PathVariable BigInteger id){
        return ResponseEntity.status(200)
                .body(AluguelMapper.toResponse(aluguelService.devolver(id)));
    }
}

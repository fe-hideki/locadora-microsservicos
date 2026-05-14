package com.example.veiculo_service.controller;

import com.example.veiculo_service.dto.carro.CarroRequestDTO;
import com.example.veiculo_service.dto.carro.CarroResponseDTO;
import com.example.veiculo_service.service.CarroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
@RequiredArgsConstructor
public class CarroController {
    //Get /carros
    //Get /carros/{id}
    //Get /carros?categoria
    //Put /carros/{id}/reservar

    private final CarroService carroService;

    @PostMapping
    public ResponseEntity<CarroResponseDTO> carroSalvo(@Valid @RequestBody CarroRequestDTO carro){
        CarroResponseDTO novoCarro = carroService.cadastrar(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCarro);
    }

    @GetMapping
    public ResponseEntity<List<CarroResponseDTO>> listar(){
        List<CarroResponseDTO> carros = carroService.listar();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> buscarPorId(@PathVariable Long id){
        CarroResponseDTO carro = carroService.buscarPorId(id);
        return ResponseEntity.ok(carro);
    }

    @PutMapping("/{id}/reservar")
    public ResponseEntity<CarroResponseDTO> reservarCarro(@PathVariable Long id) {
        CarroResponseDTO carroReservado = carroService.reservar(id);
        return ResponseEntity.ok(carroReservado);
    }

     @GetMapping("/categoria")
    public ResponseEntity<List<CarroResponseDTO>> buscarPorCategoria(@RequestParam String categoria) {
         List<CarroResponseDTO> carros = carroService.buscarPorCategoria(categoria);
         return ResponseEntity.ok(carros);
     }
}

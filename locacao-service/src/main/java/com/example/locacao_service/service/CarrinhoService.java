package com.example.locacao_service.service;

import com.example.locacao_service.dto.carrinho.CarrinhoRequestDto;
import com.example.locacao_service.exception.CarrinhoNaoEncontradoException;
import com.example.locacao_service.mapper.CarrinhoMapper;
import com.example.locacao_service.model.Carrinho;
import com.example.locacao_service.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<Carrinho> getCarrinhos(){
        return carrinhoRepository.findAll();
    }

    public Carrinho getCarrinhosPorId(BigInteger id){
        Optional<Carrinho> carrinho = carrinhoRepository.findById(id);

        if(carrinho.isEmpty()){
            throw new CarrinhoNaoEncontradoException("Carrinho não encontrado!");
        }

        return carrinho.get();
    }

    public Carrinho criar(CarrinhoRequestDto request){
        Carrinho carrinho = CarrinhoMapper.toEntity(request);

        carrinho.setCriadoEm(LocalDateTime.now());

        return carrinhoRepository.save(carrinho);
    }
}

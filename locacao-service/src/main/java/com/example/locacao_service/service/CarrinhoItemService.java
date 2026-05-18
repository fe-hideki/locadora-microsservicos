package com.example.locacao_service.service;

import com.example.locacao_service.dto.carrinho_item.CarrinhoItemRequestDto;
import com.example.locacao_service.exception.CarrinhoItemNaoEncontradoException;
import com.example.locacao_service.exception.CarrinhoNaoEncontradoException;
import com.example.locacao_service.mapper.CarrinhoItemMapper;
import com.example.locacao_service.model.Carrinho;
import com.example.locacao_service.model.CarrinhoItem;
import com.example.locacao_service.repository.CarrinhoItemRepository;
import com.example.locacao_service.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoItemService {

    @Autowired
    private CarrinhoItemRepository carrinhoItemRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<CarrinhoItem> findAll(){
        return carrinhoItemRepository.findAll();
    }

    public CarrinhoItem findById(BigInteger id){
        Optional<CarrinhoItem> carrinhoItem = carrinhoItemRepository.findById(id);

        if (carrinhoItem.isEmpty()){
            throw new CarrinhoItemNaoEncontradoException("CarrinhoItem não encontrado!");
        }

        return carrinhoItem.get();
    }

    public CarrinhoItem save(CarrinhoItemRequestDto request){
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(request.getCarrinhoId());

        if (carrinhoOptional.isEmpty()){
            throw new CarrinhoNaoEncontradoException("Carrinho nao encontrado!");
        }
        Carrinho carrinho = carrinhoOptional.get();

        CarrinhoItem carrinhoItem = CarrinhoItemMapper.toEntity(request);

        carrinhoItem.setCarrinho(carrinho);

        carrinhoItem.setDataInicio(LocalDate.now());

        return carrinhoItemRepository.save(carrinhoItem);
    }

    public CarrinhoItem finalizar(BigInteger id){
        Optional<CarrinhoItem> carrinhoItemOptional = carrinhoItemRepository.findById(id);

        if (carrinhoItemOptional.isEmpty()){
            throw new CarrinhoItemNaoEncontradoException("Carrinho item nao encontrado!");
        }

        CarrinhoItem carrinhoItem = carrinhoItemOptional.get();

        carrinhoItem.setDataFim(LocalDate.now());

        return carrinhoItemRepository.save(carrinhoItem);
    }
}

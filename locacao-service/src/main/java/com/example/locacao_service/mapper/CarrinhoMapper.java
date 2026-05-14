package com.example.locacao_service.mapper;

import com.example.locacao_service.dto.carrinho.CarrinhoRequestDto;
import com.example.locacao_service.dto.carrinho.CarrinhoResponseDto;
import com.example.locacao_service.model.Carrinho;

import java.util.List;

public class CarrinhoMapper {

    public static Carrinho toEntity(CarrinhoRequestDto request) {
        Carrinho entity = new Carrinho();

        entity.setPessoaId(request.getPessoaId());

        return entity;
    }

    public static CarrinhoResponseDto toResponse(Carrinho entity) {
        CarrinhoResponseDto response = new CarrinhoResponseDto();

        response.setPessoaId(entity.getPessoaId());
        response.setId(entity.getId());
        response.setCriadoEm(entity.getCriadoEm());

        return response;
    }

    public static List<CarrinhoResponseDto> toResponse(List<Carrinho> entityList) {
        return entityList.stream().map(CarrinhoMapper::toResponse).toList();
    }
}

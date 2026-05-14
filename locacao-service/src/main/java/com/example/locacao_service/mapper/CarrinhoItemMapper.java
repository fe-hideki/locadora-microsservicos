package com.example.locacao_service.mapper;

import com.example.locacao_service.dto.carrinho_item.CarrinhoItemRequestDto;
import com.example.locacao_service.dto.carrinho_item.CarrinhoItemResponseDto;
import com.example.locacao_service.model.CarrinhoItem;

import java.util.List;

public class CarrinhoItemMapper {

    public static CarrinhoItem toEntity(CarrinhoItemRequestDto request) {
        CarrinhoItem entity = new CarrinhoItem();

        entity.setCarroId(request.getCarroId());
        entity.setValorEstimado(request.getValorEstimado());

        return entity;
    }

    public static CarrinhoItemResponseDto toResponse(CarrinhoItem entity) {
        CarrinhoItemResponseDto response = new CarrinhoItemResponseDto();

        response.setCarroId(entity.getCarroId());
        response.setId(entity.getId());
        response.setValorEstimado(entity.getValorEstimado());
        response.setDataFim(entity.getDataFim());
        response.setDataInicio(entity.getDataInicio());

        CarrinhoItemResponseDto.Carrinho carrinho = response.new Carrinho();

        carrinho.setId(entity.getCarrinho().getId());
        carrinho.setCriadoEm(entity.getCarrinho().getCriadoEm());
        carrinho.setPessoaId(entity.getCarrinho().getPessoaId());

        response.setCarrinho(carrinho);

        return response;
    }

    public static List<CarrinhoItemResponseDto> toResponse(List<CarrinhoItem> entityList) {
        return entityList.stream().map(CarrinhoItemMapper::toResponse).toList();
    }
}

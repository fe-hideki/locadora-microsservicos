package com.example.locacao_service.mapper;

import com.example.locacao_service.dto.aluguel.AluguelRequestDto;
import com.example.locacao_service.dto.aluguel.AluguelResponseDto;
import com.example.locacao_service.model.Aluguel;

import java.util.List;

public class AluguelMapper {

    public static Aluguel toEntity(AluguelRequestDto request){
        Aluguel entity = new Aluguel();

        entity.setCarroId(request.getCarroId());
        entity.setPessoaId(request.getPessoaId());

        return entity;
    }

    public static AluguelResponseDto toResponse(Aluguel entity){
        AluguelResponseDto response = new AluguelResponseDto();

        response.setCarroId(entity.getCarroId());
        response.setPessoaId(entity.getPessoaId());
        response.setStatus(entity.getStatus());
        response.setId(entity.getId());
        response.setDataPedido(entity.getDataPedido());
        response.setDataEntrega(entity.getDataEntrega());
        response.setDataDevolucao(entity.getDataDevolucao());
        response.setValorTotal(entity.getValorTotal());

        AluguelResponseDto.ApoliceSeguro apoliceSeguro = response.new ApoliceSeguro();

        apoliceSeguro.setId(entity.getApoliceSeguro().getId());
        apoliceSeguro.setProtecaoRoubo(entity.getApoliceSeguro().getProtecaoRoubo());
        apoliceSeguro.setValorFranquia(entity.getApoliceSeguro().getValorFranquia());
        apoliceSeguro.setProtecaoTerceiro(entity.getApoliceSeguro().getProtecaoTerceiro());
        apoliceSeguro.setProtecaoCausasNaturais(entity.getApoliceSeguro().getProtecaoCausasNaturais());

        response.setApoliceSeguro(apoliceSeguro);

        return response;
    }

    public static List<AluguelResponseDto> toResponse(List<Aluguel> entityList){
        return entityList.stream().map(AluguelMapper::toResponse).toList();
    }
}

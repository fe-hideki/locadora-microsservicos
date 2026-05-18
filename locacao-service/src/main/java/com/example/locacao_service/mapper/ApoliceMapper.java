package com.example.locacao_service.mapper;

import com.example.locacao_service.dto.apolice.ApoliceSeguroRequestDto;
import com.example.locacao_service.dto.apolice.ApoliceSeguroResponseDto;
import com.example.locacao_service.model.ApoliceSeguro;

import java.util.List;

public class ApoliceMapper {

    public static ApoliceSeguro toEntity(ApoliceSeguroRequestDto request){
        ApoliceSeguro entity = new ApoliceSeguro();

        entity.setProtecaoRoubo(request.getProtecaoRoubo());
        entity.setValorFranquia(request.getValorFranquia());
        entity.setProtecaoTerceiro(request.getProtecaoTerceiro());
        entity.setProtecaoCausasNaturais(request.getProtecaoCausasNaturais());

        return entity;
    }

    public static ApoliceSeguroResponseDto toResponse(ApoliceSeguro entity){
        ApoliceSeguroResponseDto response = new ApoliceSeguroResponseDto();

        response.setId(entity.getId());
        response.setValorFranquia(entity.getValorFranquia());
        response.setProtecaoRoubo(entity.getProtecaoRoubo());
        response.setProtecaoTerceiro(entity.getProtecaoTerceiro());
        response.setProtecaoCausasNaturais(entity.getProtecaoCausasNaturais());

        return response;
    }

    public static List<ApoliceSeguroResponseDto> toResponse(List<ApoliceSeguro> entityList){
        return entityList.stream().map(ApoliceMapper::toResponse).toList();
    }
}

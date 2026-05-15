package com.example.locacao_service.mapper;

import com.example.locacao_service.dto.pagamento.PagamentoRequestDto;
import com.example.locacao_service.dto.pagamento.PagamentoResponseDto;
import com.example.locacao_service.model.Pagamento;

import java.util.List;

public class PagamentoMapper {

    public static Pagamento toEntity(PagamentoRequestDto request) {
        Pagamento entity = new Pagamento();

        entity.setMetodo(request.getMetodo());
        entity.setValor(request.getValor());
        entity.setStatus(request.getStatus());

        return entity;
    }

    public static PagamentoResponseDto toResponse(Pagamento entity) {
        PagamentoResponseDto response = new PagamentoResponseDto();

        response.setMetodo(entity.getMetodo());
        response.setValor(entity.getValor());
        response.setStatus(entity.getStatus());
        response.setId(entity.getId());

        PagamentoResponseDto.Aluguel aluguel = response.new Aluguel();
        aluguel.setId(entity.getAluguel().getId());
        aluguel.setStatus(entity.getAluguel().getStatus());
        aluguel.setStatus(entity.getAluguel().getStatus());
        aluguel.setCarroId(entity.getAluguel().getCarroId());
        aluguel.setPessoaId(entity.getAluguel().getPessoaId());
        aluguel.setDataDevolucao(entity.getAluguel().getDataDevolucao());

        PagamentoResponseDto.Aluguel.ApoliceSeguro apoliceSeguro = aluguel.new ApoliceSeguro();
        apoliceSeguro.setId(entity.getAluguel().getApoliceSeguro().getId());
        apoliceSeguro.setProtecaoRoubo(entity.getAluguel().getApoliceSeguro().getProtecaoRoubo());
        apoliceSeguro.setValorFranquia(entity.getAluguel().getApoliceSeguro().getValorFranquia());
        apoliceSeguro.setProtecaoTerceiro(entity.getAluguel().getApoliceSeguro().getProtecaoTerceiro());
        apoliceSeguro.setProtecaoCausasNaturais(entity.getAluguel().getApoliceSeguro().getProtecaoCausasNaturais());

        aluguel.setApoliceSeguro(apoliceSeguro);

        response.setAluguel(aluguel);

        return response;
    }

    public static List<PagamentoResponseDto> toResponse(List<Pagamento> entityList) {
        return entityList.stream().map(PagamentoMapper::toResponse).toList();
    }
}

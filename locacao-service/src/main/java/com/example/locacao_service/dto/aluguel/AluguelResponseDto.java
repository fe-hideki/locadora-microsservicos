package com.example.locacao_service.dto.aluguel;

import com.example.locacao_service.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
public class AluguelResponseDto {

    private Long id;

    private Long pessoaId;

    private Long carroId;

    private LocalDateTime dataPedido;

    private LocalDateTime dataEntrega;

    private LocalDateTime dataDevolucao;

    private Double valorTotal;

    private Status status;

    private ApoliceSeguro apoliceSeguro;

    @Getter
    @Setter
    public class ApoliceSeguro {
        private Long id;

        private Double valorFranquia;

        private Boolean protecaoTerceiro;

        private Boolean protecaoCausasNaturais;

        private Boolean protecaoRoubo;
    }
}

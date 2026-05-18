package com.example.locacao_service.dto.pagamento;

import com.example.locacao_service.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
public class PagamentoResponseDto {

    private BigInteger id;

    private String metodo;

    private String status;

    private BigDecimal valor;

    private Aluguel aluguel;

    @Getter
    @Setter
    public class Aluguel{

        private BigInteger id;

        private BigInteger pessoaId;

        private BigInteger carroId;

        private LocalDateTime dataPedido;

        private LocalDateTime dataEntrega;

        private LocalDateTime dataDevolucao;

        private BigDecimal valorTotal;

        private Status status;

        private ApoliceSeguro apoliceSeguro;

        @Getter
        @Setter
        public class ApoliceSeguro{
            private BigInteger id;

            private BigDecimal valorFranquia;

            private Boolean protecaoTerceiro;

            private Boolean protecaoCausasNaturais;

            private Boolean protecaoRoubo;
        }
    }
}

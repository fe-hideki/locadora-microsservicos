package com.example.locacao_service.service;

import com.example.locacao_service.dto.pagamento.PagamentoRequestDto;
import com.example.locacao_service.dto.pagamento.PagamentoResponseDto;
import com.example.locacao_service.exception.AluguelNaoEncontradoException;
import com.example.locacao_service.exception.PagamentoNaoEncontradoException;
import com.example.locacao_service.mapper.PagamentoMapper;
import com.example.locacao_service.model.Aluguel;
import com.example.locacao_service.model.Pagamento;
import com.example.locacao_service.model.Status;
import com.example.locacao_service.repository.AluguelRepository;
import com.example.locacao_service.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    public List<Pagamento> findAll(){
        return pagamentoRepository.findAll();
    }

    public Pagamento findById(Long id){
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);

        if (pagamento.isEmpty()){
            throw new PagamentoNaoEncontradoException("Pagamento não encontrado");
        }

        return pagamento.get();
    }

    public Pagamento save(PagamentoRequestDto request){
        Optional<Aluguel> aluguelOptional = aluguelRepository
                .findById(request.getAluguelId());

        if (aluguelOptional.isEmpty()){
            throw new AluguelNaoEncontradoException("Aluguel não encontrado");
        }

        Aluguel aluguel = aluguelOptional.get();
        aluguel.setStatus(Status.PAGO);

        Pagamento pagamento = PagamentoMapper.toEntity(request);
        pagamento.setAluguel(aluguel);

        aluguelRepository.save(aluguel);

        return pagamentoRepository.save(pagamento);
    }
}

package com.example.locacao_service.service;

import com.example.locacao_service.dto.aluguel.AluguelRequestDto;
import com.example.locacao_service.exception.AluguelNaoEncontradoException;
import com.example.locacao_service.exception.ApoliceNaoEncontradoException;
import com.example.locacao_service.mapper.AluguelMapper;
import com.example.locacao_service.model.Aluguel;
import com.example.locacao_service.model.ApoliceSeguro;
import com.example.locacao_service.model.Status;
import com.example.locacao_service.repository.AluguelRepository;
import com.example.locacao_service.repository.ApoliceSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    public List<Aluguel> findAll(){
        return aluguelRepository.findAll();
    }

    public Aluguel findById(BigInteger id) {
        Optional<Aluguel> aluguelOptional = aluguelRepository.findById(id);

        if (aluguelOptional.isEmpty()) {
            throw new AluguelNaoEncontradoException("AluguelNaoEncontrado");
        }

        return aluguelOptional.get();
    }

    public Aluguel save(AluguelRequestDto request) {
        Optional<ApoliceSeguro> apoliceSeguroOptional = apoliceSeguroRepository
                .findById(request.getApoliceId());

        if (apoliceSeguroOptional.isEmpty()){
            throw new ApoliceNaoEncontradoException("ApoliceNaoEncontrado");
        }

        ApoliceSeguro apolice = apoliceSeguroOptional.get();

        Aluguel aluguel = AluguelMapper.toEntity(request);

        aluguel.setDataPedido(LocalDateTime.now());
        aluguel.setStatus(Status.CRIADO);

        //todo: calcular o valor total

        return aluguelRepository.save(aluguel);
    }

    public Aluguel pagar(BigInteger id) {

        Optional<Aluguel> aluguelOptional = aluguelRepository.findById(id);

        if (aluguelOptional.isEmpty()) {
            throw new AluguelNaoEncontradoException("AluguelNaoEncontrado");
        }

        Aluguel aluguel = aluguelOptional.get();

        aluguel.setStatus(Status.PAGO);

        return aluguelRepository.save(aluguel);
    }

    public Aluguel entregar(BigInteger id) {

        Optional<Aluguel> aluguelOptional = aluguelRepository.findById(id);

        if (aluguelOptional.isEmpty()) {
            throw new AluguelNaoEncontradoException("AluguelNaoEncontrado");
        }

        Aluguel aluguel = aluguelOptional.get();

        aluguel.setDataEntrega(LocalDateTime.now());

        return aluguelRepository.save(aluguel);
    }

    public Aluguel devolver(BigInteger id) {

        Optional<Aluguel> aluguelOptional = aluguelRepository.findById(id);

        if (aluguelOptional.isEmpty()) {
            throw new AluguelNaoEncontradoException("AluguelNaoEncontrado");
        }

        Aluguel aluguel = aluguelOptional.get();

        aluguel.setDataDevolucao(LocalDateTime.now());

        return aluguelRepository.save(aluguel);
    }
}

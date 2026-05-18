package com.example.locacao_service.service;

import com.example.locacao_service.dto.apolice.ApoliceSeguroRequestDto;
import com.example.locacao_service.exception.ApoliceNaoEncontradoException;
import com.example.locacao_service.mapper.ApoliceMapper;
import com.example.locacao_service.model.ApoliceSeguro;
import com.example.locacao_service.repository.ApoliceSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ApoliceSeguroService {

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    public List<ApoliceSeguro> findAll(){
        return apoliceSeguroRepository.findAll();
    }

    public ApoliceSeguro findById(BigInteger id){
        Optional<ApoliceSeguro> optional = apoliceSeguroRepository.findById(id);

        if (optional.isEmpty()){
            throw new ApoliceNaoEncontradoException("Apolice Não Encontrado!");
        }

        return optional.get();
    }

    public ApoliceSeguro save(ApoliceSeguroRequestDto request){
        return apoliceSeguroRepository.save(ApoliceMapper.toEntity(request));
    }
}

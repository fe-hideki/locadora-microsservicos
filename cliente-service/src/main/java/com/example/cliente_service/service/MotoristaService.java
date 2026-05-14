package com.example.cliente_service.service;

import com.example.cliente_service.dtos.MotoristaRequestDto;
import com.example.cliente_service.dtos.MotoristaResponseDto;
import com.example.cliente_service.mappers.MotoristaMapper;
import com.example.cliente_service.model.Motorista;
import com.example.cliente_service.repository.MotoristaRepository;
import com.example.cliente_service.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final PessoaRepository pessoaRepository;
    private final MotoristaMapper motoristaMapper;
    private final RabbitTemplate rabbitTemplate;

    @Transactional
    public MotoristaResponseDto cadastrar(MotoristaRequestDto dto) {

        if (pessoaRepository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("Já existe uma pessoa cadastrada com este CPF.");
        }

        if (motoristaRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Este e-mail já está em uso.");
        }

        Motorista motorista = motoristaMapper.toEntity(dto);

        motorista = motoristaRepository.save(motorista);


        rabbitTemplate.convertAndSend("cliente.exchange", "cliente.cadastro", motorista.getEmail());

        return motoristaMapper.toResponseDTO(motorista);
    }

    public MotoristaResponseDto buscarPorId(Long id) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado."));
        return motoristaMapper.toResponseDTO(motorista);
    }
}
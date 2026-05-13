package com.example.cliente_service.service;

import com.example.cliente_service.dtos.FuncionarioRequestDto;
import com.example.cliente_service.dtos.FuncionarioResponseDto;
import com.example.cliente_service.mappers.FuncionarioMapper;
import com.example.cliente_service.model.Funcionario;
import com.example.cliente_service.repository.FuncionarioRepository;
import com.example.cliente_service.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final PessoaRepository pessoaRepository;
    private final FuncionarioMapper funcionarioMapper;

    @Transactional
    public FuncionarioResponseDto cadastrar(FuncionarioRequestDto dto) {

        if (pessoaRepository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("CPF já cadastrado no sistema.");
        }

        if (funcionarioRepository.existsByMatricula(dto.getMatricula())) {
            throw new RuntimeException("Matrícula já está em uso.");
        }

        Funcionario funcionario = funcionarioMapper.toEntity(dto);
        funcionario = funcionarioRepository.save(funcionario);

        return funcionarioMapper.toResponseDTO(funcionario);
    }

    public List<FuncionarioResponseDto> listarTodos() {
        return funcionarioRepository.findAll().stream()
                .map(funcionarioMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public FuncionarioResponseDto buscarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
        return funcionarioMapper.toResponseDTO(funcionario);
    }

    @Transactional
    public void deletar(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não existe.");
        }
        funcionarioRepository.deleteById(id);
    }
}
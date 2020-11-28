package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.FuncionarioDTO;
import com.seplag.services.process.v1.repository.FuncionarioRepository;
import com.seplag.services.process.v1.services.mapper.FuncionarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	private final FuncionarioMapper funcionarioMapper;

	@Override
	public List<FuncionarioDTO> requestFuncionarios() {
		return this.funcionarioMapper.map(funcionarioRepository.findAll());
	}

}

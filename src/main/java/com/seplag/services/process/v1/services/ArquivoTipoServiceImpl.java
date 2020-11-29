package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoTipoDTO;
import com.seplag.services.process.v1.repository.ArquivoTipoRepository;
import com.seplag.services.process.v1.services.mapper.ArquivoTipoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArquivoTipoServiceImpl implements ArquivoTipoService {

	private final ArquivoTipoRepository arquivoTipoRepository;
	private final ArquivoTipoMapper arquivoTipoMapper;

	@Override
	public List<ArquivoTipoDTO> listar() {
		return this.arquivoTipoMapper.map(arquivoTipoRepository.findAll());
	}

}

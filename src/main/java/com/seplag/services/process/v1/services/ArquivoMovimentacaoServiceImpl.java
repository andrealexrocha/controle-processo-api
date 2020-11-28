package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import com.seplag.services.process.v1.repository.ArquivoMovimentacaoRepository;
import com.seplag.services.process.v1.services.mapper.ArquivoMovimentacaoMapper;
import com.seplag.services.process.v1.services.mapper.ArquivoTipoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArquivoMovimentacaoServiceImpl implements ArquivoMovimentacaoService {

	private final ArquivoMovimentacaoRepository arquivoMovimentacaoRepository;
	private final ArquivoMovimentacaoMapper arquivoMovimentacaoMapper;

	@Override
	public List<ArquivoMovimentacaoDTO> listarMovimentacoes(Long arquivoId) {
		return arquivoMovimentacaoMapper.map(arquivoMovimentacaoRepository.findAllByArquivoId(arquivoId));
	}

	@Override
	public ArquivoMovimentacaoDTO save(ArquivoMovimentacaoDTO arquivoMovimentacaoDTO) {

		return arquivoMovimentacaoMapper.map(arquivoMovimentacaoRepository.save(arquivoMovimentacaoMapper.map(arquivoMovimentacaoDTO)));
	}
}

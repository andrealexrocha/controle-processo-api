package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import com.seplag.services.process.v1.data.models.ArquivoMovimentacao;
import com.seplag.services.process.v1.exception.ResourceNotFoundException;
import com.seplag.services.process.v1.repository.ArquivoMovimentacaoRepository;
import com.seplag.services.process.v1.services.mapper.ArquivoMovimentacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class ArquivoMovimentacaoServiceImpl implements ArquivoMovimentacaoService {

	private final ArquivoMovimentacaoRepository arquivoMovimentacaoRepository;
	private final ArquivoMovimentacaoMapper arquivoMovimentacaoMapper;

	@Override
	public List<ArquivoMovimentacaoDTO> listar(Long arquivoId) {
		return arquivoMovimentacaoMapper.map(arquivoMovimentacaoRepository.findAllByArquivoId(arquivoId));
	}

	@Override
	@Transactional
	public ArquivoMovimentacaoDTO salvar(@Valid ArquivoMovimentacaoDTO arquivoMovimentacaoDTO) {

		return arquivoMovimentacaoMapper.map(arquivoMovimentacaoRepository.save(arquivoMovimentacaoMapper.map(arquivoMovimentacaoDTO)));
	}

	@Override
	@Transactional
	public void excluir(Long id) throws RuntimeException {
		ArquivoMovimentacao arquivoMovimentacao = arquivoMovimentacaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Movimentação id {%d} não encontrada.", id)));

		this.arquivoMovimentacaoRepository.delete(arquivoMovimentacao);
	}
}

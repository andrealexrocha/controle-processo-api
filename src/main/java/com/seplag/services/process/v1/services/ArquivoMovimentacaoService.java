package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArquivoMovimentacaoService {

	List<ArquivoMovimentacaoDTO> listarMovimentacoes(Long arquivoId);
	ArquivoMovimentacaoDTO save(ArquivoMovimentacaoDTO arquivoMovimentacaoDTO);
}

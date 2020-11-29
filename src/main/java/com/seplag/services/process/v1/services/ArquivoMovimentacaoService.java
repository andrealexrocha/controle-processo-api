package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public interface ArquivoMovimentacaoService {

	List<ArquivoMovimentacaoDTO> listar(Long arquivoId);
	ArquivoMovimentacaoDTO salvar(@Valid ArquivoMovimentacaoDTO arquivoMovimentacaoDTO);
	void excluir(Long id) throws RuntimeException;
}

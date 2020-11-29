package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoDTO;
import com.seplag.services.process.v1.data.dto.ArquivoUploadDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Service
@Validated
public interface ArquivoService {

	ArquivoDTO listarArquivo(Long id);
	List<ArquivoDTO> listarArquivosBeneficio(Long beneficioId);
	ArquivoDTO salvar(@Valid ArquivoUploadDTO arquivoUploadDTO) throws IOException;
	void excluir(Long id) throws RuntimeException;
}

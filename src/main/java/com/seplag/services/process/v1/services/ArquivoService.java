package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoDTO;
import com.seplag.services.process.v1.data.dto.ArquivoTipoDTO;
import com.seplag.services.process.v1.data.dto.ArquivoUploadDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ArquivoService {

	ArquivoDTO getFile(Long id);
	List<ArquivoDTO> listarArquivosBeneficio(Long beneficioId);
	ArquivoDTO storeFile(ArquivoUploadDTO arquivoUploadDTO) throws IOException;
}

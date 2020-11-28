package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoDTO;
import com.seplag.services.process.v1.data.dto.ArquivoUploadDTO;
import com.seplag.services.process.v1.data.models.Arquivo;
import com.seplag.services.process.v1.data.models.ArquivoTipo;
import com.seplag.services.process.v1.data.models.Beneficio;
import com.seplag.services.process.v1.repository.ArquivoRepository;
import com.seplag.services.process.v1.repository.ArquivoTipoRepository;
import com.seplag.services.process.v1.repository.BeneficioRepository;
import com.seplag.services.process.v1.services.mapper.ArquivoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArquivoServiceImpl implements ArquivoService {

    private final ArquivoRepository arquivoRepository;
    private final BeneficioRepository beneficioRepository;
    private final ArquivoTipoRepository arquivoTipoRepository;
    private final ArquivoMapper arquivoMapper;

    public ArquivoDTO getFile(Long id) {
        return arquivoMapper.map(arquivoRepository.findById(id).get());
    }

    @Override
    public List<ArquivoDTO> listarArquivosBeneficio(Long beneficioId) {
        return arquivoMapper.map(arquivoRepository.findAllByBeneficioId(beneficioId));
    }

    public ArquivoDTO storeFile(ArquivoUploadDTO arquivoUploadDTO) throws IOException {
        ArquivoDTO arquivoDTO = new ArquivoDTO(arquivoUploadDTO);

        arquivoRepository.save(arquivoMapper.map(arquivoDTO));

        return new ArquivoDTO();
    }

}

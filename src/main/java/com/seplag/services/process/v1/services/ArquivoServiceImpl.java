package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoDTO;
import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import com.seplag.services.process.v1.data.dto.ArquivoUploadDTO;
import com.seplag.services.process.v1.data.models.Arquivo;
import com.seplag.services.process.v1.exception.ConstraintViolationException;
import com.seplag.services.process.v1.exception.ResourceNotFoundException;
import com.seplag.services.process.v1.repository.ArquivoRepository;
import com.seplag.services.process.v1.services.mapper.ArquivoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class ArquivoServiceImpl implements ArquivoService {

    private final ArquivoRepository arquivoRepository;
    private final ArquivoMovimentacaoService arquivoMovimentacaoService;
    private final ArquivoMapper arquivoMapper;

    public ArquivoDTO listarArquivo(Long id) {
        return arquivoMapper.map(arquivoRepository.findById(id).get());
    }

    @Override
    public List<ArquivoDTO> listarArquivosBeneficio(Long beneficioId) {
        return arquivoMapper.map(arquivoRepository.findAllByBeneficioId(beneficioId));
    }

    public ArquivoDTO salvar(@Valid ArquivoUploadDTO arquivoUploadDTO) throws IOException {
        ArquivoDTO arquivoDTO = new ArquivoDTO(arquivoUploadDTO);

        arquivoRepository.save(arquivoMapper.map(arquivoDTO));

        return new ArquivoDTO();
    }

    @Override
    @Transactional
    public void excluir(Long id) throws RuntimeException {

        List<ArquivoMovimentacaoDTO> possuiMovimentacoes = this.arquivoMovimentacaoService.listar(id);

        if (CollectionUtils.isEmpty(possuiMovimentacoes)) {
            Arquivo arquivo = arquivoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(String.format("Arquivo id {%d} não encontrado.", id)));

            this.arquivoRepository.delete(arquivo);
        } else {
            throw new ConstraintViolationException(String.format("Arquivo id {%d} possui {%d} movimentações.", id, possuiMovimentacoes.size()));
        }
    }

}

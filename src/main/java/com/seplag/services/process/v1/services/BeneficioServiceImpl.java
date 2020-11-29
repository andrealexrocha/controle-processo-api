package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.ArquivoDTO;
import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import com.seplag.services.process.v1.data.models.Beneficio;
import com.seplag.services.process.v1.exception.ConstraintViolationException;
import com.seplag.services.process.v1.exception.ResourceNotFoundException;
import com.seplag.services.process.v1.repository.BeneficioRepository;
import com.seplag.services.process.v1.services.mapper.BeneficioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class BeneficioServiceImpl implements BeneficioService {

	private final BeneficioRepository beneficioRepository;
	private final ArquivoService arquivoService;
	private final BeneficioMapper beneficioMapper;

	@Override
	public List<BeneficioDTO> listar() {
		return this.beneficioMapper.map(beneficioRepository.findAll());
	}

	@Override
	public BeneficioDTO recuperaBeneficio(Long id) {
		return this.beneficioMapper.map(beneficioRepository.findById(id).get());
	}

	@Override
	@Transactional
	public BeneficioDTO salvar(@Valid BeneficioDTO beneficioDTO) {
		Beneficio beneficio = this.beneficioMapper.map(beneficioDTO);
		beneficioRepository.saveAndFlush(beneficio);
		return this.beneficioMapper.map(beneficio);
	}

	@Override
	@Transactional
	public void excluir(Long id) throws RuntimeException {
		List<ArquivoDTO> possuiArquivos = this.arquivoService.listarArquivosBeneficio(id);

		if (CollectionUtils.isEmpty(possuiArquivos)) {
			Beneficio beneficio = beneficioRepository.findById(id)
					.orElseThrow(()->new ResourceNotFoundException(String.format("Benefício id {%d} não encontrado.", id)));

			this.beneficioRepository.delete(beneficio);
		} else {
			throw new ConstraintViolationException(String.format("Beneficio id {%d} possui {%d} arquivos.", id, possuiArquivos.size()));
		}

	}
}

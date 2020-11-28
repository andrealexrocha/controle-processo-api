package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import com.seplag.services.process.v1.data.models.Beneficio;
import com.seplag.services.process.v1.repository.BeneficioRepository;
import com.seplag.services.process.v1.services.mapper.BeneficioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficioServiceImpl implements BeneficioService {

	private final BeneficioRepository beneficioRepository;
	private final BeneficioMapper beneficioMapper;

	@Override
	public List<BeneficioDTO> requestBeneficios() {
		return this.beneficioMapper.map(beneficioRepository.findAll());
	}

	@Override
	public BeneficioDTO requestBeneficio(Long id) {
		return this.beneficioMapper.map(beneficioRepository.findById(id).get());
	}

	@Override
	@Transactional
	public BeneficioDTO save(BeneficioDTO beneficioDTO) {
		Beneficio beneficio = this.beneficioMapper.map(beneficioDTO);
		beneficioRepository.saveAndFlush(beneficio);
		return this.beneficioMapper.map(beneficio);
	}
}

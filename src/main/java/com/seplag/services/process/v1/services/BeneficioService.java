package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeneficioService {

	List<BeneficioDTO> requestBeneficios();
	BeneficioDTO requestBeneficio(Long id);
	BeneficioDTO save(BeneficioDTO beneficioDTO);

}

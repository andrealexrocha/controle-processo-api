package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public interface BeneficioService {

	List<BeneficioDTO> listar();
	BeneficioDTO recuperaBeneficio(Long id);
	BeneficioDTO salvar(@Valid BeneficioDTO beneficioDTO);
	void excluir(Long id) throws RuntimeException;

}

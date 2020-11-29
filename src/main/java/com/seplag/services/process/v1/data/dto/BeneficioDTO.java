package com.seplag.services.process.v1.data.dto;

import com.seplag.services.process.v1.services.validation.BeneficioValidation;
import lombok.Data;

@Data
@BeneficioValidation
public class BeneficioDTO {

	private Long id;
	private String numero;
	private FuncionarioDTO funcionario;
}

package com.seplag.services.process.v1.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficioDTO {

	private Long id;
	private String numero;
	private FuncionarioDTO funcionario;
}

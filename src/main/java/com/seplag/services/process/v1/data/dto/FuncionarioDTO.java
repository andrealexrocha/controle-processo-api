package com.seplag.services.process.v1.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

	private Long id;
	private String name;
	private String cpf;
	private OrgaoDTO orgao;
	private String matricula;
}
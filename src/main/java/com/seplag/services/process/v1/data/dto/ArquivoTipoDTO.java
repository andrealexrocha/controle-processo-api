package com.seplag.services.process.v1.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoTipoDTO {

	private Long id;
	private String descricao;
	private boolean ativo;
}
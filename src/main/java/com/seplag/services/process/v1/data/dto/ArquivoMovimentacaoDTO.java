package com.seplag.services.process.v1.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoMovimentacaoDTO {

	private Long id;
	private LocalDateTime data_tramitacao;
	private String parecer;
	private SetorDTO setorOrigem;
	private SetorDTO setorDestino;
	@JsonProperty("arquivo_id")
	private String arquivoId;

}

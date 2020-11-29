package com.seplag.services.process.v1.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seplag.services.process.v1.services.validation.ArquivoValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ArquivoValidation
public class ArquivoUploadDTO {

	private Long id;
	private MultipartFile arquivo;
	private String descricao;
	@JsonProperty("beneficio_id")
	private Long beneficioId;
	@JsonProperty("arquivoTipo_id")
	private Long arquivoTipoId;

}
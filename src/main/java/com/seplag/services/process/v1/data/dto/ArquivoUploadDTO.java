package com.seplag.services.process.v1.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;
import java.io.IOException;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoUploadDTO {

	private Long id;
	private MultipartFile arquivo;
	private String descricao;
	@JsonProperty("beneficio_id")
	private String beneficioId;
	@JsonProperty("arquivoTipo_id")
	private String arquivoTipoId;

}
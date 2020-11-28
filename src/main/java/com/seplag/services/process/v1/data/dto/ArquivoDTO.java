package com.seplag.services.process.v1.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoDTO {

	private Long id;
	private String nome;
	private String descricao;
	private String tipo;
	private Long tamanho;
	private byte[] binario;
	@JsonProperty("beneficio_id")
	private String beneficioId;
	@JsonProperty("arquivoTipo_id")
	private String arquivoTipoId;

	public ArquivoDTO(ArquivoUploadDTO arquivoUploadDTO) throws IOException {
		this.nome = StringUtils.cleanPath(arquivoUploadDTO.getArquivo().getName());
		this.descricao = arquivoUploadDTO.getDescricao();
		this.tipo = arquivoUploadDTO.getArquivo().getContentType();
		this.tamanho = arquivoUploadDTO.getArquivo().getSize();
		this.binario = arquivoUploadDTO.getArquivo().getBytes();
		this.beneficioId = arquivoUploadDTO.getBeneficioId();
		this.arquivoTipoId = arquivoUploadDTO.getArquivoTipoId();
	}
}
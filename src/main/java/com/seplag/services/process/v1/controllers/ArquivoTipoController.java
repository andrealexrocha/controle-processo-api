package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.ArquivoTipoDTO;
import com.seplag.services.process.v1.services.ArquivoTipoService;
import com.seplag.services.process.v1.services.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/arquivos/tipo")
@Api(value = "Tipos de arquivos v1")
public class ArquivoTipoController {

	@Autowired
	private ArquivoTipoService arquivoTipoService;

	@ApiOperation(value = "Retorna uma lista contendo todos os tipos de arquivos cadastrados.")
	@GetMapping
	public ResponseEntity<Response<List<ArquivoTipoDTO>>> listar() {

		Response<List<ArquivoTipoDTO>> response = Response.<List<ArquivoTipoDTO>>builder().data(arquivoTipoService.listar()).build();
		return ResponseEntity.ok(response);

	}

}

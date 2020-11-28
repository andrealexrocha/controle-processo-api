package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.ArquivoTipoDTO;
import com.seplag.services.process.v1.data.dto.OrgaoDTO;
import com.seplag.services.process.v1.services.ArquivoTipoService;
import com.seplag.services.process.v1.services.OrgaoService;
import com.seplag.services.process.v1.services.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/arquivos/tipo")
@Api(value = "Arquivo v1")
@CrossOrigin
public class ArquivoTipoController {

	@Autowired
	private ArquivoTipoService arquivoTipoService;

	@ApiOperation(value = "Get arquivos")
	@GetMapping
	public ResponseEntity<Response<List<ArquivoTipoDTO>>> requestOrgaos() {

		Response<List<ArquivoTipoDTO>> response = Response.<List<ArquivoTipoDTO>>builder().data(arquivoTipoService.requestArquivoTipos()).build();
		return ResponseEntity.ok(response);

	}

}

package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.FuncionarioDTO;
import com.seplag.services.process.v1.services.FuncionarioService;
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
@RequestMapping("/v1/funcionarios")
@Api(value = "Funcionario v1")
@CrossOrigin
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@ApiOperation(value = "Get funcionarios")
	@GetMapping
	public ResponseEntity<Response<List<FuncionarioDTO>>> requestOrgaos() {

		Response<List<FuncionarioDTO>> response = Response.<List<FuncionarioDTO>>builder().data(funcionarioService.requestFuncionarios()).build();
		return ResponseEntity.ok(response);

	}

}

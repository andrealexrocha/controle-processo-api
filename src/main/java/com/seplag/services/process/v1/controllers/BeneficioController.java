package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import com.seplag.services.process.v1.services.BeneficioService;
import com.seplag.services.process.v1.services.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/beneficios")
@Api(value = "Beneficio v1")
@CrossOrigin
public class BeneficioController {

	@Autowired
	private BeneficioService beneficioService;

	@ApiOperation(value = "Get beneficios")
	@GetMapping
	public ResponseEntity<Response<List<BeneficioDTO>>> requestBeneficios() {

		Response<List<BeneficioDTO>> response = Response.<List<BeneficioDTO>>builder().data(beneficioService.requestBeneficios()).build();
		return ResponseEntity.ok(response);

	}

	@ApiOperation(value = "Get beneficio usando o id")
	@GetMapping("/{beneficioId}")
	public ResponseEntity<Response<BeneficioDTO>> requestBeneficio(@PathVariable("beneficioId") Long beneficioId) {

		Response<BeneficioDTO> response = Response.<BeneficioDTO>builder().data(beneficioService.requestBeneficio(beneficioId)).build();
		return ResponseEntity.ok(response);

	}

	@ApiOperation(value = "Post beneficio de um funcionario")
	@PostMapping("/save")
	public ResponseEntity<Response<BeneficioDTO>> saveBeneficioFuncionario(@RequestBody BeneficioDTO beneficioDTO) {

		Response<BeneficioDTO> response = Response.<BeneficioDTO>builder().data(beneficioService.save(beneficioDTO)).build();
		return ResponseEntity.ok(response);

	}
}

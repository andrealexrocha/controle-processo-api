package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import com.seplag.services.process.v1.services.BeneficioService;
import com.seplag.services.process.v1.services.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/beneficios")
@Api(value = "Benefícios v1")
public class BeneficioController {

	@Autowired
	private BeneficioService beneficioService;

	@ApiOperation(value = "Retorna uma lista contendo todos os benefícios cadastrados.")
	@GetMapping
	public ResponseEntity<Response<List<BeneficioDTO>>> listar() {

		Response<List<BeneficioDTO>> response = Response.<List<BeneficioDTO>>builder().data(beneficioService.listar()).build();
		return ResponseEntity.ok(response);

	}

	@ApiOperation(value = "Retorna um benefício cadastrado para um ID.")
	@GetMapping("/{beneficioId}")
	public ResponseEntity<Response<BeneficioDTO>> recuperaBeneficio(@PathVariable("beneficioId") Long beneficioId) {

		Response<BeneficioDTO> response = Response.<BeneficioDTO>builder().data(beneficioService.recuperaBeneficio(beneficioId)).build();
		return ResponseEntity.ok(response);

	}

	@ApiOperation(value = "Salva um benefício.")
	@PostMapping("/salvar")
	public ResponseEntity<Response<BeneficioDTO>> salvar(@RequestBody BeneficioDTO beneficioDTO) {

		Response<BeneficioDTO> response = Response.<BeneficioDTO>builder().data(beneficioService.salvar(beneficioDTO)).build();
		return ResponseEntity.ok(response);

	}

	@ApiOperation(value = "Exclui um benefício cadastrado para um ID.")
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws RuntimeException {
		this.beneficioService.excluir(id);
		return ResponseEntity.ok().build();
	}
}

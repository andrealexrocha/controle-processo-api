package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.OrgaoDTO;
import com.seplag.services.process.v1.data.dto.SetorDTO;
import com.seplag.services.process.v1.services.OrgaoService;
import com.seplag.services.process.v1.services.SetorService;
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
@RequestMapping("/v1/setores")
@Api(value = "Setores v1")
@CrossOrigin
public class SetorController {

	@Autowired
	private SetorService setorService;

	@ApiOperation(value = "Lista todos os setores")
	@GetMapping
	public ResponseEntity<Response<List<SetorDTO>>> listarSetores() {

		Response<List<SetorDTO>> response = Response.<List<SetorDTO>>builder().data(setorService.listarSetores()).build();
		return ResponseEntity.ok(response);

	}

}

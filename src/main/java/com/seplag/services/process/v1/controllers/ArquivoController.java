package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.ArquivoDTO;
import com.seplag.services.process.v1.data.dto.ArquivoUploadDTO;
import com.seplag.services.process.v1.services.ArquivoService;
import com.seplag.services.process.v1.services.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/arquivos")
@Api(value = "Arquivo v1")
@AllArgsConstructor
public class ArquivoController {

    private final ArquivoService arquivoService;

    @ApiOperation(value = "Retorna uma lista contendo todos os arquivos cadastrados para um benefício ID.")
    @GetMapping(value = "/beneficio/{beneficioId}")
    public ResponseEntity<Response<List<ArquivoDTO>>> listarArquivosBeneficio(@PathVariable Long beneficioId) {

        Response<List<ArquivoDTO>> response = Response.<List<ArquivoDTO>>builder().data(arquivoService.listarArquivosBeneficio(beneficioId)).build();

        return ResponseEntity
                .ok(response);
    }

    @ApiOperation(value = "Retorna um arquivo atráves do ID.")
    @GetMapping(value = "/{arquivoId}")
    public ResponseEntity<Response<ArquivoDTO>> listarArquivo(@PathVariable Long arquivoId) {
        Response<ArquivoDTO> response = Response.<ArquivoDTO>builder().data(arquivoService.listarArquivo(arquivoId)).build();

        return ResponseEntity
                .ok(response);
    }

    @ApiOperation(value = "Retorna o valor binário de um arquivo selecionado.")
    @GetMapping(value = "/baixar/{arquivoId}", produces = "application/pdf")
    public byte[] download(@PathVariable Long arquivoId) {
        ArquivoDTO arquivoDTO = arquivoService.listarArquivo(arquivoId);
        byte[] binario = arquivoDTO.getBinario();
        return binario;
    }

    @PostMapping(value = "/salvar", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Salva um arquivo no banco de dados.", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response<ArquivoDTO>> salvar(@ApiParam(name = "file", value = "Escolha um arquivo para o upload", required = true)
                                  @ModelAttribute ArquivoUploadDTO arquivoUploadDTO) throws IOException {
        Response<ArquivoDTO> response = Response.<ArquivoDTO>builder().data(arquivoService.salvar(arquivoUploadDTO)).build();

        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Exclui um arquivo.")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws RuntimeException {
        this.arquivoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

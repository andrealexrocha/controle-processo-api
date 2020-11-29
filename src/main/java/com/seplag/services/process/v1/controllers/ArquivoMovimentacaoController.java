package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import com.seplag.services.process.v1.services.ArquivoMovimentacaoService;
import com.seplag.services.process.v1.services.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
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
@RequestMapping("/v1/movimentacoes/")
@Api(value = "Arquivo movimentações v1")
@AllArgsConstructor
public class ArquivoMovimentacaoController {

    private final ArquivoMovimentacaoService arquivoMovimentacaoService;

    @ApiOperation(value = "Retorna uma lista contendo todas as movimentações cadastradas para um arquivo ID.")
    @GetMapping(value = "/arquivo/{arquivoId}")
    public ResponseEntity<Response<List<ArquivoMovimentacaoDTO>>> listar(@PathVariable Long arquivoId) {
        Response<List<ArquivoMovimentacaoDTO>> response = Response.<List<ArquivoMovimentacaoDTO>>builder().data(arquivoMovimentacaoService.listar(arquivoId)).build();

        return ResponseEntity
                .ok(response);
    }

    @ApiOperation(value = "Salva uma nova movimentação.")
    @PostMapping("/salvar")
    public ResponseEntity<Response<ArquivoMovimentacaoDTO>> salvar(@RequestBody ArquivoMovimentacaoDTO arquivoMovimentacaoDTO){
        Response<ArquivoMovimentacaoDTO> response = Response.<ArquivoMovimentacaoDTO>builder().data(arquivoMovimentacaoService.salvar(arquivoMovimentacaoDTO)).build();

        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Exclui uma movimentação.")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws RuntimeException {
        this.arquivoMovimentacaoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

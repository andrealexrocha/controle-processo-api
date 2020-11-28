package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import com.seplag.services.process.v1.services.ArquivoMovimentacaoService;
import com.seplag.services.process.v1.services.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
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
@RequestMapping("/v1/movimentacoes/")
@Api(value = "Arquivo movimentacoes v1")
@AllArgsConstructor
@CrossOrigin
public class ArquivoMovimentacaoController {

    private final ArquivoMovimentacaoService arquivoMovimentacaoService;


    @GetMapping(value = "/arquivo/{arquivoId}")
    public ResponseEntity<Response<List<ArquivoMovimentacaoDTO>>> getMovimentacoes(@PathVariable Long arquivoId) {
        Response<List<ArquivoMovimentacaoDTO>> response = Response.<List<ArquivoMovimentacaoDTO>>builder().data(arquivoMovimentacaoService.listarMovimentacoes(arquivoId)).build();

        return ResponseEntity
                .ok(response);
    }


    @ApiOperation(value = "Post movimentacao de um arquivo")
    @PostMapping("/save")
    public ResponseEntity<Response<ArquivoMovimentacaoDTO>> saveMovimentacao(@RequestBody ArquivoMovimentacaoDTO arquivoMovimentacaoDTO){
        Response<ArquivoMovimentacaoDTO> response = Response.<ArquivoMovimentacaoDTO>builder().data(arquivoMovimentacaoService.save(arquivoMovimentacaoDTO)).build();

        return ResponseEntity.ok(response);
    }

/*    @GetMapping(value = "/{movimentacaoId}")
    public ResponseEntity<Response<ArquivoMovimentacaoDTO>> getMovimentacao(@PathVariable Long movimentacaoId) {
        Response<ArquivoMovimentacaoDTO> response = Response.<ArquivoDTO>builder().data(arquivoMovimentacaoService.getFile(movimentacaoId)).build();

        return ResponseEntity
                .ok(response);
    }*/
}

package com.seplag.services.process.v1.controllers;

import com.seplag.services.process.v1.data.dto.ArquivoDTO;
import com.seplag.services.process.v1.data.dto.ArquivoUploadDTO;
import com.seplag.services.process.v1.services.ArquivoService;
import com.seplag.services.process.v1.services.ArquivoServiceImpl;
import com.seplag.services.process.v1.services.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/arquivos")
@Api(value = "Arquivo v1")
@AllArgsConstructor
@CrossOrigin
public class ArquivoController {

    private final ArquivoService arquivoService;


    @GetMapping(value = "/beneficio/{beneficioId}")
    public ResponseEntity<Response<List<ArquivoDTO>>> listarArquivosBeneficio(@PathVariable Long beneficioId) {

        Response<List<ArquivoDTO>> response = Response.<List<ArquivoDTO>>builder().data(arquivoService.listarArquivosBeneficio(beneficioId)).build();

        return ResponseEntity
                .ok(response);
    }

    @GetMapping(value = "/{arquivoId}")
    public ResponseEntity<Response<ArquivoDTO>> getFile(@PathVariable Long arquivoId) {
        Response<ArquivoDTO> response = Response.<ArquivoDTO>builder().data(arquivoService.getFile(arquivoId)).build();

        return ResponseEntity
                .ok(response);
    }

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response<ArquivoDTO>> uploadFile(@ApiParam(name = "file", value = "Select the file to upload", required = true)
                                  @ModelAttribute ArquivoUploadDTO arquivoUploadDTO) throws IOException {
        Response<ArquivoDTO> response = Response.<ArquivoDTO>builder().data(arquivoService.storeFile(arquivoUploadDTO)).build();

        return ResponseEntity.ok(response);
    }

}

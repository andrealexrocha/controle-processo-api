package com.seplag.services.process.v1.services.validator;

import com.seplag.services.process.v1.data.dto.ArquivoUploadDTO;
import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import com.seplag.services.process.v1.exception.NullObjectException;
import com.seplag.services.process.v1.exception.NullParameterException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class ArquivoBasicoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ArquivoUploadDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object userTarget, Errors errors) {
        ArquivoUploadDTO novoArquivo = (ArquivoUploadDTO) userTarget;

        if (isEmpty(novoArquivo)) {
            throw new NullObjectException("Objeto arquivo requerido.");
        }

        if (ObjectUtils.isEmpty(novoArquivo.getDescricao()) || ObjectUtils.isEmpty(novoArquivo.getArquivoTipoId())
                || ObjectUtils.isEmpty(novoArquivo.getArquivo())) {
            throw new NullParameterException("Parâmetros requeridos.");
        }
    }

}

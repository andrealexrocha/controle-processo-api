package com.seplag.services.process.v1.services.validation;

import com.seplag.services.process.v1.data.dto.ArquivoUploadDTO;
import com.seplag.services.process.v1.services.validator.ArquivoBasicoValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ArquivoValidationImpl implements ConstraintValidator<ArquivoValidation, ArquivoUploadDTO> {

    @Autowired
    private ArquivoBasicoValidator arquivoBasicoValidator;

    @Override
    public void initialize(ArquivoValidation arquivoValidation) {

    }

    @Override
    public boolean isValid(ArquivoUploadDTO arquivo, ConstraintValidatorContext context) {
        arquivoBasicoValidator.validate(arquivo, null);

        return true;
    }
}

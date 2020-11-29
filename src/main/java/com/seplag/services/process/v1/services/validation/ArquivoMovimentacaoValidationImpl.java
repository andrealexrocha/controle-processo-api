package com.seplag.services.process.v1.services.validation;

import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import com.seplag.services.process.v1.services.validator.ArquivoMovimentacaoBasicoValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ArquivoMovimentacaoValidationImpl implements ConstraintValidator<ArquivoMovimentacaoValidation, ArquivoMovimentacaoDTO> {

    @Autowired
    private ArquivoMovimentacaoBasicoValidator arquivoMovimentacaoBasicoValidator;

    @Override
    public void initialize(ArquivoMovimentacaoValidation arquivoMovimentacaoValidation) {

    }

    @Override
    public boolean isValid(ArquivoMovimentacaoDTO arquivoMovimentacaoDTO, ConstraintValidatorContext context) {
        arquivoMovimentacaoBasicoValidator.validate(arquivoMovimentacaoDTO, null);

        return true;
    }
}

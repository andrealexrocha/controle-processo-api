package com.seplag.services.process.v1.services.validation;

import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import com.seplag.services.process.v1.services.validator.BeneficioBasicoValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BeneficioValidationImpl implements ConstraintValidator<BeneficioValidation, BeneficioDTO> {

    @Autowired
    private BeneficioBasicoValidator beneficioBasicoValidator;

    @Override
    public void initialize(BeneficioValidation beneficioValidation) {

    }

    @Override
    public boolean isValid(BeneficioDTO beneficio, ConstraintValidatorContext context) {
        beneficioBasicoValidator.validate(beneficio, null);

        return true;
    }
}

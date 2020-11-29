package com.seplag.services.process.v1.services.validator;

import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import com.seplag.services.process.v1.data.models.Beneficio;
import com.seplag.services.process.v1.exception.DuplicateKeyInsertionParameterException;
import com.seplag.services.process.v1.exception.NullObjectException;
import com.seplag.services.process.v1.exception.NullParameterException;
import com.seplag.services.process.v1.repository.BeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class BeneficioBasicoValidator implements Validator {

    @Autowired
    private BeneficioRepository beneficioRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return BeneficioDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object userTarget, Errors errors) {
        BeneficioDTO novoBeneficio = (BeneficioDTO) userTarget;

        if (isEmpty(novoBeneficio)) {
            throw new NullObjectException("Objeto benefício requerido.");
        }

        if (ObjectUtils.isEmpty(novoBeneficio.getNumero()) || ObjectUtils.isEmpty(novoBeneficio.getFuncionario())
                || ObjectUtils.isEmpty(novoBeneficio.getFuncionario().getId())) {
            throw new NullParameterException("Parâmetros requeridos.");
        }

        List<Beneficio> beneficios = beneficioRepository.findAllByNumero(novoBeneficio.getNumero());

        if (!CollectionUtils.isEmpty(beneficios)) {

            throw new DuplicateKeyInsertionParameterException("Já existe um benefício com esse código.");

        }
    }

}

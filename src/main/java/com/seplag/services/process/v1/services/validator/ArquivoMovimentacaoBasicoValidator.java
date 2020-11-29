package com.seplag.services.process.v1.services.validator;

import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import com.seplag.services.process.v1.exception.NullObjectException;
import com.seplag.services.process.v1.exception.NullParameterException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class ArquivoMovimentacaoBasicoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BeneficioDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object userTarget, Errors errors) {
        ArquivoMovimentacaoDTO novaMovimentacao = (ArquivoMovimentacaoDTO) userTarget;

        if (isEmpty(novaMovimentacao)) {
            throw new NullObjectException("Objeto movimentação requerido.");
        }

        if (ObjectUtils.isEmpty(novaMovimentacao.getParecer())
                || ObjectUtils.isEmpty(novaMovimentacao.getSetorOrigem())
                || ObjectUtils.isEmpty(novaMovimentacao.getSetorOrigem().getId())
                || ObjectUtils.isEmpty(novaMovimentacao.getSetorDestino())
                || ObjectUtils.isEmpty(novaMovimentacao.getSetorDestino().getId())) {
            throw new NullParameterException("Parâmetros requeridos.");
        }

    }

}

package com.seplag.services.process.v1.services.mapper;

import com.seplag.services.process.v1.data.dto.ArquivoMovimentacaoDTO;
import com.seplag.services.process.v1.data.models.ArquivoMovimentacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ArquivoMovimentacaoMapper {

    @Mapping(target = "arquivo.id", source = "arquivoId")
    ArquivoMovimentacao map(ArquivoMovimentacaoDTO source);

    @Mapping(target = "arquivoId", source = "arquivo.id")
    ArquivoMovimentacaoDTO map(ArquivoMovimentacao source);

    default List<ArquivoMovimentacaoDTO> map(List<ArquivoMovimentacao> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

}
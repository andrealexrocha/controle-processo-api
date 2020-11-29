package com.seplag.services.process.v1.services.mapper;

import com.seplag.services.process.v1.data.dto.ArquivoTipoDTO;
import com.seplag.services.process.v1.data.models.ArquivoTipo;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ArquivoTipoMapper {

    ArquivoTipoDTO map(ArquivoTipo source);

    default List<ArquivoTipoDTO> map(List<ArquivoTipo> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

}

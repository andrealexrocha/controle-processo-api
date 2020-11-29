package com.seplag.services.process.v1.services.mapper;

import com.seplag.services.process.v1.data.dto.ArquivoDTO;
import com.seplag.services.process.v1.data.models.Arquivo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ArquivoMapper {

    @Mapping(target = "beneficio.id", source = "beneficioId")
    Arquivo map(ArquivoDTO source);


    @Mapping(target = "beneficioId", source = "beneficio.id")
    ArquivoDTO map(Arquivo source);

    default List<ArquivoDTO> map(List<Arquivo> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

 }
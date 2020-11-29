package com.seplag.services.process.v1.services.mapper;

import com.seplag.services.process.v1.data.dto.BeneficioDTO;
import com.seplag.services.process.v1.data.models.Beneficio;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BeneficioMapper {

    BeneficioDTO map(Beneficio source);

    Beneficio map(BeneficioDTO source);

    default List<BeneficioDTO> map(List<Beneficio> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

}

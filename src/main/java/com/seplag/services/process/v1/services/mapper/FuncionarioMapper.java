package com.seplag.services.process.v1.services.mapper;

import com.seplag.services.process.v1.data.dto.FuncionarioDTO;
import com.seplag.services.process.v1.data.models.Funcionario;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioDTO map(Funcionario source);

    default List<FuncionarioDTO> map(List<Funcionario> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

}

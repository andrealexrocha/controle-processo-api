package com.seplag.services.process.v1.services.mapper;

import com.seplag.services.process.v1.data.dto.OrgaoDTO;
import com.seplag.services.process.v1.data.dto.SetorDTO;
import com.seplag.services.process.v1.data.models.Orgao;
import com.seplag.services.process.v1.data.models.Setor;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SetorMapper {

    SetorDTO map(Setor source);

    default List<SetorDTO> map(List<Setor> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

}

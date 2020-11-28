package com.seplag.services.process.v1.services.mapper;

import com.seplag.services.process.v1.data.dto.OrgaoDTO;
import com.seplag.services.process.v1.data.models.Orgao;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrgaoMapper {

    OrgaoDTO map(Orgao source);

    default List<OrgaoDTO> map(List<Orgao> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

}

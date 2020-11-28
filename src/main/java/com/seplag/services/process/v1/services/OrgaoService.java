package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.OrgaoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrgaoService {

	List<OrgaoDTO> requestOrgaos();

}

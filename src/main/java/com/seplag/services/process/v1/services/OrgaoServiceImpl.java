package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.OrgaoDTO;
import com.seplag.services.process.v1.repository.OrgaoRepository;
import com.seplag.services.process.v1.services.mapper.OrgaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrgaoServiceImpl implements OrgaoService {

	private final OrgaoRepository orgaoRepository;
	private final OrgaoMapper orgaoMapper;

	@Override
	public List<OrgaoDTO> requestOrgaos() {
		return this.orgaoMapper.map(orgaoRepository.findAll());
	}

}

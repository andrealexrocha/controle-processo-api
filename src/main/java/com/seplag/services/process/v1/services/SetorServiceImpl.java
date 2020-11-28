package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.OrgaoDTO;
import com.seplag.services.process.v1.data.dto.SetorDTO;
import com.seplag.services.process.v1.repository.OrgaoRepository;
import com.seplag.services.process.v1.repository.SetorRepository;
import com.seplag.services.process.v1.services.mapper.OrgaoMapper;
import com.seplag.services.process.v1.services.mapper.SetorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SetorServiceImpl implements SetorService {

	private final SetorRepository setorRepository;
	private final SetorMapper setorMapper;

	@Override
	public List<SetorDTO> listarSetores() {
		return this.setorMapper.map(setorRepository.findAll());
	}
}

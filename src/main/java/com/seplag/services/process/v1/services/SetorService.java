package com.seplag.services.process.v1.services;

import com.seplag.services.process.v1.data.dto.SetorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SetorService {

	List<SetorDTO> listar();

}

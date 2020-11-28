package com.seplag.services.process.v1.repository;

import com.seplag.services.process.v1.data.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
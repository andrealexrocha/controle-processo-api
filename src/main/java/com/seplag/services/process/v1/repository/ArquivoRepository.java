package com.seplag.services.process.v1.repository;

import com.seplag.services.process.v1.data.models.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

    List<Arquivo> findAllByBeneficioId(@Param("beneficioId") Long beneficioId);

}
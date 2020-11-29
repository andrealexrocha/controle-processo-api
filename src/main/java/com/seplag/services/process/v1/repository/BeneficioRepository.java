package com.seplag.services.process.v1.repository;

import com.seplag.services.process.v1.data.models.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {

    List<Beneficio> findAllByNumero(@Param("numero") String numero);
}
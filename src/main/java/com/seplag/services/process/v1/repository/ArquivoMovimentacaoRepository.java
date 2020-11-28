package com.seplag.services.process.v1.repository;

import com.seplag.services.process.v1.data.models.ArquivoMovimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArquivoMovimentacaoRepository extends JpaRepository<ArquivoMovimentacao, Long> {

    List<ArquivoMovimentacao> findAllByArquivoId(@Param("arquivoId") Long arquivoId);
}

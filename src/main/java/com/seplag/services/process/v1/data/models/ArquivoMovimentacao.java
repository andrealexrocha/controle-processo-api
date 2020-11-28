package com.seplag.services.process.v1.data.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "arquivo_movimentacao")
@Data
@EqualsAndHashCode(of = "id", callSuper = false)
public class ArquivoMovimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_tramitacao", nullable = false)
    private LocalDateTime data_tramitacao;

    @Column(name = "parecer", nullable = false)
    private String parecer;

    @ManyToOne
    @JoinColumn(name = "setor_origem_id", nullable = false)
    private Setor setorOrigem;

    @ManyToOne
    @JoinColumn(name = "setor_destino_id", nullable = false)
    private Setor setorDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arquivo_id", nullable = false)
    private Arquivo arquivo;

}
package com.seplag.services.process.v1.data.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "arquivo")
@Data
@EqualsAndHashCode(of = "id", callSuper = false)
public class Arquivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "tamanho", nullable = false)
    private Long tamanho;

    @Lob
    private byte[] binario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "beneficio_id", nullable = false)
    private Beneficio beneficio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arquivoTipo_id", nullable = false)
    private ArquivoTipo arquivoTipo;

}
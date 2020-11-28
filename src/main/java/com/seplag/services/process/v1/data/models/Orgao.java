package com.seplag.services.process.v1.data.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orgao")
@Data
@EqualsAndHashCode(of = "id", callSuper = false)
public class Orgao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

}
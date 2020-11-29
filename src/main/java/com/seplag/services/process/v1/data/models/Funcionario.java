package com.seplag.services.process.v1.data.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "funcionario")
@Data
@EqualsAndHashCode(of = "id", callSuper = false)
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "orgao_id", nullable = false)
    private Orgao orgao;

    @Column(name = "matricula", nullable = false)
    private String matricula;
}
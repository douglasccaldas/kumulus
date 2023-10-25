package com.kumulus.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.kumulus.desafio.enums.SituacaoEnum;

import lombok.Data;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
    @SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq", allocationSize = 1)
    private Long id;
    @Column(name = "ESTADO")
    private String uf;
    @Column(name = "CIDADE")
    private String localidade;
    private String bairro;
    private String logradouro;
    private String complemento;
    private int numero;
    private String cep;

    @Enumerated(EnumType.STRING)
    private SituacaoEnum situacao = SituacaoEnum.A;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
}
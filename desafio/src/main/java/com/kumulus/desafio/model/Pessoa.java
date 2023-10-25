package com.kumulus.desafio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.kumulus.desafio.enums.SexoEnum;

import lombok.Data;

@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", allocationSize = 1)
    private Long id;
    private String nome;
    private Date dtNascimento;
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true)
    private List<Endereco> enderecos;
    
    public Pessoa() {
    	this.enderecos = new ArrayList<Endereco>();
    }
}

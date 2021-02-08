package com.automatoDev.locadora.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity(name = "tb_motorista")
@JsonInclude(value = Include.NON_NULL)
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_motorista")
    private Long idMotorista;

    @NotBlank
    private String nome;

    @NotNull
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @NotBlank
    private String cpf;

    @NotBlank
    private String cnh;

    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties(value = "motorista")
    private List<Aluguel> alugueis;
    

    public void setIdMotorista(Long idMotorista){
        this.idMotorista = idMotorista;
    }

    public Long getIdMotorista(){
        return this.idMotorista;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento(){
        return this.dataNascimento;
    }


    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCnh(String cnh){
        this.cnh = cnh;
    }

    public String getCnh(){
        return this.cnh;
    }

    public void setAlugueis(List<Aluguel> alugueis){
        this.alugueis = alugueis;
    }

    public List<Aluguel> getAlugueis(){
        return this.alugueis;
    }

    
}

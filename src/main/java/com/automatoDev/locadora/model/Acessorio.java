package com.automatoDev.locadora.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity(name = "tb_acessorio")
@JsonInclude(value = Include.NON_NULL)
public class Acessorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acessorio")
	private Long idAcessorio;
	

	@ManyToMany(fetch = FetchType.EAGER,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JsonIgnoreProperties("acessorios")
	@JoinTable(name = "tb_carro_acessorio"
	, joinColumns = {@JoinColumn(name = "id_acessorio")}
	, inverseJoinColumns = {@JoinColumn(name  = "id_carro")})
	private List<Carro> carros;
	
	@NotBlank
	private String nome;

	public Long getIdAcessorio() {
		return idAcessorio;
	}

	public void setIdAcessorio(Long idAcessorio) {
		this.idAcessorio = idAcessorio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

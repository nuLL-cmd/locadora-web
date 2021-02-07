package com.automatoDev.locadora.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sun.istack.NotNull;

@Entity(name = "tb_carro")
@JsonInclude(value  = Include.NON_NULL)
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carro")
	private Long idCarro;
	
	@NotBlank
	private String placa;
	
	@NotBlank
	private String chassi;
	
	@NotBlank
	private String cor;

	
	@NotNull
	@Column(name = "valor_diaria")
	private BigDecimal valorDiaria;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_modelo")
	@JsonIgnoreProperties("carros")
	private Modelo modelo;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinTable(name = "tb_carro_acessorio"
	, joinColumns = {@JoinColumn(name = "id_carro")}
	, inverseJoinColumns = {@JoinColumn(name  = "id_acessorio")})
	@JsonIgnoreProperties("carros")
	private List<Acessorio> acessorios;

	//Atributo mapeado apenas para fins de deleção por parte do item "carro"
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carro", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Aluguel> alugueis;
	
	
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	public Long getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public void setModelo(Modelo modelo){
		this.modelo = modelo;
	}

	public Modelo getModelo(){
		return this.modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCarro == null) ? 0 : idCarro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (idCarro == null) {
			if (other.idCarro != null)
				return false;
		} else if (!idCarro.equals(other.idCarro))
			return false;
		return true;
	}
	
}

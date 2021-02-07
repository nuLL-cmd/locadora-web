package com.automatoDev.locadora.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity(name = "tb_apolice_seguro")
@JsonInclude(value = Include.NON_NULL)
public class ApoliceSeguro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apolice")
    private Long idApolice;

    @Column(name = "valor_franquia")
    @NotNull
    private BigDecimal valorFranquia;

    @Column(name = "protecao_terceiro")
    private Boolean protecaoTerceiro;

    @Column(name = "causas_naturais")
    private Boolean causasNaturais;

    @Column(name = "protecao_roubo")
    private Boolean protecaoRoubo;


    public void setIdApolice(Long idApolice){
        this.idApolice = idApolice;
    }

    public Long getIdApolice(){
        return this.idApolice;
    }
    public void setValorFranquia(BigDecimal valorFranquia){
        this.valorFranquia = valorFranquia;
    }

    public BigDecimal getValorFranquia(){
        return this.valorFranquia;
    }

    public void setProtecaoTerceiro(Boolean protecaoTerceiro){
        this.protecaoTerceiro = protecaoTerceiro;
    }

    public Boolean getProtecaoTerceiro(){
        return this.protecaoTerceiro;
    }

    public void setCausasNaturais(Boolean causasNaturais){
        this.causasNaturais = causasNaturais;
    }

    public Boolean getCausasNaturais(){
        return this.causasNaturais;
    }


    public void setProtecaoRoubo(Boolean protecaoRoubo){
        this.protecaoRoubo = protecaoRoubo;
    }

    public Boolean getProtecaoRoubo(){
        return this.protecaoRoubo;
    }
    
}

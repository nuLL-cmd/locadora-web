package com.automatoDev.locadora.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity(name = "tb_aluguel")
@JsonInclude(value = Include.NON_NULL)
public class Aluguel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "id_aluguel")
    private Long idAluguel;

    @Column(name = "data_pedido")
    private Calendar dataPedido;


    @Column(name = "data_entrega")
    private Date dataEntrega;

    @Column(name = "data_devolucao")
    private Date dataDevolucao;

    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_apolice")
    private ApoliceSeguro apolice;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name =  "id_carro")
    @JsonIgnoreProperties("alugueis")
    private Carro carro;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_motorista")
    @JsonIgnoreProperties(value = "alugueis")
    private Motorista motorista;


    public void setIdAlugel(Long idAluguel){
        this.idAluguel = idAluguel;
    }

    public Long getIdAluguel(){
        return this.idAluguel;
    }

    public void setDataPedido(Calendar dataPedido){
        this.dataPedido = dataPedido;
    }

    public Calendar getDataPedido(){
        return this.dataPedido;
    }

    public void setDataEntrega(Date dataEntrega){
        this.dataEntrega = dataEntrega;
    }

    public Date getDataEntrega(){
        return this.dataEntrega;
    }

    public void setDataDevolucao(Date dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataDevolucao(){
        return this.dataDevolucao;
    }

    public void setValorTotal(BigDecimal valorTotal){
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotal(){
        return this.valorTotal;
    }

    public void setCarro(Carro carro){
        this.carro = carro;
    }

    public Carro getCarro(){
        return this.carro;
    }

    public void setApolice(ApoliceSeguro apolice){
        this.apolice = apolice;
    }

    public ApoliceSeguro getApolice(){
        return this.apolice;
    }

    public void setMotorista(Motorista motorista){
        this.motorista = motorista;
    }

    public Motorista getMotorista(){
        return this.motorista;
    }
    
}

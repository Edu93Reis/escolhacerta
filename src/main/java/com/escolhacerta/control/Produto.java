package com.escolhacerta.control;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* indica��o de que esta � uma entidade da JPA (persistencia Java) */
@Entity
/* Indica��o do Hibernate de qual ser� a tabela em que ser�o persistidos os dados */
@Table(name="produto")
public class Produto extends AvaliaProduto implements Pesquisa, Serializable {
	private static final long serialVersionUID = -3295609497396391454L;
	//add comentario
	//@Id
	@GeneratedValue
	private Integer idProduto;
	private String marca;
	private Integer idModelo;
	private String modelo;
	private String comentario;
	private BigDecimal preco;
	private Date dtCadastro;
	
	public Produto(){
	}
	
	/*public Produto(Integer pontuacao, Integer idProduto, String marca, Integer idModelo,
			String modelo, BigDecimal preco, Date dtCadastro){			
		super(pontuacao);
		this.idProduto = idProduto;
		this.marca = marca;
		this.idModelo = idModelo;
		this.modelo = modelo;
		this.preco = preco;
		this.dtCadastro = dtCadastro;
	}*/
	
	public Integer getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	//varios produtos mesmo modelo
	//@ManyToOne
	@JoinColumn(name="idModelo")
	public Integer getIdModelo() {
		return idModelo;
	}
	
	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}
	
	//@ManyToOne
	@JoinColumn(name="nmModelo")
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	//@ManyToMany
	@JoinColumn(name="comentario")
	public String getComent(){
		return comentario;
	}
	
	public void setComent(String comentario){
		this.comentario = comentario;
	}
	
	//@ManyToMany
	@JoinColumn(name="cdPreco")
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Date getDtCadastro() {
		return dtCadastro;
	}
	
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	@Override
	public void pesquisa() {
		// TODO Auto-generated method stub
		
	}
}

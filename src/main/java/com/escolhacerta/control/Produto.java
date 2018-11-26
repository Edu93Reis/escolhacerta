package com.escolhacerta.control;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*** Classe da camada de controle responsável pela criação dos Produtos, segue o modelo do DER ***/
public class Produto implements Serializable {
	private static final long serialVersionUID = -3295609497396391454L;
	private Integer idProduto;
	private byte imagemProduto;
	private String nmProduto;
	private String modelo;
	private String comentario;
	private BigDecimal preco;
	private Date dtCadastro;
	private Integer idCategoria;
	private Integer pontuacao;
	
	public static List<Produto> produtos;
	
	public Produto(){
	}
	
	public Integer getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
	
	public byte getImagemProduto() {
		return imagemProduto;
	}

	public void setImagemProduto(byte imagemProduto) {
		this.imagemProduto = imagemProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}
	
	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getComent(){
		return comentario;
	}
	
	public void setComent(String comentario){
		this.comentario = comentario;
	}
	
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
	
	public Integer getIdCategoria(){
		return this.idCategoria;
	}
	
	public void setIdCategoria(Integer idCategoria){
		this.idCategoria = idCategoria;
	}
	
	public Integer getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

}

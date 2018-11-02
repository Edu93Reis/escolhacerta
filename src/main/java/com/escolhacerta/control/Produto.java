package com.escolhacerta.control;

import com.escolhacerta.control.Pesquisa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/* indica��o de que esta � uma entidade da JPA (persistencia Java) */
//@Entity
/* Indica��o do Hibernate de qual ser� a tabela em que ser�o persistidos os dados */
//@Table(name="produto")
public class Produto extends AvaliaProduto implements Pesquisa, Serializable {
	private static final long serialVersionUID = -3295609497396391454L;
	//add comentario
	//@Id
	//@GeneratedValue
	private Integer idProduto;
	private String nmProduto;
	private Integer idModelo;
	private String modelo;
	private String comentario;
	private BigDecimal preco;
	private Date dtCadastro;
	private int idCategoria;
	
	public static List<Produto> produtos;
	
	public Produto(){
	}
	
	public Integer getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
	public String getNome() {
		return nmProduto;
	}
	
	public void setNome(String nmProduto) {
		this.nmProduto = nmProduto;
	}
	
	//@ManyToOne
	//@JoinColumn(name="nmModelo")
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	//@ManyToMany
	//@JoinColumn(name="comentario")
	public String getComent(){
		return comentario;
	}
	
	public void setComent(String comentario){
		this.comentario = comentario;
	}
	
	//@ManyToMany
	//@JoinColumn(name="cdPreco")
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
	
	public int getIdCategoria(){
		return this.idCategoria;
	}
	
	public void setIdCategoria(int idCategoria){
		this.idCategoria = idCategoria;
	}
	
	

	@Override
	public void pesquisa() {
		// TODO Auto-generated method stub
	}
}

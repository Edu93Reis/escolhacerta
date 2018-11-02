package com.escolhacerta.control;

import java.io.Serializable;

/* indica��o de que esta � uma entidade da JPA (persistencia Java) */
//@Entity
/* Indica��o do Hibernate de qual ser� a tabela em que ser�o persistidos os dados */
//@Table(name="Categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 8782690768665611462L;
	//indica��o do Hibernate por annotations de 
	//@Id --> chave prim�ria, @GeneratedValue --> valor gerado automaticamente, e nome e caracter�sticas 
	//das colunas que equivalem ao atributo (atributo idUsuario == coluna idUsuario no MySQL)
	//@Id
	//@GeneratedValue
	//@Column(name="idCategoria", nullable=false, unique=true)
	private Integer idCategoria;
	//@Column(name="nmCategoria", nullable=false, unique=true)
	private String nomeCategoria;
	
	public Categoria(){
	}
	
	public Categoria(String nomeCategoria){
		this.nomeCategoria = nomeCategoria;
	}
	
	public Integer getId(){
		return this.idCategoria;
	}
	
	public void setCategoria(String nomeCategoria){
		this.nomeCategoria = nomeCategoria;
	}
	
	public String getCategoria(){
		return this.nomeCategoria;
	}
}

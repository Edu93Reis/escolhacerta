package com.escolhacerta.control;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* indicação de que esta é uma entidade da JPA (persistencia Java) */
@Entity
/* Indicação do Hibernate de qual será a tabela em que serão persistidos os dados */
@Table(name="Categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 8782690768665611462L;
	//indicação do Hibernate por annotations de 
	//@Id --> chave primária, @GeneratedValue --> valor gerado automaticamente, e nome e características 
	//das colunas que equivalem ao atributo (atributo idUsuario == coluna idUsuario no MySQL)
	@Id
	@GeneratedValue
	@Column(name="idCategoria", nullable=false, unique=true)
	private Integer idCategoria;
	@Column(name="nmCategoria", nullable=false, unique=true)
	private String nomeCategoria;
	
	public Integer getId(){
		return this.idCategoria;
	}
	
	public void setCategoria(String nomeCategoria){
		this.nomeCategoria = nomeCategoria;
	}
}

package com.escolhacerta.control;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* indica��o de que esta � uma entidade da JPA (persistencia Java) */
//@Entity
/* Indica��o do Hibernate de qual ser� a tabela em que ser�o persistidos os dados */
//@Table(name="modelo")
public class AvaliaProduto implements Serializable {
	private static final long serialVersionUID = 1516958479294508565L;
	protected Integer pontuacao;
	
	public AvaliaProduto(){		
	}
	
	//@Id
	//@GeneratedValue
	public Integer getPontuacao() {
		return pontuacao;
	}
	
	/* estudar se vai deixar retorno int ou double na m�dia da pontua��o */
	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public void pesquisa() {
		// TODO Auto-generated method stub
		
	}
	
}

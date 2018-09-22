package com.escolhacerta.control;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* indicação de que esta é uma entidade da JPA (persistencia Java) */
@Entity
/* Indicação do Hibernate de qual será a tabela em que serão persistidos os dados */
@Table(name="modelo")
public class AvaliaProduto implements Serializable {
	private static final long serialVersionUID = 1516958479294508565L;
	protected Integer pontuacao;
	
	public AvaliaProduto(){		
	}
	
	@Id
	@GeneratedValue
	public Integer getPontuacao() {
		return pontuacao;
	}
	
	/* estudar se vai deixar retorno int ou double na média da pontuação */
	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}

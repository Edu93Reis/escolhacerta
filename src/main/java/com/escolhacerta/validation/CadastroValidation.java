package com.escolhacerta.validation;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class CadastroValidation {
	private Date data;
	private String estado;
	
	public Date converteData(String data){
		try{
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dataFinal = parser.parse(data);
			this.data = new java.sql.Date(dataFinal.getTime());
			
			return this.data;
		} catch(Exception e){
			throw new RuntimeException("Erro ao converter data! ", e);
		}
	}
	
	//https://stackoverflow.com/questions/530012/how-to-convert-java-util-date-to-java-sql-date
	//http://respostas.guj.com.br/34683-como-formatar-uma-data-em-java-para-para-inserir-no-banco-de-dados-no-formato-certo
	
	public String converteEstado(){
		
		return estado;
	}
	//https://pt.stackoverflow.com/questions/197109/famoso-erro-erro-de-convers%C3%A3o-ao-definir-o-valor-xxx-para-null-converter
}

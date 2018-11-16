package com.escolhacerta.validation;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class CadastroValidation {
	private java.sql.Date data;
	private String estado;
	
	public Date converteData(String data){
		//DateFormat read = new SimpleDateFormat("EEE MMM dd yyyy hh:mm aaa");
		//Thu Dec 03 22:00:00 BRST 1987
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		/*String dia = data.substring(8, 9);
		String mes = data.substring(4, 6);
		String ano = data.substring(24, 28);*/
		String dia = data.substring(9, 11);
		String mes = data.substring(5, 8);
		//aqui está certo, último elemento é o 28
		String ano = data.substring(25, 29);
		
		if(mes.equals("jan")){
			mes = "1";
		}else if(mes.equals("feb")){
			mes = "02";
		}else if(mes.equals("mar")){
			mes = "03";
		}else if(mes.equals("apr")){
			mes = "04";
		}else if(mes.equals("may")){
			mes = "05";
		}else if(mes.equals("jun")){
			mes = "06";
		}else if(mes.equals("jul")){
			mes = "07";
		}else if(mes.equals("aug")){
			mes = "08";
		}else if(mes.equals("set")){
			mes = "09";
		}else if(mes.equals("oct")){
			mes = "10";
		}else if(mes.equals("nov")){
			mes = "11";
		}else{
			mes = "12";
		}
		
		data = ano+"-"+mes+"-"+dia;
		
		try{
			//SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			//java.util.Date dataFinal = read.parse(data);
			//dataFinal = parser.format(dataFinal);
			//java.util.Date dataFinal = parser.parse(data);
			//java.util.Date dataFinal = DateFormat.getDateInstance().parse(data);
			//java.util.Date dataFinal = parser.parse(data);
			//String dataFinal = parser.format(data);
			//this.data = java.sql.Date.valueOf(dataFinal);
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

package com.escolhacerta.control;

import java.io.Serializable;
import java.util.Date;

/* A cada requisição realizada o bean � gravado em um map , chamado de  view map 
** e, por conta disso, este bean deve implementar a interface Serializable */
public class Usuario implements Serializable {	
	private static final long serialVersionUID = 3445560597837908750L;
	private Integer idUsuario;
	private String email;
	private String nome;
	private String senha;
	private Date nasc;
	private String cpf;
	private Integer idEndereco;
	private String cidade;
	private String estado;
	private String estados;
	private String cep;
	
	public Integer getIdUser(){
		return this.idUsuario;
	}
	
	public void setIdUser(Integer idUsuario){
		this.idUsuario = idUsuario;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		//|| nome.getClass().toString() != "String" || nome.equals("  ")
		if(nome.equals(null)){
			System.out.println("Insira valor no campo nome!");
		}else{
			this.nome = nome;
		}
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		if(senha.equals(null)){
			System.out.println("Insira valor no campo senha!");
		}else{		
			this.senha = senha;
		}
	}
	
	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		if(nasc.equals(null)) {
			System.out.println("Insira valor no campo nascimento!");
		}else{
			this.nasc = nasc;
		}
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		if(cpf.equals(null)){
			System.out.println("Insira valor no campo CPF!");
		}else{	
			this.cpf = cpf;
		}
	}
	
	public Integer getEndereco(){
		return idEndereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		if(cidade.equals(null)){
			System.out.println("Insira valor no campo cidade!");
		}else{		
			this.cidade = cidade;
		}
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		if(cidade.equals(null)){
			System.out.println("Insira valor no campo cidade!");
		}else{		
			this.estado = estado;
		}
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
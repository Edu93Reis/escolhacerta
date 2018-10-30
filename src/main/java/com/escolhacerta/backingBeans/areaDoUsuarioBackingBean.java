package com.escolhacerta.backingBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;

@SuppressWarnings("deprecation")
@ManagedBean(name="cadastroBean")
public class AreaDoUsuarioBackingBean {
	private HtmlInputText email;
	private HtmlInputSecret senha;
	private HtmlInputText data;
	private HtmlInputText cpf;
	private HtmlInputText cidade;
	private HtmlInputText cep;
	private HtmlSelectOneMenu estado;
	private HtmlCommandLink linkEmail, linkSenha, linkData, linkCPF, linkCidade, linkEstado, linkCep;
	private HtmlCommandButton btnCadastro;
	private HtmlForm cadastroProduto;
	
	public void desativaEmail(){
		if(this.email.isDisabled()){
			this.email.setDisabled(false);
			this.email.setStyle("background: white; width: 370px; border: 1px solid orange;");
		}
	}
	
	public void desativaSenha(){
		if(this.senha.isDisabled()){
			this.senha.setDisabled(false);
			this.senha.setStyle("background: white; width: 220px; border: 1px solid orange;");
		}
	}
	
	public void desativaData(){
		if(this.data.isDisabled()){
			this.data.setDisabled(false);
			this.data.setStyle("background: white; width: 220px; border: 1px solid orange;");
		}
	}
	
	public void desativaCPF(){
		if(this.cpf.isDisabled()){
			this.cpf.setDisabled(false);
			this.cpf.setStyle("background: white; width: 190px; border: 1px solid orange;");
		}
	}
	
	public void desativaCidade(){
		if(this.cidade.isDisabled()){
			this.cidade.setDisabled(false);
			this.cidade.setStyle("background: white; width: 190px; border: 1px solid orange;");
		}
	}
	
	public void desativaEstado(){
		if(this.estado.isDisabled()){
			this.estado.setDisabled(false);
			this.estado.setStyle("background: white; width: 190px; border: 1px solid orange;");
		}
	}
	
	public void desativaCep(){
		if(this.cep.isDisabled()){
			this.cep.setDisabled(false);
			this.cep.setStyle("background: white; width: 190px; border: 1px solid orange;");
		}
	}
	
	public void ativaCadastro(){
		if(this.cadastroProduto.getStyle().equals("display:none;")){
			this.cadastroProduto.setStyle("display: block");
		}
	}
		
	public HtmlInputText getEmail() {
		return email;
	}
	public void setEmail(HtmlInputText email) {
		this.email = email;
	}
	public HtmlInputSecret getSenha() {
		return senha;
	}
	public void setSenha(HtmlInputSecret senha) {
		this.senha = senha;
	}
	public HtmlInputText getData() {
		return data;
	}
	public void setData(HtmlInputText data) {
		this.data = data;
	}
	public HtmlInputText getCpf() {
		return cpf;
	}
	public void setCpf(HtmlInputText cpf) {
		this.cpf = cpf;
	}
	public HtmlInputText getCidade() {
		return cidade;
	}
	public void setCidade(HtmlInputText cidade) {
		this.cidade = cidade;
	}
	public HtmlSelectOneMenu getEstado() {
		return estado;
	}
	public void setEstado(HtmlSelectOneMenu estado) {
		this.estado = estado;
	}
	public HtmlInputText getCep() {
		return cep;
	}
	public void setCep(HtmlInputText cep) {
		this.cep = cep;
	}
	public HtmlCommandLink getLinkEmail() {
		return linkEmail;
	}

	public void setLinkEmail(HtmlCommandLink linkEmail) {
		this.linkEmail = linkEmail;
	}
	
	public HtmlCommandLink getLinkSenha() {
		return linkSenha;
	}

	public void setLinkSenha(HtmlCommandLink linkSenha) {
		this.linkSenha = linkSenha;
	}

	public HtmlCommandLink getLinkData() {
		return linkData;
	}

	public void setLinkData(HtmlCommandLink linkData) {
		this.linkData = linkData;
	}

	public HtmlCommandLink getLinkCPF() {
		return linkCPF;
	}

	public void setLinkCPF(HtmlCommandLink linkCPF) {
		this.linkCPF = linkCPF;
	}

	public HtmlCommandLink getLinkCidade() {
		return linkCidade;
	}

	public void setLinkCidade(HtmlCommandLink linkCidade) {
		this.linkCidade = linkCidade;
	}

	public HtmlCommandLink getLinkEstado() {
		return linkEstado;
	}

	public void setLinkEstado(HtmlCommandLink linkEstado) {
		this.linkEmail = linkEstado;
	}
	
	public HtmlCommandButton getBtnCadastro() {
		return btnCadastro;
	}

	public void setBtnCadastro(HtmlCommandButton btnCadastro) {
		this.btnCadastro = btnCadastro;
	}
	
	public HtmlCommandLink getLinkCep() {
		return linkCep;
	}

	public void setLinkCep(HtmlCommandLink linkCep) {
		this.linkCep = linkCep;
	}
	
	public HtmlForm getCadastroProduto() {
		return cadastroProduto;
	}
	public void setCadastroProduto(HtmlForm cadastroProduto) {
		this.cadastroProduto = cadastroProduto;
	}
	
}

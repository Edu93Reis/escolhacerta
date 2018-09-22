package com.escolhacerta.view;

import com.escolhacerta.control.Usuario;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserArea {
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;

	public UserArea(){
		this.usuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
	}
	
	public void incluiUsuario(){
		this.usuarios.add(usuario);
		this.usuario = new Usuario();
	}

	public void removerUsuario(){
		this.usuarios.remove(usuario);
		this.usuario = new Usuario();
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}

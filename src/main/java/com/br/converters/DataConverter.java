package com.br.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

import com.escolhacerta.control.Usuario;

@FacesConverter(value = "dataConverter", forClass = Usuario.class)
public class DataConverter implements Converter {
	public static final DateFormat fomatador = new SimpleDateFormat("yyyy-MM-dd");
	
	//List<Usuario> user = Usuario.estadosList(); 
	//string valor = valor passado no input, component é o component, context é o contexto JSF 
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		//regex: "\\d+" :: verifica se o id do objeto é um número mesmo
        if (valor != null && !valor.isEmpty() && valor.matches("\\d+")) {
        	//cria novo usuario
        	Usuario u = new Usuario();
        	//seta id como o recebido do seletOneMenu
        	u.setIdUser(Integer.parseInt(valor));
        	//verifica qual o usuario na posição passada dentro da lista alimentada
        	//com estados
        	//int posicao = user.indexOf(u);
        	//return user.get(posicao);
            //return seuMetodoParaProcurarPlanosPorIDnoBanco(string);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object valor) {
        if (valor != null && (valor instanceof Usuario)) {
        	Usuario user = (Usuario) valor;
        	if(user.getIdUser() != null){
        		return user.getIdUser().toString();
        	}
        	//return String.valueOf(((Usuario) u).getEstado());
            //return String.valueOf(((Usuario) u).getId());
        }

        return null;
    }
}

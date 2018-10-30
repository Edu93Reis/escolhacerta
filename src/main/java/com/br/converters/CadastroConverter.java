package com.br.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

import com.escolhacerta.control.Usuario;

@FacesConverter(value = "cadastroConverter", forClass = Usuario.class)
public class CadastroConverter implements Converter {
	//List<Usuario> user = Usuario.estadosList(); 
	
	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		//regex: "\\d+" :: verifica se o id do objeto é um número mesmo
        if (string != null && !string.isEmpty() && string.matches("\\d+")) {
        	//cria novo usuario
        	Usuario u = new Usuario();
        	//seta id como o recebido do seletOneMenu
        	u.setIdUser(Integer.parseInt(string));
        	//verifica qual o usuario na posição passada dentro da lista alimentada
        	//com estados
        	//int posicao = user.indexOf(u);
        	//return user.get(posicao);
            //return seuMetodoParaProcurarPlanosPorIDnoBanco(string);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object u) {
        if (u != null && (u instanceof Usuario)) {
        	Usuario user = (Usuario) u;
        	if(user.getIdUser() != null){
        		return user.getIdUser().toString();
        	}
        	//return String.valueOf(((Usuario) u).getEstado());
            //return String.valueOf(((Usuario) u).getId());
        }

        return null;
    }
}

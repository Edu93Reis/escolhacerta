package com.br.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

import com.escolhacerta.control.Usuario;

@FacesConverter(value = "selectConverter", forClass = Usuario.class)
public class SelectOneMenuConverter implements Converter {
	//string valor = valor passado no input, component é o component, context é o contexto JSF 
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String valor) {
        if (valor != null && !valor.isEmpty()) {
        	return (Usuario) component.getAttributes().get(valor);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object valor) {
        if (valor != null && (valor instanceof Usuario)) {
        	Usuario user = (Usuario) valor;
        	if(user.getIdUser() != null && user instanceof Usuario && user.getIdUser() != null){
        		return user.getIdUser().toString();
        	}
        }

        return "";
    }
}

package com.br.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

import com.escolhacerta.control.Categoria;

@FacesConverter(value = "categoriaConverter", forClass = Categoria.class)
public class CategoriaConverter implements Converter {
	//string valor = valor passado no input, component é o component, context é o contexto JSF 
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		Categoria retorno = null;
		
        if (valor != null && !valor.isEmpty()) {
        	retorno = (Categoria) component.getAttributes().get(valor);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object valor) {
    	String retorno = "";
        if (valor != null && (valor instanceof Categoria)) {
        	Categoria c = (Categoria) valor;
        	if(c.getCategoria() != null && c instanceof Categoria){
        		//usar para retorno do Id
        		retorno = c.getCategoria().toString();
        	}
        }

        return retorno;
    }
}

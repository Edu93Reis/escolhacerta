package com.escolhacerta.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;

import com.escolhacerta.control.Produto;

@SuppressWarnings("deprecation")
@ViewScoped
public class DataTableBean implements Serializable {
	private static final long serialVersionUID = 2765284301822929745L;
	private List<Produto> produtos = Produto.produtos;
	
}

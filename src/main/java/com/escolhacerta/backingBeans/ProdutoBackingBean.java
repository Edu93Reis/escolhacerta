package com.escolhacerta.backingBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandLink;

import com.escolhacerta.control.Produto;

@SuppressWarnings("deprecation")
@ManagedBean(name="produtoBean")
public class ProdutoBackingBean {
	private HtmlCommandLink star;
	private Produto produto;

	public void pontuation(){
		if(this.star.getId().equals("one")){
			this.star.setStyleClass("fas fa-star");
			this.star.setStyle("color: yellow;");
		}if(this.star.getId().equals("two")){
			this.star.setStyleClass("fas fa-star");
			this.star.setStyle("color: yellow;");
		}if(this.star.getId().equals("three")){
			this.star.setStyleClass("fas fa-star");
			this.star.setStyle("color: yellow;");
		}if(this.star.getId().equals("four")){
			this.star.setStyleClass("fas fa-star");
			this.star.setStyle("color: yellow;");
		}if(this.star.getId().equals("five")){
			this.star.setStyleClass("fas fa-star");
			this.star.setStyle("color: yellow;");
		}	
	}
	
	public HtmlCommandLink getStar() {
		return star;
	}

	public void setStar(HtmlCommandLink star) {
		this.star = star;
	}
	
}

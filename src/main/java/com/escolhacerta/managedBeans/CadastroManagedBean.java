package com.escolhacerta.managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.escolhacerta.control.Usuario;
import com.escolhacerta.util.HibernateUtil;

@SuppressWarnings("deprecation")
@ManagedBean(name = "cadastroManagedBean")
@Named
@ViewScoped
public class CadastroManagedBean {
	//private Usuario cadastro;
	
	public void incluiUsuario(){
		//new HibernateUtil();
		//Session session = HibernateUtil.getSession();
		//prepara envio dos dados
		//Transaction t = session.beginTransaction();
		
		//merge: atualiza se objeto j� existe
		//ou apenas insere caso ainda n�o exista
		//session.merge(this.cadastro);
		
		//envia os dados, semelhante ao commit do Git
		/*t.commit();
		session.close();
		
		//this.cadastro = new Usuario();
		
		String msg = "Parabéns, você está cadastrado!";
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg)); */
	}
}

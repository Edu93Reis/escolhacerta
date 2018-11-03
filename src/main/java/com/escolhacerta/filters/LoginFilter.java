package com.escolhacerta.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escolhacerta.managedBeans.LoginManagedBean;

public class LoginFilter implements Filter {
	@Inject
	private LoginManagedBean loginManagedBean;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse res = (HttpServletResponse) servletResponse;
		//recebe a url
		String url = req.getRequestURL().toString();
		System.out.println(url);
		//se ela possuir o argumento restricted
		if(url.contains("/restricted") && loginManagedBean.getUsuario() == null){
			//redireciona de volta para a página de login, caso usuario esteja nulo (não logado)
			res.sendRedirect(req.getServletContext().getContextPath()+"/login.xhtml");
		}else{
			//se logado executa normalmente
			filter.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig filter) throws ServletException {
		
	}

}

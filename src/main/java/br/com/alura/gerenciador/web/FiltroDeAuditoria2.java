package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

/**
 * Servlet Filter implementation class FiltroDeAuditoria2
 */


@WebFilter("/*")
public class FiltroDeAuditoria2 implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroDeAuditoria2() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String usuario = getUsuario(req);
		System.out.println("Usuario"+usuario+ "acessando a pagina" +uri);
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario)req.getSession().getAttribute("usuarioLogado");
		if (usuario == null) return "<deslogado>";
		return usuario.getEmail();
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package br.edu.ifgoiano.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifgoiano.entidade.Usuario;

@WebServlet("/mensageria")
public class MensageriaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Usuario> listaDeUsuario = new ArrayList<Usuario>();
		
		for (int i = 0; i < 10; i++) {
			Usuario usuario = new Usuario();
			
			usuario.setId(i);
			usuario.setEmail("teste" + i + "@gmail.com");
			
			listaDeUsuario.add(usuario);
		}
		
		req.setAttribute("listaDeUsuario", listaDeUsuario);
		req.getRequestDispatcher("index.jsp").forward(req, resp);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String html = new String();
		html = "<html>"
				+ "<body>"
				+ "<h1 style=\"text-align: center; font-family: Arial, sans-serif;\">E-mail enviado com sucesso</h1>"
				+ "</body>"
				+ "</html>";
		PrintWriter writer = resp.getWriter();
		writer.println(html);
		
		LocalTime horarioAtual = LocalTime.now();
		
		String email = (String) req.getParameter("email");
		String valorTitulo = (String) req.getParameter("valorTitulo");
		String valorTexto = (String) req.getParameter("valorTexto");
		String aviso = (String) req.getParameter("valorCheckbox");
		String cumprimento = (String) req.getParameter("valorCumprimento");
		
		System.out.println("E-mail enviado para: ".concat(email));
		System.out.println("");
		System.out.println(valorTitulo);
		System.out.println("");
		
		if (cumprimento != null) {
		    if (cumprimento.equals("cumprimentoHorario")) {
		    	if (horarioAtual.isAfter(LocalTime.of(5, 0)) && horarioAtual.isBefore(LocalTime.of(11, 59))) {
				    System.out.println("Bom dia, " + valorTexto);
				} else if (horarioAtual.isAfter(LocalTime.of(12, 0)) && horarioAtual.isBefore(LocalTime.of(18, 59))) {
					System.out.println("Boa Tarde, " + valorTexto);
				} else {
					System.out.println("Boa noite, " + valorTexto);
				}
		    } else if (cumprimento.equals("cumprimentoFormal")) {
		        System.out.println("Prezada(o), " + valorTexto);
		    } else {
		        System.out.println("");
		    }
		} 

		if ("on".equals(aviso)) {
			System.out.println("");
		    System.out.println("Atenção: esse é um e-mail automático e não deve ser respondido.");
		} else {
		    System.out.println("");
		}
	}
}

package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/livrariaServ","/main","/insert","/select","/update","/delete","/mesclar","/mostrar"})
public class livrariaServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
      livrariaDao dao = new livrariaDao();
      livrariaMetodos livraria = new livrariaMetodos();
      ArrayList<livrariaMetodos> lista = dao.listarLivros();


      	
    public livrariaServ() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		if (action.equals("/main")) {
			livrariaCategoria(request, response);
		} else if (action.equals("/insert")) {
			novoLivro(request, response);
		} else if (action.equals("/select")) {
			listarLivro(request, response);
		} else if (action.equals("/update")) {
			editarLivro(request, response);
		} else if (action.equals("/delete")) {
			removerLivro(request, response);
		} else if (action.equals("/mesclar")) {
			mesclarLivro(request, response);
		} else if (action.equals("/mostrar")) {
			mostrarLivro(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		
	}
	
	protected void livrariaCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<livrariaMetodos> lista = dao.listarLivros();
		
		
		request.setAttribute("tblivros", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listaLivrosPorCategoria.jsp");
		rd.forward(request, response);
		//response.sendRedirect("listaLivrosPorCategoria.html");
	}
	

	
	protected void novoLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setar as variaveis livrariaMetodos
		livraria.setIdc(Long.parseLong(request.getParameter("idc")));
		livraria.setTitulo(request.getParameter("titulo"));
		livraria.setAutor(request.getParameter("autor"));
		livraria.setCategoria(request.getParameter("categoria"));
		livraria.setValor(Float.parseFloat(request.getParameter("valor")));
		dao.insertLivro(livraria);
		// redirecionar para o documento
		response.sendRedirect("main");
	}
	
	protected void listarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recebimento do id do livro que será editado
		Long idc = Long.parseLong(request.getParameter("id"));
		//setar a variavel livrariaMetodos
		livraria.setIdc((idc));
		//Executar o metodo selecionarLivro
		dao.selecionarLivro(livraria);
		//setar os atributos do formulário com o conteudo livraria Metodos
		request.setAttribute("idc", livraria.getIdc());
		request.setAttribute("titulo", livraria.getTitulo());
		request.setAttribute("autor", livraria.getAutor());
		request.setAttribute("categoria", livraria.getCategoria());
		request.setAttribute("valor", livraria.getValor());
		//Encaminhar ao documento editar
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}
	
	protected void editarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Setar as variaveis
		livraria.setIdc(Long.parseLong(request.getParameter("idc")));
		livraria.setTitulo(request.getParameter("nome"));
		livraria.setAutor(request.getParameter("autor"));
		livraria.setCategoria(request.getParameter("categoria"));
		livraria.setValor(Float.parseFloat(request.getParameter("valor")));
		// executar o metodo alterarLivro
		dao.alterarLivro(livraria);
		//redirecionar para o documento listar
		response.sendRedirect("main");
	}
	
	protected void removerLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recebimento do id do contato a ser excluído (confirmador.js)
		String idc = request.getParameter("idc");
		//setar a variavel livrariaMetodos
		livraria.setIdc(Long.parseLong(idc));
		//executar o método delete
		dao.deletarLivro(livraria);
		//redirecionar para o documento listar
		response.sendRedirect("main");
		
	}
	
	protected void mesclarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		livraria.setCategoria(request.getParameter("categoria"));
		System.out.println(livraria.getCategoria());
		
		
		ArrayList<livrariaMetodos> lista1 = dao.mesclarLivros(livraria);
		
		request.setAttribute("tblivros", lista1);
		RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
		rd.forward(request, response);
		
	}
	
	protected void mostrarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setar as variaveis livrariaMetodos
		livraria.setIdc(Long.parseLong(request.getParameter("idc")));
		System.out.println(livraria.getIdc());
		dao.mostrarLivro(livraria);
		// redirecionar para o documento
		request.setAttribute("idc", livraria.getIdc());
		request.setAttribute("titulo", livraria.getTitulo());
		request.setAttribute("autor", livraria.getAutor());
		request.setAttribute("categoria", livraria.getCategoria());
		request.setAttribute("valor", livraria.getValor());
		RequestDispatcher rd = request.getRequestDispatcher("mostrarLivro.jsp");
		rd.forward(request, response);
	}
	
	
}

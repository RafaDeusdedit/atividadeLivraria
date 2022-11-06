<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlets.livrariaMetodos" %>
<%@ page import="java.util.ArrayList" %>

<%	
	ArrayList<livrariaMetodos> lista1 = (ArrayList<livrariaMetodos>) request.getAttribute("tblivros");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<select name="selecione">
	  	<option value="Arquitetura">Arquitetura</option>
	  	<option value="Desgin" >Desgin</option>
	  	<option value="Informática">InformÃ¡tica</option>
	  	<option value="Literatura brasileira">Literatura brasileira</option>
	  	<option value="Literatura infantil">Literatura infantil</option>
	  	<option value="Literatura universal">Literatura universal</option>
	  	<option value="Música e arte">MÃºsica e arte</option>
	</select>
	<a href="mesclar" >Mesclar</a>
	
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Autor</th>
				<th>Categoria</th>
				<th>Valor</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0; i < lista1.size(); i++) {%>
				<tr>
					<td><%=lista1.get(i).getIdc() %></td>
					<td><%=lista1.get(i).getTitulo() %></td>
					<td><%=lista1.get(i).getAutor() %></td>
					<td><%=lista1.get(i).getCategoria() %></td>
					<td><%=lista1.get(i).getValor() %></td>
					<td><a href="select?id=<%=lista1.get(i).getIdc() %>" >Editar</a>
					<a href="javascript: confirmar(<%=lista1.get(i).getIdc() %>)" >Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>




	<script src="Scripts/confirmador.js"></script>
	<a href="main">|Lista de Livros|</a>
	<a href="cadastrar.html">|=Cadastrar livros=|</a>
</body>
</html>
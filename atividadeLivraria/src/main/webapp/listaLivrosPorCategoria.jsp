<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlets.livrariaMetodos" %>
<%@ page import="java.util.ArrayList" %>

<%	
	ArrayList<livrariaMetodos> lista = (ArrayList<livrariaMetodos>) request.getAttribute("tblivros");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="formMesc" action="mesclar">
	<select name="categoria">
	  	<option value="Arquitetura">Arquitetura</option>
	  	<option value="Desgin" >Desgin</option>
	  	<option value="Informática">InformÃ¡tica</option>
	  	<option value="Literatura brasileira">Literatura brasileira</option>
	  	<option value="Literatura infantil">Literatura infantil</option>
	  	<option value="Literatura universal">Literatura universal</option>
	  	<option value="Música e arte">MÃºsica e arte</option>
	</select>
	<input type="button" value="Mesclar" onclick="sub()" > mesclar </form> <br>
	
	<form name="formMesc2" action="mostrar">
		<table>
				<tr>
					<td><input type="number" name="idc" placeholder = "Código do livro"> </td>
				</tr>
		<input type="button" value="Buscar" onclick="sub2()" > </form>
	
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
			<%for (int i=0; i < lista.size(); i++) {%>
				<tr>
					<td><%=lista.get(i).getIdc() %></td>
					<td><%=lista.get(i).getTitulo() %></td>
					<td><%=lista.get(i).getAutor() %></td>
					<td><%=lista.get(i).getCategoria() %></td>
					<td><%=lista.get(i).getValor() %></td>
					<td><a href="select?id=<%=lista.get(i).getIdc() %>" >Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getIdc() %>)" >Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>



	<script src="Scripts/validador.js"></script>
	<script src="Scripts/confirmador.js"></script>
	<a href="index.html">|=Home=|</a>
	<a href="cadastrar.html">|=Cadastrar livros=|</a>
</body>
</html>
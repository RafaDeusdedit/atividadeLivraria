<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
</head>
<body>

	<h1>Editar livro</h1>
	<form name = "formLivro" action="update">
	
		<table>
			
			<tr>
				<td><input type="number" name="idc"  readonly
				value="<%out.print(request.getAttribute("idc"));%>"> </td>
			</tr>
			
			<tr>
				<td><input type="text" name="nome" value="<%out.print(request.getAttribute("titulo"));%>"> </td>
			</tr>
			
			<tr>
				<td><input type="text" name="autor" value="<%out.print(request.getAttribute("autor"));%>"> </td>
			</tr>
			
			<tr>
				<td><select name="categoria">
	  	<option value="Arquitetura">Arquitetura</option>
	  	<option value="Desgin" >Desgin</option>
	  	<option value="Informática">Informática</option>
	  	<option value="Literatura brasileira">Literatura brasileira</option>
	  	<option value="Literatura infantil">Literatura infantil</option>
	  	<option value="Literatura universal">Literatura universal</option>
	  	<option value="Música e arte">Música e arte</option>
	</select> </td>
			</tr>
			
			<tr>
				<td><input type="number" name="valor" value="<%out.print(request.getAttribute("valor"));%>"> </td>
			</tr>
		</table>
		<input type="button" value="salvar"  onclick="validar()">
	
	</form>
	<script src="Scripts/validador.js"></script>
	
	<a href="index.html">|=Home=|</a>
	<a href="main">|=Lista livro=|</a>
</body>
</html>
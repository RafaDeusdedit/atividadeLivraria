<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Livro</title>
</head>
<body>
<form name="formMesc" action="mostrar">
	<table>
			
			<tr>
				<td><input type="number" name="idc" 
				value="<%out.print(request.getAttribute("idc"));%>" readonly>codigo </td>
			</tr>
			
			<tr>
				<td><input type="text" name="nome"  value="<%out.print(request.getAttribute("titulo"));%>" readonly>titulo </td>
			</tr>
			
			<tr>
				<td><input type="text" name="autor"  value="<%out.print(request.getAttribute("autor"));%>" readonly>autor </td>
			</tr>
			
			<tr>
				<td><input type="text" name="autor"  value="<%out.print(request.getAttribute("categoria"));%>" readonly>categoria</td>
			</tr>
			
			<tr>
				<td><input type="number" name="valor"  value="<%out.print(request.getAttribute("valor"));%>" readonly>valor </td>
			</tr>
		</table>
	 </form>
	 
	 <a href="main">|Lista de Livros|</a>
	<a href="cadastrar.html">|=Cadastrar livros=|</a>
</body>
</html>
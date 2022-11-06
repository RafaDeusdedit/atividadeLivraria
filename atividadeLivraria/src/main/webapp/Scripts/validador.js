/**
 * Validação do formulario
 *@author Rafael Deusdedit
 */
 
 function validar (){
	let titulo = formLivro.titulo.value
	let autor = formLivro.autor.value
	let categoria = formLivro.categoria.value
	let valor = formLivro.valor.value
	if (titulo === ""){
		alert('Preencha o campo Nome')
		formLivro.titulo.focus()
		return false
	}else if (autor === ""){
			alert('Preencha o campo Autor')
			formLivro.autor.focus()
			return false
	}else if (valor === ""){
			alert('Preencha um valor númerico')
			formLivro.valor.focus()
			return false
	}else 
			document.forms["formLivro"].submit()
		}
		
 function sub(){
	document.forms["formMesc"].submit()
}

 function sub2(){
	document.forms["formMesc2"].submit()
}

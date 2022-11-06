/**
 * Confirmação de excluir 
 * @author Rafael Deusdedit
 */
 
 function confirmar(idc){
	let resposta = confirm("Deseja mesmo excluir?")
	if (resposta === true){
		alert(idc)
		window.location.href = "delete?idc=" + idc
	}
}
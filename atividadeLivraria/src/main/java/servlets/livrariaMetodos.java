package servlets;

public class livrariaMetodos {
	private long idc;
	private String titulo;
	private String autor;
	private String categoria;

	private float valor;
	
	public livrariaMetodos() {
		super();
	}
	
	public livrariaMetodos(long idc, String titulo, String autor, String categoria, float valor) {
		super();
		this.idc = idc;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.valor = valor;
	}

	public long getIdc() {
		return idc;
	}
	public void setIdc(long idc) {
		this.idc = idc;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	
}

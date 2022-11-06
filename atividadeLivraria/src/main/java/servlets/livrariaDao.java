package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class livrariaDao {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = 
	"jdbc:mysql://localhost:3306/bdlivraria?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "142536Ra.";
	
	
private Connection conectar(){
	Connection con = null;
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		return con;
	}catch (Exception e) {
		System.out.println(e);
		return null;
	}
}
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// Crud Create
	public void insertLivro(livrariaMetodos livros) {
		String create = "insert into tblivros (codlivro,titulo,autor,categoria,valor) values (?,?,?,?,?)";
	try{
		// abrir a conexão
		Connection con = conectar();
		// Preparar a query para executar no banco de dados
		PreparedStatement pst = con.prepareStatement(create);
		// Substituir os parâmetros (?) pelo conteudo das variaveis JavaBeans
		pst.setLong(1, livros.getIdc());
		pst.setString(2, livros.getTitulo());
		pst.setString(3, livros.getAutor());
		pst.setString(4, livros.getCategoria());
		pst.setFloat(5, livros.getValor());
		// Executar a query
		pst.executeUpdate();
		//encerrar a conexão com o banco de dados
		con.close();
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	
	// Crud Read
	public ArrayList<livrariaMetodos> listarLivros(){
		//Criando objeto para acessar a classe livraria
		ArrayList<livrariaMetodos> livraria = new ArrayList();
		String read = "Select * from tblivros order by codlivro";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			//o laço abaixo será executado enquanto houver livros
			while (rs.next()) {
				//variáveis de apoio que recebe dados do banco
				long idc = rs.getLong(1);
				String titulo = rs.getString(2);
				String autor = rs.getString(3);
				String categoria = rs.getString(4);
				Float valor = rs.getFloat(5);
				//populando o ArrayList
				livraria.add(new livrariaMetodos(idc,titulo,autor,categoria,valor));	
			}
			con.close();
			return livraria;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/** Crud update **/
	//selecionar livro
	public void selecionarLivro(livrariaMetodos livraria) {
		String read2 = "select * from tblivros where codlivro = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setLong(1, livraria.getIdc());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				livraria.setIdc(rs.getLong(1));
				livraria.setTitulo(rs.getString(2));
				livraria.setAutor(rs.getString(3));
				livraria.setCategoria(rs.getString(4));
				livraria.setValor(rs.getFloat(5));
			}con.close();
			} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alterarLivro(livrariaMetodos livraria) {
		String create = "update tblivros set titulo=?,autor=?,categoria=?,valor=? where codlivro=?";
		try {
			Connection con = conectar();
			PreparedStatement pst= con.prepareStatement(create);
			pst.setString(1, livraria.getTitulo());
			pst.setString(2, livraria.getAutor());
			pst.setString(3, livraria.getCategoria());
			pst.setFloat(4, livraria.getValor());
			pst.setLong(5, livraria.getIdc());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	/** Crud Delete **/
	
	public void deletarLivro (livrariaMetodos livraria) {
		String delete = "delete from tblivros where codlivro =?";
		try {
			Connection con = conectar();
			PreparedStatement pst= con.prepareStatement(delete);
			pst.setLong(1, livraria.getIdc());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public ArrayList<livrariaMetodos> mesclarLivros(livrariaMetodos livraria){
		//Criando objeto para acessar a classe livraria
		
		ArrayList<livrariaMetodos> livraria1 = new ArrayList();
		String mesclar = "select * from tblivros where categoria = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(mesclar);
			pst.setString(1, livraria.getCategoria());
			ResultSet rs1 = pst.executeQuery();
			//o laço abaixo será executado enquanto houver livros
			while (rs1.next()) {
				//variáveis de apoio que recebe dados do banco
				long idc = rs1.getLong(1);
				String titulo = rs1.getString(2);
				String autor = rs1.getString(3);
				String categoria = rs1.getString(4);
				Float valor = rs1.getFloat(5);
				//populando o ArrayList
				livraria1.add(new livrariaMetodos(idc,titulo,autor,categoria,valor));	
			}
			con.close();
			return livraria1;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void mostrarLivro(livrariaMetodos livraria) {
		String read2 = "select * from tblivros where codlivro = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setLong(1, livraria.getIdc());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				livraria.setIdc(rs.getLong(1));
				livraria.setTitulo(rs.getString(2));
				livraria.setAutor(rs.getString(3));
				livraria.setCategoria(rs.getString(4));
				livraria.setValor(rs.getFloat(5));
				
			}con.close();
			} catch (Exception e) {
			System.out.println(e);
		}
	}
}
	
	

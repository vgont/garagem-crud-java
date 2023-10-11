package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection abrirConexao() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/garagem";
		con = DriverManager.getConnection(url, "root", "");
		System.out.println("Conexao aberta");
		return con;
	}
	
	public static void fecharConexao(Connection con) throws SQLException  {
		con.close();
		System.out.println("Conexao fechada");
	}
	
}

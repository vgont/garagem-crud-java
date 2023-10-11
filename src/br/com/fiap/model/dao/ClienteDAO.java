package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.bean.Cliente;

public class ClienteDAO implements IDAO{
	private Connection con;
	private Cliente cliente;
	
	public ClienteDAO(Connection con) {
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}
	
	public String inserir(Object obj) throws SQLException {
		cliente = (Cliente) obj;
		String sql = "insert into tb_ddd_cliente(id, nome, placa) "
				+ "values(?,?,?)";
		PreparedStatement ps = getCon().prepareStatement(sql);
		
		ps.setInt(1, cliente.getIdCliente());
		ps.setString(2, cliente.getNomeCliente());
		ps.setString(3, cliente.getPlaca());
		
		if (ps.executeUpdate()>0) {
			return "Cliente inserido com sucesso";
		}
		return  "Erro ao inserir cliente";
	}
	
	public String alterar(Object obj) throws SQLException{
		cliente = (Cliente) obj;
		String sql = "update tb_ddd_cliente set nome=?, set placa=?"
				+ "where idCliente=?";
		
		PreparedStatement ps = getCon().prepareStatement(sql);
		
		ps.setString(1, cliente.getNomeCliente());
		ps.setString(2, cliente.getPlaca());
		ps.setInt(3, cliente.getIdCliente());
		
		if(ps.executeUpdate()>0) {
			return "CLiente alterado com sucesso";
		}
		
		return "Erro ao alterar cliente";
	}
	
	public String excluir (Object obj) throws SQLException {
		cliente = (Cliente) obj;
		String sql = "delete from tb_ddd_cliente where id=?";
		PreparedStatement ps = getCon().prepareStatement(sql);
		
		ps.setInt(1, cliente.getIdCliente());
		
		if (ps.executeUpdate()>0) {
			return "Cliente excluido com sucesso";
		}
		
		return "Erro ao excluir cliente";
	}
	
	public ArrayList<String> listaUm(String idCliente) throws SQLException{
		String sql = "select * from tb_ddd_cliente where id=?";
		ArrayList<String> resul = new ArrayList<String>();
		
		PreparedStatement ps = getCon().prepareStatement(sql);
		
		ps.setString(1, idCliente);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			resul.add(rs.getString(1));
			resul.add(rs.getString(2));
			resul.add(rs.getString(3));
			
			return resul;
		}
		
		return null;
	}
}

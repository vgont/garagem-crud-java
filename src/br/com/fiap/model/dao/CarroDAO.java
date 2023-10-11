package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.bean.Carro;

public class CarroDAO implements IDAO{
	private Connection con;
	private Carro carro;
	
	public CarroDAO(Connection con) {
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}
	
	public String inserir(Object obj) throws SQLException{
		carro = (Carro) obj;
		
		String sql = "insert into tb_ddd_carro (placa, cor, descricao)";
		sql+= "values(?,?,?)";
		
		PreparedStatement ps = getCon().prepareStatement(sql);
		
		ps.setString(1, carro.getPlaca());
		ps.setString(2, carro.getCor());
		ps.setString(3, carro.getDescricao());
		
		if (ps.executeUpdate() > 0) {
			return "Inserido com sucesso";
		} else {
			return "Erro ao inserir";
		}
	}
	
	public String alterar(Object obj) throws SQLException{
		carro = (Carro) obj;
		
		String sql = "update tb_ddd_carro set cor=?, descricao=? where placa=?";
		
		PreparedStatement ps = getCon().prepareStatement(sql);
		ps.setString(1, carro.getCor());
		ps.setString(2, carro.getDescricao());
		ps.setString(3, carro.getPlaca());
		
		if (ps.executeUpdate() > 0) {
			return "Alterado com sucesso";
		} else {
			return "Erro ao alterar";
		}
	}
	
	public String excluir(Object obj) throws SQLException{
		carro = (Carro) obj;
		
		String sql = "delete from tb_ddd_carro where placa=?";
		
		PreparedStatement ps = getCon().prepareStatement(sql);
		ps.setString(1, carro.getPlaca());
		
		if (ps.executeUpdate() > 0) {
			return "Excluido com sucesso";
		} else {
			return "Erro ao excluir";
		}		
	}
	
	public ArrayList<String> listaUm(String placa) throws SQLException{
		String sql = "select * from tb_ddd_carro where placa=?";
		
		ArrayList<String> resul = new ArrayList<String>();
		
		PreparedStatement ps = getCon().prepareStatement(sql);
		ps.setString(1, placa);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			resul.add(rs.getString(1)); //placa
			resul.add(rs.getString(2)); //cor
			resul.add(rs.getString(3)); //descricao
			return resul;
		} else {
			return null;
		}
	}
	
}

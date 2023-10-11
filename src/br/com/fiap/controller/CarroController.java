package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.model.bean.Carro;
import br.com.fiap.model.dao.CarroDAO;
import br.com.fiap.model.dao.Conexao;

public class CarroController {
	
	public String insereCarro(String placa, String cor, String descricao) throws ClassNotFoundException, SQLException {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO carroDAO = new CarroDAO(con);
		Carro carro = new Carro();
		
		carro.setPlaca(placa);
		carro.setCor(cor);
		carro.setDescricao(descricao);
		
		resultado = carroDAO.inserir(carro);
		
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String alteraCarro(String placa, String cor, String descricao) throws ClassNotFoundException, SQLException {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO carroDAO = new CarroDAO(con);
		Carro carro = new Carro();
		
		carro.setPlaca(placa);
		carro.setCor(cor);
		carro.setDescricao(descricao);
		
		resultado = carroDAO.alterar(carro);
		
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String excluiCarro(String placa) throws ClassNotFoundException, SQLException {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO carroDAO = new CarroDAO(con);
		Carro carro = new Carro();
		
		carro.setPlaca(placa);
		
		resultado = carroDAO.excluir(carro);
		
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public ArrayList<String> listaUmCarro(String placa) throws ClassNotFoundException, SQLException  {
		ArrayList<String> resultado = new ArrayList<String>();
		Connection con = Conexao.abrirConexao();
		CarroDAO carroDAO = new CarroDAO(con);
		
		resultado = carroDAO.listaUm(placa);
		
		Conexao.fecharConexao(con);
		
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
	}
	
}

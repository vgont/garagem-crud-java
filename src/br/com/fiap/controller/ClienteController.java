package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.bean.Cliente;
import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.dao.Conexao;

public class ClienteController {

	public String insereCliente(String nome, String placa) throws ClassNotFoundException, SQLException {
		String resul;
		Connection con = Conexao.abrirConexao();
		
		ClienteDAO clienteDao = new ClienteDAO(con);
		Cliente cliente = new Cliente();
		
		cliente.setNomeCliente(nome);
		cliente.setPlaca(placa);
		
		resul= clienteDao.inserir(cliente);
		
		Conexao.fecharConexao(con);
		
		return resul;
	}
	
	public String alteraCLiente(int id, String nome, String placa) throws ClassNotFoundException, SQLException {
		String resul;
		
		Connection con = Conexao.abrirConexao();
		
		ClienteDAO clienteDao = new ClienteDAO(con);
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(id);
		cliente.setNomeCliente(nome);
		cliente.setPlaca(placa);
		
		resul = clienteDao.alterar(cliente);
		
		Conexao.fecharConexao(con);
		
		return resul;
	}
	
	public String excluiCliente (int id) throws ClassNotFoundException, SQLException {
		String resul;
		Connection con = Conexao.abrirConexao();
		
		ClienteDAO clienteDao = new ClienteDAO(con);
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(id);
		
		resul = clienteDao.excluir(cliente);
		
		Conexao.fecharConexao(con);
		
		return resul;
	}
	
	public ArrayList<String> listaUmCliente(String id) throws ClassNotFoundException, SQLException{
		ArrayList<String> resul = new ArrayList<String>();
		Connection con = Conexao.abrirConexao();
		
		ClienteDAO clienteDao = new ClienteDAO(con);
		
		resul = clienteDao.listaUm(id);
		
		Conexao.fecharConexao(con);
		
		return resul;
	}
}

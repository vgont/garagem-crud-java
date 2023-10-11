package br.com.fiap.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAO {
	public String inserir(Object obj) throws SQLException;
	public String alterar(Object obj) throws SQLException;
	public String excluir(Object obj) throws SQLException;
	public ArrayList<String> listaUm(String chavePrimaria) throws SQLException;	
}

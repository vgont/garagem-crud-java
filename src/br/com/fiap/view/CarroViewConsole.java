package br.com.fiap.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fiap.controller.CarroController;

public class CarroViewConsole {

	public static void main(String[] args) {
		String aux, escolha = "sim", placa, cor, descricao;
		int key;
		CarroController carro = new CarroController();
		
		
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Escolha\n"
						+ "[1]-Inserir\n"
						+ "[2]-Alterar\n"
						+ "[3]-Exclui \n"
						+ "[4]-Lista");
				key = Integer.parseInt(aux);			
				placa = JOptionPane.showInputDialog("Insira a placa do carro");
				switch (key) {
				case 1:
					cor = JOptionPane.showInputDialog("Digite a cor do carro");
					descricao = JOptionPane.showInputDialog("Digite a descricao do carro");					
					System.out.println(carro.insereCarro(placa, cor, descricao));
					break;
				case 2:
					cor = JOptionPane.showInputDialog("Digite a nova cor do carro");
					descricao = JOptionPane.showInputDialog("Digite a nova descricao do carro");
					System.out.println(carro.alteraCarro(placa, cor, descricao));
				case 3:
					System.out.println(carro.excluiCarro(placa));
					break;
				case 4:
					ArrayList<String> consulta = carro.listaUmCarro(placa);
					if (consulta != null) {
						JOptionPane.showMessageDialog(null, 
								"Dados do carro:\n"
								+ "Placa" + consulta.get(0) + "\n"
								+ "Cor" + consulta.get(1) + "\n"
								+ "Descricao" + consulta.get(2) + "\n");
					} else {
						JOptionPane.showMessageDialog(null, "Carro inexistente");
					}
					break;
				default:
					JOptionPane.showInputDialog("Escolha incorreta ");
				}
				escolha = JOptionPane.showInputDialog("Deseja refazer a operacao?");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}
		JOptionPane.showMessageDialog(null, "Fim de programa");
	}

}


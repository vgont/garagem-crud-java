package br.com.fiap.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fiap.controller.ClienteController;

public class ClienteViewConsole {

	public static void main(String[] args) {
		String aux, escolha = "sim", nomeCliente, placaCarro;
		int key, idCliente=0;
		ClienteController cliente = new ClienteController();
		
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog(
						"Opcoes:\n"
						+ "[1]-Inserir Cliente\n"
						+ "[2]-Alterar Cliente\n"
						+ "[3]-Excluir Cliente\n"
						+ "[4]-Listar Cliente\n"
						+ "[5]-Sair\n");
				
				key = Integer.parseInt(aux);
				
				if (key==2||key==3||key==4) {
					aux = JOptionPane.showInputDialog("Digite o id do cliente");
					idCliente = Integer.parseInt(aux);
				}
				
				switch (key) {
				case 1:
					nomeCliente = JOptionPane.showInputDialog("Digite seu nome");
					placaCarro  = JOptionPane.showInputDialog("Digite a placa do seu carro");
					System.out.println(cliente.insereCliente(nomeCliente, placaCarro));
					break;
					
				case 2:
					aux = JOptionPane.showInputDialog("Digite o id do cliente");
					idCliente = Integer.parseInt(aux);
					nomeCliente = JOptionPane.showInputDialog("Digite o novo nome");
					placaCarro  = JOptionPane.showInputDialog("Digite a nova placa do seu carro");
					System.out.println(cliente.alteraCLiente(idCliente, nomeCliente, placaCarro));
					break;
					
				case 3:
					System.out.println(cliente.excluiCliente(idCliente));
					break;
					
				case 4:
					ArrayList<String> consulta = cliente.listaUmCliente(String.valueOf(idCliente));					
					if (consulta==null) {
						JOptionPane.showInternalMessageDialog(null, "Cliente inexistente");
						break;
					}
					JOptionPane.showMessageDialog(null, 
							"Dados do cliente:\n"
							+"ID do cliente: " + consulta.get(0) + "\n"
							+"Nome do cliente: " + consulta.get(1) + "\n"
							+"Placa do carro do cliente: " + consulta.get(2));
					break;
					
				case 5:
					return;
					
				default:
					JOptionPane.showMessageDialog(null, "Opcao invalida");
				}
				escolha = JOptionPane.showInputDialog("Deseja refazer a operacao?");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, "Fim do programa");
	}
}

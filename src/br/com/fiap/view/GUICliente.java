package br.com.fiap.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.fiap.controller.ClienteController;

@SuppressWarnings("serial")
public class GUICliente extends JPanel {

	private JLabel lbId, lbNome, lbPlaca;
	private JTextField tfId, tfNome, tfPlaca;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga, btCancelar;
	
	public GUICliente(){
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.cyan);
		
		lbId = new JLabel("ID: ", JLabel.RIGHT);
		lbNome = new JLabel("Nome: ", JLabel.RIGHT);
		lbPlaca= new JLabel("Placa: ", JLabel.RIGHT);
		tfId = new JTextField();
		tfNome = new JTextField();
		tfPlaca = new JTextField();
		
		
		btPesquisa = new JButton(new ImageIcon(
				getClass().getResource("images/search_icon.png")));
		btNovo = new JButton(new ImageIcon(
				getClass().getResource("images/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(
				getClass().getResource("images/update_icon.png")));
		btApaga = new JButton(new ImageIcon(
				getClass().getResource("images/delete_icon.png")));
		btCancelar = new JButton(new ImageIcon(
				getClass().getResource("images/exit_icon.png")));
		
		lbId.setBounds(10, 30, 80, 25);
		tfId.setBounds(100, 30, 120, 25);
		lbNome.setBounds(10, 75, 80, 25);
		tfNome.setBounds(100, 75, 200, 25);
		lbPlaca.setBounds(10, 120, 80, 25);
		tfPlaca.setBounds(100, 120, 120, 25);
		btPesquisa.setBounds(50, 250, 60, 40);
		btNovo.setBounds(120, 250, 60, 40);
		btAtualiza.setBounds(190, 250, 60, 40);
		btApaga.setBounds(260, 250, 60, 40);
		btCancelar.setBounds(330, 250, 60, 40);
				
		add(lbId);
		add(tfId);
		add(lbNome);
		add(tfNome);
		add(lbPlaca);
		add(tfPlaca);
		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);
		add(btCancelar);
	}

	private void definirEventos() {
		btCancelar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		
		btPesquisa.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteController cliente = new ClienteController();
				ArrayList<String> dados = new ArrayList<>();
				try {
					if (tfId.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Preencha o ID!");
						tfId.requestFocus();
					} else {
						dados = cliente.listaUmCliente(tfId.getText());
						if (dados != null) {
							tfNome.setText(dados.get(1));
							tfPlaca.setText(dados.get(2));
						} else {
							JOptionPane.showMessageDialog(null, "Registro Inexistente");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}			
			}
		});
		
		btNovo.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteController cliente = new ClienteController();
				try {
					if (tfId.getText().isBlank() || tfNome.getText().isBlank() || tfPlaca.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					} else {
						JOptionPane.showMessageDialog(null, cliente.insereCliente(tfNome.getText(), tfPlaca.getText()));
						tfId.setText("");
						tfNome.setText("");
						tfPlaca.setText("");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		btApaga.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteController cliente = new ClienteController();
				try {
					if (tfId.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Preencha o ID");
					} else {
						JOptionPane.showMessageDialog(null, cliente.excluiCliente(Integer.parseInt(tfId.getText())));
						tfId.setText("");
						tfNome.setText("");
						tfPlaca.setText("");
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
	}


}

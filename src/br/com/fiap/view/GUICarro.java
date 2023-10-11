package br.com.fiap.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.fiap.controller.CarroController;

@SuppressWarnings("serial")
public class GUICarro extends JPanel {

	private JLabel lbPlaca, lbCor, lbDescricao, lbImagem;
	private JTextField tfPlaca, tfDescricao;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga, btCancelar;
	private JList<String> liCor;
	private ImageIcon imagem1;
	private JScrollPane sp;
	
	public GUICarro() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.orange);
		
		lbPlaca = new JLabel("Placa: ", JLabel.RIGHT);
		lbCor = new JLabel("Cor:", JLabel.RIGHT);
		lbDescricao = new JLabel("Descrição: ", JLabel.RIGHT);
		tfPlaca = new JTextField();
		tfDescricao = new JTextField();
		
		String[] cores = {"amarelo", "azul", "branco", "vermelho"};
		
		liCor = new JList<String>(cores);
		sp = new JScrollPane(liCor);
		
		imagem1 = new ImageIcon();
		lbImagem = new JLabel(imagem1);
		
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
		
		lbPlaca.setBounds(10, 30, 80, 25);
		tfPlaca.setBounds(100, 30, 120, 25);
		lbCor.setBounds(310, 30, 80, 25);
		sp.setBounds(310, 65, 80, 80);
		lbImagem.setBounds(400, 30, 128, 128);
		lbDescricao.setBounds(10, 120, 80, 25);
		tfDescricao.setBounds(100, 120, 200, 25);
		btPesquisa.setBounds(50, 250, 60, 40);
		btNovo.setBounds(120, 250, 60, 40);
		btAtualiza.setBounds(190, 250, 60, 40);
		btApaga.setBounds(260, 250, 60, 40);
		btCancelar.setBounds(330, 250, 60, 40);
		
		add(lbPlaca);
		add(tfPlaca);
		add(lbCor);
		add(sp);
		add(lbImagem);
		add(lbDescricao);
		add(tfDescricao);
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
		
		liCor.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!liCor.isSelectionEmpty()) {
					imagem1 = new ImageIcon(getClass().getResource(
							"colors/" + liCor.getSelectedValue() + ".png"));
					lbImagem.setIcon(imagem1);
				}
			}
		});
		
		btPesquisa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CarroController carro = new CarroController();
				ArrayList<String> dados = new ArrayList<>();
				try {
					if (tfPlaca.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Preencha a placa!!");
						tfPlaca.requestFocus();
					} else {
						dados = carro.listaUmCarro(tfPlaca.getText());
						if (dados != null) {
							tfDescricao.setText(dados.get(2));
							String cor = dados.get(1);
							
							String[] cores = {"amarelo", "azul", "branco", "vermelho"};
							
							for (int i = 0; i < cores.length; i++) {
								if (cor.equals(cores[i]))
									liCor.setSelectedIndex(i);
							}
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
				CarroController carro = new CarroController();
				try {
					if (tfPlaca.getText().isBlank() || tfDescricao.getText().isBlank() || liCor.isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					} else {
						String cor = liCor.getSelectedValue();
						JOptionPane.showMessageDialog(null, carro.insereCarro(tfPlaca.getText(), cor, tfDescricao.getText()));
						tfPlaca.setText("");
						tfDescricao.setText("");
						lbImagem.setIcon(null);
						liCor.clearSelection();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
			}
		});
		
		btApaga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CarroController carro = new CarroController();
				try {
					if (tfPlaca.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Preencha a placa");
					} else {
						JOptionPane.showMessageDialog(null, carro.excluiCarro(tfPlaca.getText()));
						tfPlaca.setText("");
						tfDescricao.setText("");
						lbImagem.setIcon(null);
						liCor.clearSelection();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
			}
		});
		
	}
	
}

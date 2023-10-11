package br.com.fiap.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {
	
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnCadastro;
	private JMenuItem miSair, miCarro, miCliente;
	
	public GUIPrincipal() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setTitle("Janela Principal");
		setBounds(0, 0, 600, 400);
		contentPane = getContentPane();
		
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnCadastro = new JMenu("Cadastro");
		mnCadastro.setMnemonic('C');
		miSair = new JMenuItem("Sair", new ImageIcon(
				getClass().getResource("images/exit_icon.png")));
		miCarro = new JMenuItem("Carro");
		miCliente = new JMenuItem("Cliente");
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnCadastro);
		mnArquivo.add(miSair);
		mnCadastro.add(miCarro);
		mnCadastro.add(miCliente);
	}

	private void definirEventos() {
		miSair.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		miCarro.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUICarro carro = new GUICarro();
				contentPane.removeAll();
				contentPane.add(carro);
				contentPane.validate();
			}
		});	
		
		miCliente.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUICliente cliente = new GUICliente();
				contentPane.removeAll();
				contentPane.add(cliente);
				contentPane.validate();				
			}
		});
	}

	public static void main(String[] args) {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, 
				(tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}

}











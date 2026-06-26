package Roteiro1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.FlowLayout;

public class CalculadoraInvestimentoGrid extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDeposito_mensal;
	private JTextField txtNum_pagamentos;
	private JTextField txtJuros;
	
	
	public class Investimento
	{
	 private int meses;
	 private double txtJuros;
	 private double txtDeposito_mensal;
	 public Investimento(int a, double j, double dm) {
	 meses = a;
	 txtJuros = j/100;
	 txtDeposito_mensal = dm;
	 }
	 public double calculaTotal() {
	 int num_pagamentos = meses;
	 double total = 0;
	 for (int i = 0; i < num_pagamentos; i++) {
	 total = total + txtDeposito_mensal;
	 total = total + total * txtJuros;
	 }
	 return total;
	 }
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraInvestimentoGrid frame = new CalculadoraInvestimentoGrid();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraInvestimentoGrid() {
		setTitle("CalcInvest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sobre");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormSobre sobre = new FormSobre();
				sobre.setLocationRelativeTo(null); // centraliza na tela
				sobre.setVisible(true);
			}
		});
		mnAjuda.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 10, 10));
		
		JLabel lblNewLabel_1 = new JLabel("Depósito mesal R$:");
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtDeposito_mensal = new JTextField();
		panel.add(txtDeposito_mensal);
		txtDeposito_mensal.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Num. de meses: ");
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtNum_pagamentos = new JTextField();
		panel_1.add(txtNum_pagamentos);
		txtNum_pagamentos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Juros ao mês %:");
		contentPane.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtJuros = new JTextField();
		panel_2.add(txtJuros);
		txtJuros.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total investido + juros investidos R$: ");
		contentPane.add(lblNewLabel);
		
		JLabel lblTotalJuros = new JLabel("");
		contentPane.add(lblTotalJuros);
		
		JLabel lblNewLabel_5 = new JLabel("");
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pag = Integer.parseInt(txtNum_pagamentos.getText());
				double juro = Double.parseDouble(txtJuros.getText());
				double dep = Double.parseDouble(txtDeposito_mensal.getText());
				
				Investimento invest = new Investimento(pag, juro, dep);
				//String total = Investimento.calcularTotal() + " ";
				lblTotalJuros.setText(String.format("%.2f", invest.calculaTotal()) );
			}
		});
		contentPane.add(btnNewButton);

	}

}

package Roteiro1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CalculadoraInvestimentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDepMensal;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraInvestimentos frame = new CalculadoraInvestimentos();
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
	public CalculadoraInvestimentos() {
		setForeground(new Color(0, 0, 255));
		setBackground(new Color(128, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Depósito mensal R$:");
		lblNewLabel.setBounds(69, 11, 166, 25);
		contentPane.add(lblNewLabel);
		
		textDepMensal = new JTextField();
		textDepMensal.setBounds(27, 36, 179, 20);
		contentPane.add(textDepMensal);
		textDepMensal.setColumns(10);
		
		JLabel lblNumDeMeses = new JLabel("Num. de meses:");
		lblNumDeMeses.setBounds(79, 56, 105, 25);
		contentPane.add(lblNumDeMeses);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(27, 77, 179, 20);
		contentPane.add(textField_1);
		
		JLabel lblJuros = new JLabel("Juros ao mês:");
		lblJuros.setBounds(79, 103, 84, 20);
		contentPane.add(lblJuros);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(27, 128, 179, 20);
		contentPane.add(textField_2);
		
		JLabel lblTotalInvestido = new JLabel("Total investido + juros R$:");
		lblTotalInvestido.setBounds(55, 154, 146, 25);
		contentPane.add(lblTotalInvestido);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(69, 177, 89, 23);
		contentPane.add(btnNewButton);

	}
}

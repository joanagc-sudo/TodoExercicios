import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTempF;
	private JLabel lblResultado;
	private JLabel lblCompleto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio1 frame = new Exercicio1();
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
	public Exercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTempF = new JLabel("Temperatura em Farenheit");
		lblTempF.setBounds(10, 28, 133, 14);
		contentPane.add(lblTempF);
		
		txtTempF = new JTextField();
		txtTempF.setBounds(153, 26, 189, 20);
		contentPane.add(txtTempF);
		txtTempF.setColumns(10);
		
		JButton btnNewButton = new JButton("Converter para ºC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tempF = Double.parseDouble(txtTempF.getText());
				String conversao = String.format("%.2f", (tempF - 32 ) * 5/9) + "°C";
				lblCompleto.setText(conversao);
				
				
			}
		});
		btnNewButton.setBounds(163, 57, 165, 23);
		contentPane.add(btnNewButton);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(173, 93, 286, 14);
		contentPane.add(lblResultado);
		
		lblCompleto = new JLabel("");
		lblCompleto.setBounds(173, 90, 334, 56);
		contentPane.add(lblCompleto);

	}
}

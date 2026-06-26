import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seja bem vindo!");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(0, 51, 0));
		lblNewLabel.setBounds(146, 0, 172, 82);
		contentPane.add(lblNewLabel);
		
		JButton btnBotao = new JButton("Fechar");
		btnBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBotao.setBounds(236, 179, 89, 23);
		contentPane.add(btnBotao);
		
		JFormattedTextField txtNome = new JFormattedTextField();
		txtNome.setBackground(new Color(255, 255, 255));
		txtNome.setBounds(170, 73, 128, 20);
		contentPane.add(txtNome);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(124, 76, 46, 14);
		contentPane.add(lblNome);
		
		JFormattedTextField txtCpf = new JFormattedTextField();
		txtCpf.setBounds(170, 99, 128, 20);
		contentPane.add(txtCpf);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(124, 102, 46, 14);
		contentPane.add(lblCpf);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(170, 130, 128, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(124, 133, 46, 14);
		contentPane.add(lblEmail);
		
		JButton btnmostrar = new JButton("Mostrar");
		btnmostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String nome = txtNome.getText();
				JOptionPane.showMessageDialog(null,  "Olá " + nome);
			}
		});
		btnmostrar.setBounds(124, 179, 89, 23);
		contentPane.add(btnmostrar);

	}
}

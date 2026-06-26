package Jcombobox;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exemplo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exemplo frame = new Exemplo();
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
	public Exemplo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("Meses");
		contentPane.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		JComboBox cbMeses = new JComboBox();
		cbMeses.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Dezembro"}));
		cbMeses.setToolTipText("");
		contentPane.add(cbMeses, "cell 1 0,growx");
		
		JComboBox <TipoCombustivel> cbCombustivel = new JComboBox<TipoCombustivel>();
		cbCombustivel.addItem(TipoCombustivel.DIESEL);
		cbCombustivel.addItem(TipoCombustivel.ELETRICO);
		cbCombustivel.addItem(TipoCombustivel.ETANOL);
		cbCombustivel.addItem(TipoCombustivel.GASOLINA);
		cbCombustivel.addItem(TipoCombustivel.HIBRIDO);
		
		JLabel lblNewLabel_1 = new JLabel("Combustivel");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		contentPane.add(cbCombustivel, "cell 1 1,growx");
		
		JButton btnNewButton = new JButton("Mostrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mesSelecionado = (String) cbMeses.getSelectedItem();
				
				TipoCombustivel tipo = (TipoCombustivel) cbCombustivel.getSelectedItem();
				
				JOptionPane.showMessageDialog(null, "Mês selecionado: " + mesSelecionado + " Tipo de combustivel: "+tipo);
			}
		});
		contentPane.add(btnNewButton, "cell 1 3");

	}

}

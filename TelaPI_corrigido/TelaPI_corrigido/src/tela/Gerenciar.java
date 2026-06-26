package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.PessoaTableModel;

public class Gerenciar extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textField;
    private JTextField txtNome;
    private JTable table;
    private JButton btnAdicionar;
    private JButton btnRemover;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Gerenciar frame = new Gerenciar(new PessoaTableModel());
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // construtor recebe o modelo compartilhado com Login
    public Gerenciar(PessoaTableModel pessoaTableModel) {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);

        // 50% esquerda | 50% direita
        contentPane.setLayout(new MigLayout("insets 0, gap 0", "[40%,grow,fill][60%,fill]", "[grow,fill]"));
        // Painel da imagem
        JPanel painelImagem = new JPanel() {
        };

        painelImagem.setBackground(new Color(255, 255, 255));

        // Painel do formulário
        JPanel painelFormulario = new JPanel();
        painelFormulario.setBackground(new Color(221, 249, 255));

        contentPane.add(painelImagem, "push,alignx left,growy");
        painelImagem.setLayout(new MigLayout("", "[34.00][][grow][][]", "[51.00,grow][][158.00][96.00,grow,top]"));
        
        JLabel lblNewLabel = new JLabel("<html> Gerencie os estudantes <br> cadastrados no Nextage. </html>");
        lblNewLabel.setForeground(new Color(12, 104, 120));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
        painelImagem.add(lblNewLabel, "cell 2 1");
        
        JLabel lblNewLabel_1 = new JLabel("<html>Mantenha os dados sempre atualizados<br> realizando alterações nos cadastros de<br> maneira prática e segura.<html>");
        lblNewLabel_1.setForeground(new Color(110, 134, 139));
        lblNewLabel_1.setBackground(new Color(110, 134, 139));
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
        painelImagem.add(lblNewLabel_1, "cell 2 2");
        contentPane.add(painelFormulario, "grow,push");
        
        JTextField txtEmail = new JTextField();

        txtEmail.setOpaque(false);
        txtEmail.setBackground(new Color(0, 0, 0, 0));
        txtEmail.setForeground(new Color(12, 104, 120));
        txtEmail.setCaretColor(new Color(12, 104, 120));

        txtEmail.setBorder(BorderFactory.createMatteBorder(
                0, 0, 1, 0,
                new Color(180, 180, 180)
        ));
        
        JLabel lblNewLabel_9 = new JLabel(" ");
        painelFormulario.setLayout(new MigLayout("", "[92.00px][grow][grow]", "[54px][][604.00px,grow][][]"));
        
        JLabel lblCriarConta = new JLabel("Cadastro de estudantes");
        lblCriarConta.setForeground(new Color(12, 104, 120));
        lblCriarConta.setFont(new Font("Segoe UI", Font.BOLD, 40));
        painelFormulario.add(lblCriarConta, "cell 1 1,alignx left,aligny top");
        painelFormulario.add(lblNewLabel_9, "cell 0 2,alignx left,aligny top");
        
        // tabela com ScrollPane e modelo compartilhado
        table = new JTable(pessoaTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        painelFormulario.add(scrollPane, "cell 1 2,grow");
        
        btnAdicionar = new JButton("");
        btnAdicionar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnAdicionar.setBackground(new Color(12, 104, 120));
        btnAdicionar.setIcon(new ImageIcon(Gerenciar.class.getResource("/tela/Frame 8 (1)2.png")));
        painelFormulario.add(btnAdicionar, "flowx,cell 1 3");
        
        btnRemover = new JButton("");
        btnRemover.setIcon(new ImageIcon(Gerenciar.class.getResource("/tela/Component 6.png")));
        btnRemover.setBackground(new Color(120, 12, 14));
        painelFormulario.add(btnRemover, "cell 1 3");
        
      
      
    	
    	
    }

    // getters expostos para o controller
    public JTable getTable()         { return table; }
    public JButton getBtnAdicionar() { return btnAdicionar; }
    public JButton getBtnRemover()   { return btnRemover; }
}

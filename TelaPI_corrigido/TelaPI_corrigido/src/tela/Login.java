package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
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

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textConfirmarSenha;
    private JTextField txtNome;
    private JTextField txt_senha;
    private JTextField txtDataNasc;
    private JTextField txt_email;
    private JTextField txtNomeCompleto;
    private JCheckBox cbSim;
    private JCheckBox cbNao;
    private JTable table;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JButton btnVisualizar;
    private JLabel btnVisu;   // ícone olho — exposto para o controller abrir Gerenciar
    private JLabel btnCriar;  // botão criar conta — exposto para o controller cadastrar

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Login() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);

        contentPane.setLayout(new MigLayout(
        	    "insets 0, gap 0",
        	    "[40%,grow,fill][60%,grow,fill]",
        	    "[grow,fill]"
        	));

        JPanel painelImagem = new JPanel() {
            private final Image imagem = new ImageIcon(
                    Login.class.getResource("/tela/login.png"))
                    .getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int larguraPainel = getWidth();
                int alturaPainel = getHeight();
                int larguraImagem = imagem.getWidth(this);
                int alturaImagem = imagem.getHeight(this);
                double escala = Math.min(
                        (double) larguraPainel / larguraImagem,
                        (double) alturaPainel / alturaImagem);
                int novaLargura = (int) (larguraImagem * escala);
                int novaAltura = (int) (alturaImagem * escala);
                int x = (larguraPainel - novaLargura) / 2;
                int y = alturaPainel - novaAltura;
                g.drawImage(imagem, x, y, novaLargura, novaAltura, this);
            }
        };

        painelImagem.setBackground(new Color(221, 249, 255));

        JPanel painelFormulario = new JPanel();
        painelFormulario.setBackground(Color.WHITE);

        contentPane.add(painelImagem, "push,alignx left,growy");
        painelImagem.setLayout(new MigLayout("", "[][50][][grow][][][][][grow]", "[51.00][grow][89.00,grow][96.00,grow,top][97.00,grow,top][87.00,grow,top][grow][grow][grow]"));
        
        JLabel lblNewLabel = new JLabel("<html>" +
        	    "Crie sua conta e dê o<br>" +
        	    "próximo passo na sua<br>" +
        	    "jornada" +
        	    "</html>");
        lblNewLabel.setForeground(new Color(12, 104, 120));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        painelImagem.add(lblNewLabel, "cell 3 1");
        
        JLabel lblNewLabel_1 = new JLabel("<html>No Nextage, você encontra tudo o que precisa<br>\r\n para estudar, organizar seus conteúdos e <br>\r\nevoluir todos os dias<html>");
        lblNewLabel_1.setForeground(new Color(110, 134, 139));
        lblNewLabel_1.setBackground(new Color(110, 134, 139));
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        painelImagem.add(lblNewLabel_1, "cell 3 2");
        
        JLabel lblNewLabel_2 = new JLabel("<html>\r\n<font color='#0C6878'>\t\tAprendizado que te acompanha</font><br>\r\n<font color='#6E868B'>\t\tAcesse materiais, exercícios e recursos</font><br>\r\n<font color='#6E868B'>\t\tsempre que quiser.</font>\r\n</html>");
        lblNewLabel_2.setForeground(new Color(64, 128, 128));
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/tela/image 5 - Copia.png")));
        painelImagem.add(lblNewLabel_2, "cell 3 3,alignx left");
        
        JLabel lblNewLabel_3 = new JLabel("<html>\r\n<font color='#0C6878'>Organize e acompanhe seu progresso</font><br>\r\n<font color='#6E868B'>Tenha clareza da sua evolução e foque</font><br>\r\n<font color='#6E868B'>no que realmente importa.</font>\r\n</html>");
        lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/tela/image 4 (2).png")));
        painelImagem.add(lblNewLabel_3, "cell 3 4");
        
        JLabel lblNewLabel_4 = new JLabel("<html>\r\n<font color='#0C6878'>Organize e acompanhe seu progresso</font><br>\r\n<font color='#6E868B'>Tenha clareza da sua evolução e foque</font><br>\r\n<font color='#6E868B'>no que realmente importa.</font>\r\n</html>");
        lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/tela/image 6.png")));
        painelImagem.add(lblNewLabel_4, "cell 3 5");
        
        JLabel lblNewLabel_9_2 = new JLabel(" ");
        painelImagem.add(lblNewLabel_9_2, "cell 3 6");
        
        JLabel lblNewLabel_9_1 = new JLabel(" ");
        painelImagem.add(lblNewLabel_9_1, "cell 3 7");
        
        JLabel lblNewLabel_10 = new JLabel("");
        painelImagem.add(lblNewLabel_10, "cell 3 8");
        contentPane.add(painelFormulario, "grow,push");
        painelFormulario.setLayout(new MigLayout("", "[grow][506.00,grow][]", "[grow][grow][grow][grow][grow][][grow][60.00,grow,top][][58.00,grow][grow][57.00,grow][grow][57.00,grow][][][58.00,grow][grow][56.00,grow][][grow][][55.00][]"));
        
        btnVisu = new JLabel("    ");
        btnVisu.setIcon(new ImageIcon(Login.class.getResource("/tela/image 14.png")));
        painelFormulario.add(btnVisu, "cell 1 2,alignx right");
        
        JLabel lblCriarConta = new JLabel("Criar conta");
        lblCriarConta.setForeground(new Color(12, 104, 120));
        lblCriarConta.setFont(new Font("Segoe UI", Font.BOLD, 30));
        painelFormulario.add(lblCriarConta, "flowx,cell 1 3");
        
        JLabel lblNewLabel_1_1 = new JLabel("Prencha seus dados para começar a usar o Nextage.");
        lblNewLabel_1_1.setForeground(new Color(110, 134, 139));
        lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNewLabel_1_1.setBackground(new Color(110, 134, 139));
        painelFormulario.add(lblNewLabel_1_1, "cell 1 4");
        
        JLabel lblNomeCompleto = new JLabel("Nome completo");
        lblNomeCompleto.setForeground(new Color(12, 104, 120));
        lblNomeCompleto.setFont(new Font("Segoe UI", Font.BOLD, 17));
        painelFormulario.add(lblNomeCompleto, "cell 1 6");
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        painelFormulario.add(panel, "cell 1 7,grow");
        panel.setLayout(null);
        
        JTextField txtEmail = new JTextField();
        txtEmail.setOpaque(false);
        txtEmail.setBackground(new Color(0, 0, 0, 0));
        txtEmail.setForeground(new Color(12, 104, 120));
        txtEmail.setCaretColor(new Color(12, 104, 120));
        txtEmail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(180, 180, 180)));
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(0, 0, 520, 46);
        panel.add(lblNewLabel_5);
        lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/tela/Component 1 (3).png")));
        
        txtNomeCompleto = new JTextField();
        txtNomeCompleto.setForeground(Color.WHITE);
        txtNomeCompleto.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        txtNomeCompleto.setColumns(10);
        txtNomeCompleto.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        txtNomeCompleto.setBounds(41, 11, 469, 27);
        panel.add(txtNomeCompleto);
        txtNomeCompleto.setForeground(Color.BLACK);
        
        JLabel lblEmail_1 = new JLabel("Data de nascimento");
        lblEmail_1.setForeground(new Color(12, 104, 120));
        lblEmail_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
        painelFormulario.add(lblEmail_1, "cell 1 8");
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(new Color(12, 104, 120));
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 17));
        painelFormulario.add(lblEmail, "cell 1 10");
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        painelFormulario.add(panel_1, "cell 1 11,grow");
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_5_1 = new JLabel("");
        lblNewLabel_5_1.setBounds(0, 0, 520, 45);
        panel_1.add(lblNewLabel_5_1);
        lblNewLabel_5_1.setIcon(new ImageIcon(Login.class.getResource("/tela/Component 2.png")));
        
        txt_email = new JTextField();
        txt_email.setForeground(Color.WHITE);
        txt_email.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        txt_email.setColumns(10);
        txt_email.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        txt_email.setBounds(40, 11, 469, 27);
        panel_1.add(txt_email);
        txt_email.setForeground(Color.BLACK);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        painelFormulario.add(panel_2, "cell 1 9,grow");
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(0, 0, 520, 45);
        panel_2.add(lblNewLabel_6);
        lblNewLabel_6.setIcon(new ImageIcon(Login.class.getResource("/tela/Component 3.png")));
        
        txtDataNasc = new JTextField();
        txtDataNasc.setForeground(Color.WHITE);
        txtDataNasc.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        txtDataNasc.setColumns(10);
        txtDataNasc.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        txtDataNasc.setBounds(39, 11, 469, 28);
        panel_2.add(txtDataNasc);
        txtDataNasc.setForeground(Color.BLACK);
        
        JLabel lblEmail_1_1 = new JLabel("Estudante do ensino médio");
        lblEmail_1_1.setForeground(new Color(12, 104, 120));
        lblEmail_1_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
        painelFormulario.add(lblEmail_1_1, "cell 1 15");

        ButtonGroup grupo = new ButtonGroup();
        
        JLabel lblEmail_1_1_1 = new JLabel("Senha");
        lblEmail_1_1_1.setForeground(new Color(12, 104, 120));
        lblEmail_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
        painelFormulario.add(lblEmail_1_1_1, "cell 1 12,alignx left");
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        painelFormulario.add(panel_4, "cell 1 13,grow");
        panel_4.setLayout(null);
        
        JLabel textEmail = new JLabel("");
        textEmail.setForeground(new Color(0, 0, 0));
        textEmail.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        textEmail.setBounds(0, 0, 585, 45);
        panel_4.add(textEmail);
        textEmail.setBackground(new Color(0, 0, 0));
        textEmail.setIcon(new ImageIcon(Login.class.getResource("/tela/Component 4.png")));
        
        txt_senha = new JTextField();
        txt_senha.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        txt_senha.setForeground(new Color(255, 255, 255));
        txt_senha.setBounds(42, 11, 469, 27);
        panel_4.add(txt_senha);
        txt_senha.setColumns(10);
        txt_senha.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        txt_senha.setForeground(Color.BLACK);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        painelFormulario.add(panel_3, "cell 1 16,grow");
        panel_3.setLayout(null);
        
        cbSim = new JCheckBox("sim");
        cbSim.setForeground(new Color(0, 0, 0));
        cbSim.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cbSim.setBackground(new Color(255, 255, 255));
        cbSim.setBounds(6, 7, 70, 33);
        panel_3.add(cbSim);
        
        cbNao = new JCheckBox("não");
        cbNao.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cbNao.setBackground(Color.WHITE);
        cbNao.setBounds(78, 7, 70, 33);
        panel_3.add(cbNao);
        grupo.add(cbSim);
        grupo.add(cbNao);
        
        btnCriar = new JLabel("");
        btnCriar.setIcon(new ImageIcon(Login.class.getResource("/tela/Frame 2 - Copia.png")));
        painelFormulario.add(btnCriar, "flowx,cell 1 18,alignx left");
        
        JLabel lblNewLabel_9 = new JLabel(" ");
        painelFormulario.add(lblNewLabel_9, "cell 1 23");
    }

    // ─── getters exigidos pelo controller ─────────────────────────────────

    public JTextField getTxtNome()      { return txtNomeCompleto; }
    public JTextField getTxtDataNasc()  { return txtDataNasc; }
    public JTextField getTxt_email()    { return txt_email; }
    public JTextField getTxt_senha()    { return txt_senha; }
    public JTextField getTxtCPF()       { return txtDataNasc; }

    public JCheckBox getCbSim()         { return cbSim; }
    public JCheckBox getCbNao()         { return cbNao; }

    public JTable getTable()            { return table; }
    public void setTable(JTable t)      { this.table = t; }

    public JButton getBtnAdicionar()    { return btnAdicionar; }
    public void setBtnAdicionar(JButton b) { this.btnAdicionar = b; }

    public JButton getBtnRemover()      { return btnRemover; }
    public void setBtnRemover(JButton b) { this.btnRemover = b; }

    public JButton getBtnVisualizar()   { return btnVisualizar; }
    public void setBtnVisualizar(JButton b) { this.btnVisualizar = b; }

    public JLabel getBtnVisu()          { return btnVisu; }
    public JLabel getBtnCriar()         { return btnCriar; }
}

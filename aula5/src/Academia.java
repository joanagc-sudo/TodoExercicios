import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Academia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JLabel lblResultado;

    private JRadioButton btnRBasico, btnRIntermediario, btnRPremium;
    private JRadioButton btnRMensal, btnRSemestral, btnRAnual;
    private JRadioButton btnR2x, btnR3x, btnR5x;

    public Academia() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][][]"));

        JLabel titulo = new JLabel("Cadastro de Cliente - Academia TREINO FIT");
        titulo.setFont(new Font("Arial Black", Font.PLAIN, 18));
        contentPane.add(titulo, "cell 1 0 5 1");

        contentPane.add(new JLabel("Nome"), "cell 1 1");
        txtNome = new JTextField();
        contentPane.add(txtNome, "cell 2 1 4 1,growx");

        contentPane.add(new JLabel("Telefone"), "cell 1 2");
        txtTelefone = new JTextField();
        contentPane.add(txtTelefone, "cell 2 2 4 1,growx");

        // PLANOS
        contentPane.add(new JLabel("Tipo de plano:"), "cell 1 3");

        btnRBasico = new JRadioButton("Básico");
        btnRIntermediario = new JRadioButton("Intermediário");
        btnRPremium = new JRadioButton("Premium");

        ButtonGroup grupoPlano = new ButtonGroup();
        grupoPlano.add(btnRBasico);
        grupoPlano.add(btnRIntermediario);
        grupoPlano.add(btnRPremium);

        contentPane.add(btnRBasico, "cell 2 3");
        contentPane.add(btnRIntermediario, "cell 3 3");
        contentPane.add(btnRPremium, "cell 4 3");

        // DURAÇÃO
        contentPane.add(new JLabel("Duração:"), "cell 1 4");

        btnRMensal = new JRadioButton("Mensal");
        btnRSemestral = new JRadioButton("Semestral");
        btnRAnual = new JRadioButton("Anual");

        ButtonGroup grupoDuracao = new ButtonGroup();
        grupoDuracao.add(btnRMensal);
        grupoDuracao.add(btnRSemestral);
        grupoDuracao.add(btnRAnual);

        contentPane.add(btnRMensal, "cell 2 4");
        contentPane.add(btnRSemestral, "cell 3 4");
        contentPane.add(btnRAnual, "cell 4 4");

        // FREQUÊNCIA
        contentPane.add(new JLabel("Frequência semanal:"), "cell 1 5");

        btnR2x = new JRadioButton("2x por semana");
        btnR3x = new JRadioButton("3x por semana");
        btnR5x = new JRadioButton("5x por semana");

        ButtonGroup grupoFreq = new ButtonGroup();
        grupoFreq.add(btnR2x);
        grupoFreq.add(btnR3x);
        grupoFreq.add(btnR5x);

        contentPane.add(btnR2x, "cell 2 5");
        contentPane.add(btnR3x, "cell 3 5");
        contentPane.add(btnR5x, "cell 4 5");

        // BOTÃO
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        contentPane.add(btnCalcular, "cell 2 6");

        // RESULTADO
        contentPane.add(new JLabel("Valor final:"), "cell 3 6");
        lblResultado = new JLabel("");
        contentPane.add(lblResultado, "cell 4 6");
    }

    private void calcular() {

        if (txtNome.getText().isEmpty() || txtTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha seu nome e telefone");
            return;
        }

        String plano = null;
        if (btnRBasico.isSelected()) plano = "Básico";
        if (btnRIntermediario.isSelected()) plano = "Intermediário";
        if (btnRPremium.isSelected()) plano = "Premium";

        String duracao = null;
        if (btnRMensal.isSelected()) duracao = "Mensal";
        if (btnRSemestral.isSelected()) duracao = "Semestral";
        if (btnRAnual.isSelected()) duracao = "Anual";

        String frequencia = null;
        if (btnR2x.isSelected()) frequencia = "2x";
        if (btnR3x.isSelected()) frequencia = "3x";
        if (btnR5x.isSelected()) frequencia = "5x";

        if (plano == null || duracao == null || frequencia == null) {
            JOptionPane.showMessageDialog(this, "Selecione todas as opções!");
            return;
        }

        double valor = PlanoAcademia.calcularValor(plano, duracao, frequencia);

        lblResultado.setText("R$ " + String.format("%.2f", valor));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Academia().setVisible(true);
        });
    }
}
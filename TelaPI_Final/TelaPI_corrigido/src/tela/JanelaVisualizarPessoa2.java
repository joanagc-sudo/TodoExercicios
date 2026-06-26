package tela;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class JanelaVisualizarPessoa2 extends JDialog {

    private JTextField txtNome;
    private JTextField txtNasc;
    private JTextField txt_email;
  
    
    private JButton btnSalvar;
    private JButton btnCancelar;

    public JanelaVisualizarPessoa2() {

        setModal(true);
        setTitle("Visualizar Pessoa");
        setBounds(100, 100, 350, 180);

        getContentPane().setLayout(
                new MigLayout("", "[][grow][]", "[][][][][]"));

        getContentPane().add(new JLabel("Nome:"), "cell 0 0");
        txtNome = new JTextField();
        getContentPane().add(txtNome, "cell 1 0,growx");

        getContentPane().add(new JLabel("Nascimento:"), "cell 0 1");
        txtNasc = new JTextField();
        getContentPane().add(txtNasc, "cell 1 1,growx");
        
        getContentPane().add(new JLabel("Email:"), "cell 0 2");
        txt_email = new JTextField();
        getContentPane().add(txt_email, "cell 1 2,growx");
        
                btnSalvar = new JButton("Salvar");
                getContentPane().add(btnSalvar, "flowx,cell 1 3");
        
                btnCancelar = new JButton("Cancelar");
                getContentPane().add(btnCancelar, "cell 1 3");

    }

    public JTextField getTxtNome() {
        return txtNome;
    }
    public JTextField getTxt_email() {
        return txt_email;
    }
  
    public JTextField getTxtCpf() {
        return txtNasc;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}

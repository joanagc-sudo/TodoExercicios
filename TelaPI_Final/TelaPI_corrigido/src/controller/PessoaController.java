package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Pessoa;
import model.PessoaTableModel;
import tela.Login;
import tela.Gerenciar;
import tela.JanelaVisualizarPessoa2;

public class PessoaController {
	
	private PessoaTableModel pessoaModel;
	private Login view;
	private Gerenciar gerenciar;
	
	// formatador para converter texto dd/MM/yyyy em LocalDate
	private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public PessoaController(PessoaTableModel modelo, Login view) {
		this.pessoaModel = modelo;
		this.view = view;

		// abre Gerenciar passando o modelo — tabela e botões ficam lá
		this.gerenciar = new Gerenciar(pessoaModel);

		this.gerenciar.getTable().setModel(modelo);
		this.gerenciar.getBtnAdicionar().addActionListener(e -> eventoBotaoVisualizar());
		this.gerenciar.getBtnRemover().addActionListener(e -> eventoBotaoRemover());

		// botão "olho" no Login abre a janela Gerenciar
		this.view.getBtnVisu().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				gerenciar.setVisible(true);
			}
		});

		// botão "Criar conta" no Login cadastra a pessoa
		this.view.getBtnCriar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				eventoBotaoAdicionar();
			}
		});
	}

	public void eventoBotaoRemover() {
		int linhaSelecionada = this.gerenciar.getTable().getSelectedRow();
		if (linhaSelecionada == -1) {
			JOptionPane.showMessageDialog(gerenciar, "Selecione um registro para remover!");
			return;
		}
		pessoaModel.remover(linhaSelecionada);
	}

//	 private JPanel contentPane;
//	    private JTextField textConfirmarSenha;
//	    private JTextField txtNome;
//	    private JTextField txt_senha;
//	    private JTextField txtDataNasc;
//	    private JTextField txt_email;
//	    private JTextField txtNomeCompleto;
//	    private JTextField textField_1;
	public void eventoBotaoAdicionar() {
		String nome = this.view.getTxtNome().getText().trim();
		String nascTexto = this.view.getTxtDataNasc().getText().trim();
		String email = this.view.getTxt_email().getText().trim();
		String senha = this.view.getTxt_senha().getText().trim();
		boolean em = this.view.getCbSim().isSelected();

		if (nome.isEmpty() || nascTexto.isEmpty() || email.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(view, "Preencha todos os campos!");
			return;
		}

		// converte o texto da data de nascimento para LocalDate
		LocalDate nasc;
		try {
			nasc = LocalDate.parse(nascTexto, FMT);
		} catch (DateTimeParseException ex) {
			JOptionPane.showMessageDialog(view, "Data inválida! Use o formato dd/MM/yyyy.");
			return;
		}
		
		Pessoa p = new Pessoa(nome, nasc, email, senha, em);
		pessoaModel.adicionarPessoa(p);

		this.view.getTxtNome().setText("");
		this.view.getTxtCPF().setText("");
		this.view.getTxt_email().setText("");
		this.view.getTxt_senha().setText("");
	}
	
	private void eventoBotaoVisualizar() {

	    int linhaSelecionada = gerenciar.getTable().getSelectedRow();

	    if(linhaSelecionada == -1) {
	        JOptionPane.showMessageDialog(gerenciar, "Selecione um registro!");
	        return;
	    }

	    Pessoa pessoa = pessoaModel.getPessoa(linhaSelecionada);

	    JanelaVisualizarPessoa2 janela = new JanelaVisualizarPessoa2();

	    janela.getTxtNome().setText(pessoa.getNome());
	    janela.getTxt_email().setText(pessoa.getEmail());
	    janela.getTxtCpf().setText(
	    		pessoa.getNasc() != null ? pessoa.getNasc().format(FMT) : "");

	    janela.getBtnCancelar().addActionListener(e -> {
	        janela.dispose();
	    });

	    janela.getBtnSalvar().addActionListener(e -> {

	        pessoa.setNome(janela.getTxtNome().getText());
	        pessoa.setEmail(janela.getTxt_email().getText());

	        // converte o texto editado de volta para LocalDate
	        try {
	        	LocalDate novaData = LocalDate.parse(janela.getTxtCpf().getText().trim(), FMT);
	        	pessoa.setNasc(novaData);
	        } catch (DateTimeParseException ex) {
	        	JOptionPane.showMessageDialog(janela, "Data inválida! Use o formato dd/MM/yyyy.");
	        	return;
	        }

	        pessoaModel.atualizarPessoa(linhaSelecionada, pessoa);
	        janela.dispose();
	    });

	    janela.setLocationRelativeTo(gerenciar);
	    janela.setVisible(true);
	}

}

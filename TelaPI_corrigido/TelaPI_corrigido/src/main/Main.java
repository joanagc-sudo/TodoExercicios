package main;

import model.PessoaTableModel;
import tela.Login;
import controller.PessoaController;

public class Main {

	public static void main(String[] args) {
		
		PessoaTableModel model = new PessoaTableModel();
		Login view = new Login();
		PessoaController controller = new PessoaController(model, view);
		view.setVisible(true);
		

	}

}

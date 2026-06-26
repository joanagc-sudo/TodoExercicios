package model;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PessoaTableModel extends AbstractTableModel{
	ArrayList<Pessoa> lista;
	
	// Formatador para exibir LocalDate como dd/MM/yyyy na tabela
	private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	String colunas[] = new String[] { "Nome", "Data de nascimento", "Email", "Ensino medio"};
	
	public PessoaTableModel() {
		this.lista = new ArrayList();
	}
	
	public PessoaTableModel(ArrayList<Pessoa> lista) {
		this.lista = lista;
	}
	/**
	 * Retorna o nome da Coluna consultando a String do vetor "colunas"
	 * no índice "indice"
	 */
	@Override
	public String getColumnName(int indice) {
		return colunas[indice]; 
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Pessoa pessoa = lista.get(rowIndex);
		if(columnIndex == 0) {
			return pessoa.getNome();
		} 
		if(columnIndex == 1) {
			return pessoa.getNasc() != null ? pessoa.getNasc().format(FMT) : "";
		}
		if(columnIndex == 2) {
			return pessoa.getEmail();
		}
		if(columnIndex == 3) {
			return pessoa.isEm() ? "Sim" : "Não";
		}
		
		return null;
	}

	public void remover(int linhaSelecionada) {
		lista.remove(linhaSelecionada);
		fireTableDataChanged();
		
	}

	public void adicionarPessoa(Pessoa p) {
		lista.add(p);
		fireTableDataChanged();
		
	}
	
	public Pessoa getPessoa(int linha) {
	    return lista.get(linha);
	}

	public void atualizarPessoa(int linha, Pessoa pessoa) {
	    lista.set(linha, pessoa);
	    fireTableRowsUpdated(linha, linha);
	}

	
}

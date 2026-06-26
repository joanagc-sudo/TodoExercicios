package ExercicioAula;

public enum Duracao {
	MENSAL("Mensal"), SEMESTRAL("Semestral"), ANUAL("Anual");
	
	String descricao;
	
	Duracao(String descricao){
		this.descricao = descricao;
	}
}

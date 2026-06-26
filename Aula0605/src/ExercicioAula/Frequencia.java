package ExercicioAula;

public enum Frequencia {
	DUAS_VEZES_SEMANA("2x por semana"), TRES_VEZES_SEMANA("3x por semana"), CINCO_VEZES_SEMANA("5x por semana");
	String descricao;
	
	Frequencia(String descricao){
		this.descricao = descricao;
	}
	
	public String toString() {
		return descricao;
	}
}

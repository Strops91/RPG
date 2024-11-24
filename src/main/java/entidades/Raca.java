package entidades;

public class Raca {

	private int id;
	private String nome;
	private int bonusVida;
	private int bonusEscudo;
	private int bonusFisico;
	private int bonusHabilidade;

	public Raca() {
		super();
	}

	public Raca(String nome, int bonusVida, int bonusEscudo, int bonusFisico, int bonusHabilidade) {
		super();
		this.nome = nome;
		this.bonusVida = bonusVida;
		this.bonusEscudo = bonusEscudo;
		this.bonusFisico = bonusFisico;
		this.bonusHabilidade = bonusHabilidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getBonusVida() {
		return bonusVida;
	}

	public void setBonusVida(int bonusVida) {
		this.bonusVida = bonusVida;
	}

	public int getBonusEscudo() {
		return bonusEscudo;
	}

	public void setBonusEscudo(int bonusEscudo) {
		this.bonusEscudo = bonusEscudo;
	}

	public int getBonusFisico() {
		return bonusFisico;
	}

	public void setBonusFisico(int bonusFisico) {
		this.bonusFisico = bonusFisico;
	}

	public int getBonusHabilidade() {
		return bonusHabilidade;
	}

	public void setBonusHabilidade(int bonusHabilidade) {
		this.bonusHabilidade = bonusHabilidade;
	}



	@Override
	public String toString() {
		return "Raca [id=" + id + ", nome=" + nome + ", bonusVida=" + bonusVida + ", bonusEscudo=" + bonusEscudo
				+ ", bonusFisico=" + bonusFisico + ", bonusHabilidade=" + bonusHabilidade + "]";
	}

	// talvez seja necessario excluir
//	public static Raca criandoObjetoRaca(String nome, int bonusVida, int bonusEscudo, int bonusFisico, int bonusHabilidade) {
//		Raca raca = new Raca();
//		raca.nome = nome;
//		raca.bonusVida = bonusVida;
//		raca.bonusEscudo = bonusEscudo;
//		raca.bonusFisico = bonusFisico;
//		raca.bonusHabilidade = bonusHabilidade;
//		return raca;
//	}
	
	
	

}

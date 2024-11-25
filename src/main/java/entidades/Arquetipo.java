package entidades;

public class Arquetipo {

	private int id;
	private String nome;
	private int bonusVida;
	private int bonusEscudo;
	private int bonusFisico;
	private int bonusHabilidade;

	public Arquetipo() {
		super();
	}

	public Arquetipo(String nome, int bonusVida, int bonusEscudo, int bonusFisico, int bonusHabilidade) {
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
		return "Arquetipo [id=" + id + ", nome=" + nome + ", bonusVida=" + bonusVida + ", bonusEscudo=" + bonusEscudo
				+ ", bonusFisico=" + bonusFisico + ", bonusHabilidade=" + bonusHabilidade + "]";
	}
}

//	public Arquetipo(String nome2, int bonusHabilidade2, int bonusHabilidade3, int bonusHabilidade4, int bonusHabilidade5) {
//		Arquetipo arquetipo = new Arquetipo(nome, bonusHabilidade, bonusHabilidade, bonusHabilidade, bonusHabilidade);
//		this.nome = nome;
//		this.bonusVida = bonusVida;
//		this.bonusEscudo = bonusEscudo;
//		this.bonusFisico = bonusFisico;
//		this.bonusHabilidade = bonusHabilidade;
//	}
//
//	public static Arquetipo criandoObjetoArquetipo(String string, int i, int j, int k, int l) {
//		Arquetipo arquetipo = new Arquetipo(string, l, l, l, l);
//		arquetipo.nome = nome;
//		arquetipo.bonusVida = bonusVida;
//		arquetipo.bonusEscudo = bonusEscudo;
//		arquetipo.bonusFisico = bonusFisico;
//		arquetipo.bonusHabilidade = bonusHabilidade;
//		return arquetipo;
//	}
//



package entidades;

public class Batalha {

	private int id;
	private String nome;
	private int vida;
	private int escudo;
	private int fisico;
	private int habilidade;

	public Batalha() {
		super();
	}

	public Batalha(String nome, int vida, int escudo, int fisico, int habilidade) {
		super();
		this.nome = nome;
		this.vida = vida;
		this.escudo = escudo;
		this.fisico = fisico;
		this.habilidade = habilidade;
	}


	public Batalha(Personagem legolas, Personagem grom) {
		// TODO Auto-generated constructor stub
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	public int getFisico() {
		return fisico;
	}

	public void setFisico(int fisico) {
		this.fisico = fisico;
	}

	public int getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(int habilidade) {
		this.habilidade = habilidade;
	}

	@Override
	public String toString() {
		return "Batalha [id=" + id + ", nome=" + nome + ", bonusVida=" + vida + ", bonusEscudo=" + escudo
				+ ", bonusFisico=" + fisico + ", bonusHabilidade=" + habilidade + "]";
	}

	public void iniciar() {
		// TODO Auto-generated method stub
		
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

}

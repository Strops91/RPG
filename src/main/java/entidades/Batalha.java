package entidades;

public class Batalha {

    private Personagem personagem1;
    private Personagem personagem2;

    public Batalha(Personagem personagem1, Personagem personagem2) {
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;
    }

    public void iniciar() {
        System.out.println("Iniciando batalha entre " + personagem1.getNome() + " e " + personagem2.getNome());

        while (personagem1.getBonusVida() > 0 && personagem2.getBonusVida() > 0) {
            // Personagem 1 ataca
            int dano1 = Math.max(0, personagem1.getBonusFisico() - personagem2.getBonusEscudo());
            personagem2.setBonusVida(personagem2.getBonusVida() - dano1);
            System.out.println(personagem1.getNome() + " causou " + dano1 + " de dano a " + personagem2.getNome());
            if (personagem2.getBonusVida() <= 0) {
                System.out.println(personagem2.getNome() + " foi derrotado!");
                break;
            }

            // Personagem 2 ataca
            int dano2 = Math.max(0, personagem2.getBonusFisico() - personagem1.getBonusEscudo());
            personagem1.setBonusVida(personagem1.getBonusVida() - dano2);
            System.out.println(personagem2.getNome() + " causou " + dano2 + " de dano a " + personagem1.getNome());
            if (personagem1.getBonusVida() <= 0) {
                System.out.println(personagem1.getNome() + " foi derrotado!");
                break;
            }
        }

        System.out.println("Batalha encerrada!");
    }

    private int id;
	private String nome;
	private int bonusVida;
	private int bonusEscudo;
	private int bonusFisico;
	private int bonusHabilidade;

	public Batalha() {
		super();
	}

	public Batalha(String nome, int bonusVida, int bonusEscudo, int bonusFisico, int bonusHabilidade) {
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

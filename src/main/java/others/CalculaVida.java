package others;

import entidades.Arquetipo;
import entidades.Raca;
import repository.RepositoryArquetipo;
import repository.RepositoryRaca;


public class CalculaVida {

	public int calculaVida(int racaId, int arquetipoId) {

		
		
		int vida = 100;
		
		RepositoryArquetipo repositoryArquetipo = new RepositoryArquetipo();
		RepositoryRaca repositoryRaca = new RepositoryRaca();

		Raca raca = repositoryRaca.buscarRacaPorId(racaId);
		Arquetipo arquetipo = repositoryArquetipo.buscarArquetipoPorId(arquetipoId);

		int racaBonusVida = raca.getBonusVida();
		int arquetipoBonusVida = arquetipo.getBonusVida();

		vida += racaBonusVida + arquetipoBonusVida;

		return vida;
	}

	public int calculaEscudo(int racaId, int arquetipoId) {
		int escudo = 100;

		RepositoryArquetipo repositoryArquetipo = new RepositoryArquetipo();
		RepositoryRaca repositoryRaca = new RepositoryRaca();

		Raca raca = repositoryRaca.buscarRacaPorId(racaId);
		Arquetipo arquetipo = repositoryArquetipo.buscarArquetipoPorId(arquetipoId);

		int racaBonusEscudo = raca.getBonusEscudo();
		int arquetipoBonusEscudo = arquetipo.getBonusEscudo();

		escudo += racaBonusEscudo + arquetipoBonusEscudo;

		return escudo;
	}

	public int calculaPoderFisico(int racaId, int arquetipoId) {
		int poderFisico = 1;

		RepositoryArquetipo repositoryArquetipo = new RepositoryArquetipo();
		RepositoryRaca repositoryRaca = new RepositoryRaca();

		Raca raca = repositoryRaca.buscarRacaPorId(racaId);
		Arquetipo arquetipo = repositoryArquetipo.buscarArquetipoPorId(arquetipoId);

		int racaPoderFisico = raca.getBonusFisico();
		int arquetipoPoderFisico = arquetipo.getBonusFisico();

		poderFisico += racaPoderFisico + arquetipoPoderFisico;

		return poderFisico;
	}

	public int calculaPoderHabilidade(int racaId, int arquetipoId) {
		int poderHabilidade = 1;

		RepositoryRaca repositoryRaca = new RepositoryRaca();
		RepositoryArquetipo repositoryArquetipo = new RepositoryArquetipo();

		Raca raca = repositoryRaca.buscarRacaPorId(racaId);
		Arquetipo arquetipo = repositoryArquetipo.buscarArquetipoPorId(arquetipoId);

		int racaPoderHabilidade = raca.getBonusHabilidade();
		int arquetipoPoderHabilidade = arquetipo.getBonusHabilidade();

		poderHabilidade += racaPoderHabilidade + arquetipoPoderHabilidade;

		return poderHabilidade;
	}

}
package rpg;
import entidades.Arquetipo;
import entidades.Batalha;
import entidades.Personagem;
import entidades.Raca;
import repository.RepositoryArquetipo;
import repository.RepositoryBatalha;
import repository.RepositoryPersonagem;
import repository.RepositoryRaca;

public class Main {
    public static void main(String[] args) {

        RepositoryRaca repositoryRaca = new RepositoryRaca();
        RepositoryArquetipo repositoryArquetipo = new RepositoryArquetipo();
        RepositoryPersonagem repositoryPersonagem = new RepositoryPersonagem();
        RepositoryBatalha repositoryBatalha = new RepositoryBatalha();


        Raca elfo = new Raca("Elfo", 10, 5, 2, 8);
        repositoryRaca.salvarRaca(elfo);
        Arquetipo arqueiro = new Arquetipo("Arqueiro", 20, 10, 7, 3);
        repositoryArquetipo.salvarArquetipo(arqueiro);
        Personagem legolas = new Personagem("Legolas", 100, 20, 30, 40);
        repositoryPersonagem.salvarPersonagem(legolas);


        Raca orc = new Raca("Orc", 10, 5, 2, 8);
        repositoryRaca.salvarRaca(orc);

        Arquetipo guerreiro = new Arquetipo("Guerreiro", 20, 10, 7, 3);
        repositoryArquetipo.salvarArquetipo(guerreiro);
        Personagem grom = new Personagem("Grom", 120, 15, 35, 25);
        repositoryPersonagem.salvarPersonagem(grom);
        

        Batalha batalha = new Batalha(legolas, grom);
        batalha.iniciar();
        repositoryBatalha.salvarBatalha(batalha);

        
        System.out.println("Raças salvas: " + repositoryRaca.buscarTodasRacas());
        System.out.println("Personagens salvos: " + repositoryPersonagem.buscarTodasPersonagem());
        System.out.println("Batalhas registradas: " + repositoryBatalha.buscarTodasBatalhas());
    }
}

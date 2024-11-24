import java.util.List;

import entidades.Arquetipo;
import entidades.Batalha;
import entidades.Lutador;
import entidades.Personagem;
import entidades.Raca;
import repository.RepositoryArquetipo;
import repository.RepositoryBatalha;
import repository.RepositoryLutador;
import repository.RepositoryPersonagem;
import repository.RepositoryRaca;

public class Main {
    public static void main(String[] args) {
        // Passo 1: Inicialização dos Repositórios
        RepositoryRaca repositoryRaca = new RepositoryRaca();
        RepositoryArquetipo repositoryArquetipo = new RepositoryArquetipo();
        RepositoryPersonagem repositoryPersonagem = new RepositoryPersonagem();
        RepositoryBatalha repositoryBatalha = new RepositoryBatalha();

        // Passo 2: Criação e Persistência das Entidades
        Raca elfo = new Raca("Elfo", 10, 5, 2, 8);
        repositoryRaca.salvarRaca(elfo);
        Arquetipo arqueiro = new Arquetipo("Arqueiro", 20, 10, 7, 3);
        repositoryArquetipo.salvarArquetipo(arqueiro);
        Personagem legolas = new Personagem("Legolas", 100, 50, 15, 10);
        repositoryPersonagem.salvarPersonagem(legolas);

        // Corrigido: Criar uma nova raça "Orc"
        Raca orc = new Raca("Orc", 10, 5, 2, 8);
        repositoryRaca.salvarRaca(orc);

        Arquetipo guerreiro = new Arquetipo("Guerreiro", 20, 10, 7, 3);
        repositoryArquetipo.salvarArquetipo(guerreiro);
        Personagem grom = new Personagem("Grom", 100, 50, 15, 10);
        repositoryPersonagem.salvarPersonagem(grom);
        
        // Passo 3: Configuração e Execução da Batalha
        Batalha batalha = new Batalha(legolas, grom);
        batalha.iniciar();
        repositoryBatalha.salvarBatalha(batalha);

        // Passo 4: Verificação dos Dados Salvos
        System.out.println("Raças salvas: " + repositoryRaca.buscarTodasRacas());
        System.out.println("Personagens salvos: " + repositoryPersonagem.buscarTodosPersonagens());
        System.out.println("Batalhas registradas: " + repositoryBatalha.buscarTodasBatalhas());
    }
}

package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import database.DatabaseConnection;
import entidades.Personagem;

public class RepositoryPersonagem {

    // Método para salvar uma instância de Arquetipo no banco de dados
    public void salvarPersonagem(Personagem personagem) {
        // Comando SQL para inserir uma nova raça com os valores especificados
        String sql = "INSERT INTO personagem (nome, bonus_vida, bonus_escudo, bonus_poderfisico, bonus_poderhabilidade) VALUES (?, ?, ?, ?, ?);";

        // Tenta conectar ao banco de dados e preparar a execução do comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             // Prepara a instrução SQL e especifica que as chaves geradas serão retornadas
             PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Define os valores dos parâmetros na instrução SQL
            stmt.setString(1, personagem.getNome());
            stmt.setInt(2, personagem.getBonusVida());
            stmt.setInt(3, personagem.getBonusEscudo());
            stmt.setInt(4, personagem.getBonusFisico());
            stmt.setInt(5, personagem.getBonusHabilidade());
            // Executa a inserção no banco de dados
            stmt.executeUpdate();
            
            // Obtém as chaves geradas pelo banco (neste caso, o ID da raça inserida)
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                // Atribui o ID gerado à instância de Raca
            	personagem.setId(generatedKeys.getInt(1));
            }

            // Mensagem de confirmação de que a raça foi salva com sucesso
            System.out.println("Personagem " + personagem.getNome() + " salva com ID " + personagem.getId());

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }
    }

    // Método para buscar todas as raças no banco de dados
   public List<Personagem> buscarTodasPersonagem() {
        // Lista para armazenar as raças encontradas
        List<Personagem> personagens = new ArrayList<>();
        // Comando SQL para selecionar todas as raças
        String sql = "SELECT * FROM personagem";

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Itera sobre os resultados e cria objetos Raca para cada linha
            while (rs.next()) {
            	Personagem persongaem = new Personagem();
            	persongaem.setId(rs.getInt("id"));
            	persongaem.setNome(rs.getString("nome"));
            	persongaem.setBonusVida(rs.getInt("bonus_vida"));
            	persongaem.setBonusEscudo(rs.getInt("bonus_escudo"));
            	persongaem.setBonusFisico(rs.getInt("bonus_poderfisico"));
            	persongaem.setBonusHabilidade(rs.getInt("bonus_poderhabilidade"));
                // Adiciona a raça à lista
            	personagens.add(persongaem);
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a lista de raças encontradas
        return personagens;
    }

    // Método para buscar uma raça específica pelo ID
    public Personagem buscarPersonagemPorId(int id) {
        // Comando SQL para selecionar a raça pelo ID
        String sql = "SELECT * FROM personagem WHERE id = ?";
        Personagem personagem = null;

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Define o valor do parâmetro na instrução SQL
            stmt.setInt(1, id);
            // Executa a consulta e obtém os resultados
            try (ResultSet rs = stmt.executeQuery()) {
                // Verifica se a raça foi encontrada
                if (rs.next()) {
                	personagem = new Personagem(sql, id, id, id, id);
                	personagem.setId(rs.getInt("id"));
                	personagem.setNome(rs.getString("nome"));
                	personagem.setBonusVida(rs.getInt("bonus_vida"));
                	personagem.setBonusEscudo(rs.getInt("bonus_escudo"));
                	personagem.setBonusFisico(rs.getInt("bonus_poderfisico"));
                	personagem.setBonusHabilidade(rs.getInt("bonus_poderhabilidade"));
                }
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a raça encontrada ou null se não existir
        return personagem;
    }

	

	
}
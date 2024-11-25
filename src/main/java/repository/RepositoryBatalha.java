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
import entidades.Batalha;

public class RepositoryBatalha {

	public void salvarBatalha(Batalha batalha) {

		String sql = "INSERT INTO batalha (nome, bonus_vida, bonus_escudo, bonus_poderfisico, bonus_poderhabilidade) VALUES (?, ?, ?, ?, ?);";

		// Tenta conectar ao banco de dados e preparar a execução do comando SQL
		try (Connection conexao = DatabaseConnection.conectar();
				// Prepara a instrução SQL e especifica que as chaves geradas serão retornadas
				PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

			// Define os valores dos parâmetros na instrução SQL
			stmt.setString(1, batalha.getNome());
			stmt.setInt(2, batalha.getBonusVida());
			stmt.setInt(3, batalha.getBonusEscudo());
			stmt.setInt(4, batalha.getBonusFisico());
			stmt.setInt(5, batalha.getBonusHabilidade());
			// Executa a inserção no banco de dados
			stmt.executeUpdate();

			// Obtém as chaves geradas pelo banco (neste caso, o ID da raça inserida)
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				// Atribui o ID gerado à instância de Raca
				batalha.setId(generatedKeys.getInt(1));
			}

			// Mensagem de confirmação de que a raça foi salva com sucesso
			System.out.println("Batalha " + batalha.getNome() + " salva com ID " + batalha.getId());

		} catch (SQLException e) {
			// Em caso de erro, imprime o stack trace para facilitar a identificação do
			// problema
			e.printStackTrace();
		}
	}

    // Método para buscar todas as raças no banco de dados
   public List<Batalha> buscarTodasRacas() {
        // Lista para armazenar as raças encontradas
        List<Batalha> batalhas = new ArrayList<>();
        // Comando SQL para selecionar todas as raças
        String sql = "SELECT * FROM batalha";

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Itera sobre os resultados e cria objetos Raca para cada linha
            while (rs.next()) {
            	Batalha batalha = new Batalha();
            	batalha.setId(rs.getInt("id"));
            	batalha.setNome(rs.getString("nome"));
            	batalha.setBonusVida(rs.getInt("bonus_vida"));
            	batalha.setBonusEscudo(rs.getInt("bonus_escudo"));
            	batalha.setBonusFisico(rs.getInt("bonus_poderfisico"));
            	batalha.setBonusHabilidade(rs.getInt("bonus_poderhabilidade"));
                // Adiciona a raça à lista
            	batalhas.add(batalha);
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a lista de raças encontradas
        return batalhas;
    }

	// Método para buscar uma raça específica pelo ID
	public Batalha buscarBatalhaPorId(int id) {
		// Comando SQL para selecionar a raça pelo ID
		String sql = "SELECT * FROM batalha WHERE id = ?";
		Batalha batalha = null;

		// Tenta conectar ao banco de dados e executar o comando SQL
		try (Connection conexao = DatabaseConnection.conectar();
				PreparedStatement stmt = conexao.prepareStatement(sql)) {

			// Define o valor do parâmetro na instrução SQL
			stmt.setInt(1, id);
			// Executa a consulta e obtém os resultados
			try (ResultSet rs = stmt.executeQuery()) {
				// Verifica se a raça foi encontrada
				if (rs.next()) {
					batalha = new Batalha(sql, id, id, id, id);
					batalha.setId(rs.getInt("id"));
					batalha.setNome(rs.getString("nome"));
					batalha.setBonusVida(rs.getInt("bonus_vida"));
					batalha.setBonusEscudo(rs.getInt("bonus_escudo"));
					batalha.setBonusFisico(rs.getInt("bonus_poderfisico"));
					batalha.setBonusHabilidade(rs.getInt("bonus_poderhabilidade"));
				}
			}

		} catch (SQLException e) {
			// Em caso de erro, imprime o stack trace para facilitar a identificação do
			// problema
			e.printStackTrace();
		}

		// Retorna a raça encontrada ou null se não existir
		return batalha;
	}

	public char[] buscarTodasBatalhas() {
		// TODO Auto-generated method stub
		return null;
	}
}
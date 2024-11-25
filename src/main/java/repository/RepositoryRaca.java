package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import entidades.Raca;

public class RepositoryRaca {
	
    // Método para salvar uma instância de Raca no banco de dados
    public void salvarRaca(Raca raca) {
        // Comando SQL para inserir uma nova raça com os valores especificados
        String sql = "INSERT INTO raca (nome, bonus_vida, bonus_escudo, bonus_poderfisico, bonus_poderhabilidade) VALUES (?, ?, ?, ?, ?);";

        // Tenta conectar ao banco de dados e preparar a execução do comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             // Prepara a instrução SQL e especifica que as chaves geradas serão retornadas
             PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Define os valores dos parâmetros na instrução SQL
			stmt.setString(1, raca.getNome());
			stmt.setInt(2, raca.getBonusVida());
			stmt.setInt(3, raca.getBonusEscudo());
			stmt.setInt(4, raca.getBonusFisico());
			stmt.setInt(5, raca.getBonusHabilidade());
            // Executa a inserção no banco de dados
            stmt.executeUpdate();

            // Obtém as chaves geradas pelo banco (neste caso, o ID da raça inserida)
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                // Atribui o ID gerado à instância de Raca
                raca.setId(generatedKeys.getInt(1));
            }

            // Mensagem de confirmação de que a raça foi salva com sucesso
            System.out.println("Raça " + raca.getNome() + " salva com ID " + raca.getId());

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }
    }

    // Método para buscar todas as raças no banco de dados
    public List<Raca> buscarTodasRacas() {
        // Lista para armazenar as raças encontradas
        List<Raca> racas = new ArrayList<>();
        // Comando SQL para selecionar todas as raças
        String sql = "SELECT * FROM raca";

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Itera sobre os resultados e cria objetos Raca para cada linha
            while (rs.next()) {
                Raca raca = new Raca();
                raca.setId(rs.getInt("id"));
                raca.setNome(rs.getString("nome"));
                raca.setBonusVida(rs.getInt("bonus_vida"));
                raca.setBonusEscudo(rs.getInt("bonus_escudo"));
                raca.setBonusFisico(rs.getInt("bonus_poderfisico"));
                raca.setBonusHabilidade(rs.getInt("bonus_poderhabilidade"));
                // Adiciona a raça à lista
                racas.add(raca);
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a lista de raças encontradas
        return racas;
    }

    // Método para buscar uma raça específica pelo ID
    public Raca buscarRacaPorId(int id) {
        // Comando SQL para selecionar a raça pelo ID
        String sql = "SELECT * FROM raca WHERE id = ?";
        Raca raca = null;

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Define o valor do parâmetro na instrução SQL
            stmt.setInt(1, id);
            // Executa a consulta e obtém os resultados
            try (ResultSet rs = stmt.executeQuery()) {
                // Verifica se a raça foi encontrada
                if (rs.next()) {
                    raca = new Raca();
                    raca.setId(rs.getInt("id"));
                    raca.setNome(rs.getString("nome"));
                    raca.setBonusVida(rs.getInt("bonus_vida"));
                    raca.setBonusEscudo(rs.getInt("bonus_escudo"));
                    raca.setBonusFisico(rs.getInt("bonus_poderfisico"));
                    raca.setBonusHabilidade(rs.getInt("bonus_poderhabilidade"));
                }
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a raça encontrada ou null se não existir
        return raca;
    }
}
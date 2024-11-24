package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import database.DatabaseConnection;
import entidades.Lutador;

public class RepositoryLutador {

    // Método para salvar uma instância de Arquetipo no banco de dados
    public void salvarLutador(Lutador lutador) {
        // Comando SQL para inserir uma nova raça com os valores especificados
        String sql = "INSERT INTO lutador (nome, bonus_vida, bonus_escudo, bonus_poderfisico, bonus_poderhabilidade) VALUES (?, ?, ?, ?, ?);";

        // Tenta conectar ao banco de dados e preparar a execução do comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             // Prepara a instrução SQL e especifica que as chaves geradas serão retornadas
             PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Define os valores dos parâmetros na instrução SQL
            stmt.setString(1, lutador.getNome());
            stmt.setInt(2, lutador.getVida());
            stmt.setInt(3, lutador.getEscudo());
            stmt.setInt(4, lutador.getFisico());
            stmt.setInt(5, lutador.getHabilidade());
            // Executa a inserção no banco de dados
            stmt.executeUpdate();
            
            // Obtém as chaves geradas pelo banco (neste caso, o ID da raça inserida)
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                // Atribui o ID gerado à instância de Raca
            	lutador.setId(generatedKeys.getInt(1));
            }

            // Mensagem de confirmação de que a raça foi salva com sucesso
            System.out.println("Lutador " + lutador.getNome() + " salva com ID " + lutador.getId());

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }
    }

//    // Método para buscar todas as raças no banco de dados
//   public List<Arquetipo> buscarTodasRacas() {
//        // Lista para armazenar as raças encontradas
//        List<Arquetipo> racas = new ArrayList<>();
//        // Comando SQL para selecionar todas as raças
//        String sql = "SELECT * FROM arquetipo";
//
//        // Tenta conectar ao banco de dados e executar o comando SQL
//        try (Connection conexao = DatabaseConnection.conectar();
//             PreparedStatement stmt = conexao.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//
//            // Itera sobre os resultados e cria objetos Raca para cada linha
//            while (rs.next()) {
//            	Arquetipo arquetipo = new Arquetipo();
//            	arquetipo.setId(rs.getInt("id"));
//            	arquetipo.setNome(rs.getString("nome"));
//            	arquetipo.setBonusVida(rs.getInt("bonus_vida"));
//            	arquetipo.setBonusEscudo(rs.getInt("bonus_escudo"));
//            	arquetipo.setBonusFisico(rs.getInt("bonus_poderfisico"));
//            	arquetipo.setBonusHabilidade(rs.getInt("bonus_poderhabilidade"));
//                // Adiciona a raça à lista
//            	arquetipo.add(arquetipo);
//            }
//
//        } catch (SQLException e) {
//            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
//            e.printStackTrace();
//        }
//
//        // Retorna a lista de raças encontradas
//        return arquetipo;
//    }

    // Método para buscar uma raça específica pelo ID
    public Lutador buscarLutadorPorId(int id) {
        // Comando SQL para selecionar a raça pelo ID
        String sql = "SELECT * FROM lutador WHERE id = ?";
        Lutador lutador = null;

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Define o valor do parâmetro na instrução SQL
            stmt.setInt(1, id);
            // Executa a consulta e obtém os resultados
            try (ResultSet rs = stmt.executeQuery()) {
                // Verifica se a raça foi encontrada
                if (rs.next()) {
                	lutador = new Lutador(sql, id, id, id, id);
                	lutador.setId(rs.getInt("id"));
                	lutador.setNome(rs.getString("nome"));
                	lutador.setVida(rs.getInt("bonus_vida"));
                	lutador.setEscudo(rs.getInt("bonus_escudo"));
                	lutador.setFisico(rs.getInt("bonus_poderfisico"));
                	lutador.setHabilidade(rs.getInt("bonus_poderhabilidade"));
                }
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a raça encontrada ou null se não existir
        return lutador;
    }
}
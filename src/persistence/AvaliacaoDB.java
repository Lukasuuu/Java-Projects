
package persistence;

import exception.ConexaoBDException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Avaliacao;

/**
 * Classe AvaliacaoDB - responsável por todas as operações SQL
 * relacionadas à tabela "avaliacao".
 *
 * Esta classe apenas executa SQL.
 * As regras e o cálculo do ITU ficam na camada Service.
 *
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class AvaliacaoDB {

    /**
     * Insere uma nova avaliação na base de dados.
     *
     * A coluna data_avaliacao é gerada automaticamente pelo MySQL
     * (DEFAULT CURRENT_TIMESTAMP), por isso não é enviada no INSERT.
     *
     * @param avaliacao Objeto com bovinoId, ambienteId, valorItu e resultado.
     * @throws ConexaoBDException se ocorrer erro de SQL ou conexão.
     */
    public void inserir(Avaliacao avaliacao) throws ConexaoBDException {
        String sql = "INSERT INTO avaliacao (bovino_id, ambiente_id, valor_itu, resultado) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, avaliacao.getBovinoId());
            st.setInt(2, avaliacao.getAmbienteId());
            st.setDouble(3, avaliacao.getValorItu());
            st.setString(4, avaliacao.getResultado());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao inserir avaliação: " + e.getMessage(), e);
        }
    }

    /**
     * Lista todas as avaliações, já com o nome do animal e o local do ambiente,
     * usando JOIN entre as tabelas avaliacao, bovino, animal e ambiente.
     *
     * Ordenado da avaliação mais recente para a mais antiga.
     *
     * @return Lista de objetos Avaliacao preenchidos.
     * @throws ConexaoBDException se ocorrer erro de SQL ou conexão.
     */
    public ArrayList<Avaliacao> listarTodos() throws ConexaoBDException {
        // JOIN para trazer nome do animal e local do ambiente numa só query
        String sql = "SELECT av.id, av.bovino_id, av.ambiente_id, "
                   + "       av.valor_itu, av.resultado, av.data_avaliacao, "
                   + "       a.nome AS nome_animal, "
                   + "       e.local AS local_ambiente "
                   + "FROM avaliacao av "
                   + "INNER JOIN bovino b  ON av.bovino_id  = b.id "
                   + "INNER JOIN animal a  ON b.animal_id   = a.id "
                   + "INNER JOIN ambiente e ON av.ambiente_id = e.id "
                   + "ORDER BY av.data_avaliacao DESC";

        ArrayList<Avaliacao> lista = new ArrayList<>();

        try (Connection con = Conexao.getConexao();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                // Ler cada campo do resultado SQL
                int id             = rs.getInt("id");
                int bovinoId       = rs.getInt("bovino_id");
                int ambienteId     = rs.getInt("ambiente_id");
                double valorItu    = rs.getDouble("valor_itu");
                String resultado   = rs.getString("resultado");
                String nomeAnimal  = rs.getString("nome_animal");
                String localAmb    = rs.getString("local_ambiente");

                // Converter TIMESTAMP do MySQL para LocalDateTime Java
                Timestamp ts = rs.getTimestamp("data_avaliacao");
                LocalDateTime data = (ts != null) ? ts.toLocalDateTime() : null;

                // Criar objeto e adicionar à lista
                lista.add(new Avaliacao(id, bovinoId, ambienteId,
                                        valorItu, resultado, data,
                                        nomeAnimal, localAmb));
            }

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao listar avaliações: " + e.getMessage(), e);
        }

        return lista;
    }
}
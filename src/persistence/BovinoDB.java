
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Bovino;
import exception.ConexaoBDException;

/**
 * Classe BovinoDB - responsável por todas as operações SQL
 * relacionadas à tabela "bovino".
 *
 * Faz JOIN com a tabela "animal" para trazer os dados completos
 * do bovino numa só consulta.
 *
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class BovinoDB {

    /**
     * Lista todos os bovinos registados, fazendo JOIN com a tabela animal
     * para trazer também o nome, peso e idade herdados.
     *
     * @return Lista de objetos Bovino completamente preenchidos.
     * @throws ConexaoBDException se ocorrer erro de SQL ou conexão.
     */
    public ArrayList<Bovino> listarTodos() throws ConexaoBDException {
        // JOIN necessário porque Bovino herda dados de Animal
        String sql = "SELECT b.id, b.animal_id, b.raca, b.linhagem, b.producao_leite, "
                   + "       a.nome, a.peso, a.idade "
                   + "FROM bovino b "
                   + "INNER JOIN animal a ON b.animal_id = a.id "
                   + "ORDER BY a.nome ASC";

        ArrayList<Bovino> lista = new ArrayList<>();

        try (Connection con = Conexao.getConexao();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Bovino b = new Bovino();
                b.setId(rs.getInt("id"));
                b.setAnimalId(rs.getInt("animal_id"));
                b.setNome(rs.getString("nome"));        // herdado de Animal
                b.setPeso(rs.getDouble("peso"));        // herdado de Animal
                b.setIdade(rs.getInt("idade"));         // herdado de Animal
                b.setRaca(rs.getString("raca"));
                b.setLinhagem(rs.getString("linhagem"));
                b.setProducaoLeite(rs.getDouble("producao_leite"));
                lista.add(b);
            }

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao listar bovinos: " + e.getMessage(), e);
        }

        return lista;
    }
}
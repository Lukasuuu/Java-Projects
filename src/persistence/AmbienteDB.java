package persistence;

import exception.ConexaoBDException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Ambiente;

/**
 * Classe AmbienteDB - Responsável pelas operações de acesso à base de dados
 * relacionadas com a entidade Ambiente.
 *
 * Funções principais:
 * Inserir um novo ambiente
 * Listar todos os ambientes
 * 
 * Esta classe contém apenas SQL (persistência).
 * Regras/validações devem ficar na camada Service.
 *
 * @author Lucas
 */
public class AmbienteDB {

    /**
     * Insere um novo registo de ambiente na base de dados.
     *
     * Observação: a coluna data_registo pode ser gerada automaticamente pelo MySQL
     * (DEFAULT CURRENT_TIMESTAMP). Por isso, este INSERT não precisa enviar a data.
     *
     * @param ambiente Objeto Ambiente com temperatura, umidade e local.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public void inserir(Ambiente ambiente) throws ConexaoBDException {

        String sql = "INSERT INTO ambiente (temperatura, umidade, local) VALUES (?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setDouble(1, ambiente.getTemperatura());
            st.setDouble(2, ambiente.getUmidade());
            st.setString(3, ambiente.getLocal());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao inserir ambiente: " + e.getMessage(), e);
        }
    }

    /**
     * Lista todos os ambientes ordenados pela data de registo (mais recente primeiro).
     *
     * @return Lista de objetos Ambiente do banco de dados.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public ArrayList<Ambiente> listarTodos() throws ConexaoBDException {

        String sql = "SELECT id, temperatura, umidade, local, data_registo " +
                     "FROM ambiente ORDER BY data_registo DESC";

        ArrayList<Ambiente> lista = new ArrayList<>();

        try (Connection con = Conexao.getConexao();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                double temp = rs.getDouble("temperatura");
                double umid = rs.getDouble("umidade");
                String local = rs.getString("local");

                // Converter TIMESTAMP do MySQL para LocalDateTime (Java)
                Timestamp ts = rs.getTimestamp("data_registo");
                LocalDateTime data = (ts != null) ? ts.toLocalDateTime() : null;

                lista.add(new Ambiente(id, temp, umid, local, data));
            }

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao listar ambientes: " + e.getMessage(), e);
        }

        return lista;
    }
}
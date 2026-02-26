
package persistence;

import model.Ambiente;
import exception.ConexaoBDException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe AmbienteDB - Responsável pelas operações de acesso à base de dados
 * relacionadas com a entidade Ambiente.
 * Realiza inserções e listagens da tabela 'ambiente'.
 * 
 * @author Lucas
 */
public class AmbienteDB {

    /**
     * Insere um novo registo de ambiente na base de dados.
     * 
     * @param ambiente Objeto Ambiente com os dados a serem inseridos.
     * @return true se a inserção for bem-sucedida.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public boolean inserir(Ambiente ambiente) throws ConexaoBDException, Exception {
        String sql = "INSERT INTO ambiente (temperatura, umidade, local, data_registo) VALUES (?, ?, ?, NOW())";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, ambiente.getTemperatura());
            ps.setDouble(2, ambiente.getUmidade());
            ps.setString(3, ambiente.getLocal());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao inserir ambiente: " + e.getMessage(), e);
        }
    }

    /**
     * Retorna todos os registos da tabela 'ambiente', ordenados por data decrescente.
     * 
     * @return Lista de objetos Ambiente.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public ArrayList<Ambiente> listarTodos() throws ConexaoBDException, Exception {
        ArrayList<Ambiente> lista = new ArrayList<>();
        String sql = "SELECT * FROM ambiente ORDER BY data_registo DESC";

        try (Connection con = Conexao.getConexao();
             Statement st = con.createStatement();
             ResultSet resultado = st.executeQuery(sql)) {

            while (resultado.next()) {
                Ambiente a = new Ambiente(
                    resultado.getInt("id"),
                    resultado.getDouble("temperatura"),
                    resultado.getDouble("umidade"),
                    resultado.getString("local"),
                    resultado.getString("data_registo")
                );
                lista.add(a);
            }

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao listar ambientes: " + e.getMessage(), e);
        }

        return lista;
    }
}

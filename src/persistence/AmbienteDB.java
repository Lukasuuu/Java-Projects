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
 * Funções principais: Inserir um novo ambiente Listar todos os ambientes
 *
 * Esta classe contém apenas SQL (persistência). Regras/validações devem ficar
 * na camada Service.
 *
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class AmbienteDB {

    /**
     * Insere um novo registo de ambiente na base de dados.
     *
     * Observação: a coluna data_registo pode ser gerada automaticamente pelo
     * MySQL (DEFAULT CURRENT_TIMESTAMP). Por isso, este INSERT não precisa
     * enviar a data.
     *
     * @param ambiente Objeto Ambiente com temperatura, umidade e local.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public void inserir(Ambiente ambiente) throws ConexaoBDException {

        String sql = "INSERT INTO ambiente (temperatura, umidade, local) VALUES (?, ?, ?)";

        try ( Connection con = Conexao.getConexao();  PreparedStatement st = con.prepareStatement(sql)) {

            st.setDouble(1, ambiente.getTemperatura());
            st.setDouble(2, ambiente.getUmidade());
            st.setString(3, ambiente.getLocal());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao inserir ambiente: " + e.getMessage(), e);
        }
    }

    /**
     * Lista todos os ambientes ordenados pela data de registo (mais recente
     * primeiro).
     *
     * @return Lista de objetos Ambiente do banco de dados.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public ArrayList<Ambiente> listarTodos() throws ConexaoBDException {

        String sql = "SELECT id, temperatura, umidade, local, data_registo "
                + "FROM ambiente ORDER BY data_registo DESC";

        ArrayList<Ambiente> lista = new ArrayList<>();

        try ( Connection con = Conexao.getConexao();  PreparedStatement st = con.prepareStatement(sql);  ResultSet rs = st.executeQuery()) {

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

    /**
     * Apaga um ambiente da base de dados.
     *
     * IMPORTANTE: Todas as avaliações que usam este ambiente também serão
     * apagadas automaticamente (ON DELETE CASCADE).
     *
     * @param ambienteId ID do ambiente a apagar
     * @throws ConexaoBDException se houver erro de BD
     */
    public void apagar(int ambienteId) throws ConexaoBDException {
        String sql = "DELETE FROM ambiente WHERE id = ?";

        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            // Obter conexão
            conexao = Conexao.getConexao();

            if (conexao == null) {
                throw new ConexaoBDException("Não foi possível conectar à base de dados!");
            }

            // Preparar statement
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, ambienteId);

            // Executar
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new ConexaoBDException("Ambiente com ID " + ambienteId + " não foi encontrado!");
            }

            System.out.println("[AmbienteDB] Ambiente apagado. Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao apagar ambiente: " + e.getMessage(), e);

        } finally {
            // Fechar recursos
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}

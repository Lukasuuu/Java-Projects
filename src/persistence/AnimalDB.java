package persistence;

import model.Animal;
import model.Bovino;
import exception.ConexaoBDException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe AnimalDB - Responsável pelas operações de acesso à base de dados
 * relacionadas com a entidade Animal e suas subclasses, como Bovino.
 * Demonstra herança e polimorfismo no acesso aos dados.
 * 
 * Os métodos trabalham com objetos Bovino, mas retornam referências do tipo Animal.
 * Isso permite flexibilidade e reutilização de código.
 * 
 * @author Lucas
 */
public class AnimalDB {

    /**
     * Insere um novo bovino na base de dados.
     * 
     * @param bovino Objeto Bovino a ser inserido.
     * @return true se a inserção for bem-sucedida.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public boolean inserir(Bovino bovino) throws ConexaoBDException {
        String sql = "INSERT INTO animal (nome, peso, idade, raca, linhagem, producao_leite) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, bovino.getNome());
            st.setDouble(2, bovino.getPeso());
            st.setInt(3, bovino.getIdade());
            st.setString(4, bovino.getRaca());
            st.setString(5, bovino.getLinhagem());
            st.setDouble(6, bovino.getProducaoLeite());

            st.executeUpdate();
            System.out.println("Bovino inserido com sucesso!");
            return true;

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao inserir bovino: " + e.getMessage(), e);
        } catch (Exception ex) {
            Logger.getLogger(AnimalDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Lista todos os bovinos da base de dados.
     * 
     * @return Lista de animais (objetos Bovino como Animal).
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public ArrayList<Animal> listarTodos() throws ConexaoBDException {
        ArrayList<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM animal ORDER BY nome";

        try (Connection con = Conexao.getConexao();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Bovino bovino = new Bovino(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("peso"),
                    rs.getInt("idade"),
                    rs.getString("raca"),
                    rs.getString("linhagem"),
                    rs.getDouble("producao_leite")
                );
                lista.add(bovino);
            }

            System.out.println("Listados " + lista.size() + " bovinos");

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao listar bovinos: " + e.getMessage(), e);
        } catch (Exception ex) {
            Logger.getLogger(AnimalDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    /**
     * Busca um bovino pelo seu ID.
     * 
     * @param id ID do bovino.
     * @return Objeto Bovino correspondente ou null se não encontrado.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public Bovino buscarPorId(int id) throws ConexaoBDException {
        String sql = "SELECT * FROM animal WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Bovino(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("peso"),
                    rs.getInt("idade"),
                    rs.getString("raca"),
                    rs.getString("linhagem"),
                    rs.getDouble("producao_leite")
                );
            }

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao buscar bovino: " + e.getMessage(), e);
        } catch (Exception ex) {
            Logger.getLogger(AnimalDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Atualiza os dados de um bovino existente.
     * 
     * @param bovino Objeto Bovino com os dados atualizados.
     * @return true se a atualização for bem-sucedida.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public boolean atualizar(Bovino bovino) throws ConexaoBDException {
        String sql = "UPDATE animal SET nome=?, peso=?, idade=?, raca=?, linhagem=?, producao_leite=? " +
                     "WHERE id=?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bovino.getNome());
            ps.setDouble(2, bovino.getPeso());
            ps.setInt(3, bovino.getIdade());
            ps.setString(4, bovino.getRaca());
            ps.setString(5, bovino.getLinhagem());
            ps.setDouble(6, bovino.getProducaoLeite());
            ps.setInt(7, bovino.getId());

            ps.executeUpdate();
            System.out.println("Bovino atualizado!");
            return true;

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao atualizar bovino: " + e.getMessage(), e);
        } catch (Exception ex) {
            Logger.getLogger(AnimalDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Apaga um bovino da base de dados pelo ID.
     * 
     * @param id ID do bovino a ser removido.
     * @return true se a remoção for bem-sucedida.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public boolean apagar(int id) throws ConexaoBDException, Exception {
        String sql = "DELETE FROM animal WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Bovino apagado!");
            return true;

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao apagar bovino: " + e.getMessage(), e);
        }
    }
}
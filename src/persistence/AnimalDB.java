package persistence;

import exception.ConexaoBDException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Animal;
import model.Bovino;

/**
 * Classe AnimalDB - Acesso à base de dados para registo e consulta de animais do tipo bovino.
 *
 * <p><b>Schema utilizado (novo):</b></p>
 * <ul>
 *   <li><b>animal</b> (id, nome, peso, idade)</li>
 *   <li><b>bovino</b> (id, animal_id, raca, linhagem, producao_leite)</li>
 *   <li><b>vw_bovinos_completos</b>: view que junta animal + bovino (ideal para JTable)</li>
 * </ul>
 *
 * <p><b>Objetivo:</b> manter o código simples e fácil de apresentar para um aluno iniciante.</p>
 *
 * @author Lucas
 */
public class AnimalDB {

    /**
     * Regista um bovino completo (Animal + Bovino) usando transação.
     *
     * <p>Passos:</p>
     * <ol>
     *   <li>Insere na tabela <b>animal</b></li>
     *   <li>Obtém o ID gerado</li>
     *   <li>Insere na tabela <b>bovino</b> usando esse ID como animal_id</li>
     * </ol>
     *
     * @param nome Nome do animal.
     * @param peso Peso do animal (kg). Deve ser > 0.
     * @param idade Idade do animal (meses). Deve ser >= 0.
     * @param raca Raça do bovino.
     * @param linhagem Linhagem do bovino (LEITE, CARNE, DUPLA_APTIDAO).
     * @param producaoLeite Produção de leite (litros/dia). Deve ser >= 0.
     * @throws ConexaoBDException Se ocorrer erro de SQL ou ligação.
     */
    public void registarBovino(String nome, double peso, int idade,
                               String raca, String linhagem, double producaoLeite) throws ConexaoBDException {

        // SQL de inserção na tabela animal (apenas dados comuns)
        final String sqlAnimal = "INSERT INTO animal (nome, peso, idade) VALUES (?, ?, ?)";

        // SQL de inserção na tabela bovino (dados específicos + FK animal_id)
        final String sqlBovino = "INSERT INTO bovino (animal_id, raca, linhagem, producao_leite) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConexao()) {

            // Inicia transação: garante que os 2 inserts acontecem juntos
            con.setAutoCommit(false);

            int animalIdGerado;

            // 1) Inserir animal e obter o ID gerado
            try (PreparedStatement psAnimal = con.prepareStatement(sqlAnimal, Statement.RETURN_GENERATED_KEYS)) {

                psAnimal.setString(1, nome);
                psAnimal.setDouble(2, peso);
                psAnimal.setInt(3, idade);

                psAnimal.executeUpdate();

                // Pega o ID gerado automaticamente pelo MySQL
                try (ResultSet keys = psAnimal.getGeneratedKeys()) {
                    if (keys.next()) {
                        animalIdGerado = keys.getInt(1);
                    } else {
                        // Se não vier ID, não dá para inserir o bovino
                        throw new ConexaoBDException("Não foi possível obter o ID gerado do animal.");
                    }
                }
            }

            // 2) Inserir bovino com o animal_id obtido
            try (PreparedStatement psBovino = con.prepareStatement(sqlBovino)) {

                psBovino.setInt(1, animalIdGerado);
                psBovino.setString(2, raca);
                psBovino.setString(3, linhagem);
                psBovino.setDouble(4, producaoLeite);

                psBovino.executeUpdate();
            }

            // Confirma (commit) a transação
            con.commit();

        } catch (SQLException e) {
            // Erro de SQL vira ConexaoBDException para a camada de apresentação tratar
            throw new ConexaoBDException("Erro ao registar bovino: " + e.getMessage(), e);
        }
    }

    /**
     * Insere um Animal na base de dados e devolve o ID gerado.
     *
     * <p>Este método é útil se você quiser inserir o Animal primeiro, e depois,
     * em outro ponto, inserir o Bovino.</p>
     *
     * @param animal Objeto Animal com (nome, peso, idade).
     * @return ID gerado na tabela animal.
     * @throws ConexaoBDException Se ocorrer erro de SQL ou ligação.
     */
    public int inserirAnimal(Animal animal) throws ConexaoBDException {

        final String sql = "INSERT INTO animal (nome, peso, idade) VALUES (?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, animal.getNome());
            ps.setDouble(2, animal.getPeso());
            ps.setInt(3, animal.getIdade());

            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }

            throw new ConexaoBDException("Não foi possível obter o ID gerado do animal.");

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao inserir animal: " + e.getMessage(), e);
        }
    }

    /**
     * Insere um Bovino na tabela bovino.
     *
     * <p><b>ATENÇÃO:</b> o animal_id (FK) precisa existir na tabela animal.</p>
     *
     * @param bovino Objeto Bovino contendo animalId, raça, linhagem e produção.
     * @throws ConexaoBDException Se ocorrer erro de SQL ou ligação.
     */
    public void inserirBovino(Bovino bovino) throws ConexaoBDException {

        final String sql = "INSERT INTO bovino (animal_id, raca, linhagem, producao_leite) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bovino.getAnimalId());
            ps.setString(2, bovino.getRaca());
            ps.setString(3, bovino.getLinhagem());
            ps.setDouble(4, bovino.getProducaoLeite());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao inserir bovino: " + e.getMessage(), e);
        }
    }

    /**
     * Lista bovinos completos usando a view vw_bovinos_completos.
     *
     * <p>É o método mais prático para preencher a JTable,
     * porque a view já traz dados do Animal + dados do Bovino.</p>
     *
     * @return Lista de BovinoCompleto (pronto para interface).
     * @throws ConexaoBDException Se ocorrer erro de SQL ou ligação.
     */
    public ArrayList<Bovino> listarBovinos() throws ConexaoBDException {

        final String sql =
                "SELECT bovino_id, animal_id, nome, peso, idade, raca, linhagem, producao_leite " +
                "FROM vw_bovinos_completos ORDER BY bovino_id";

        ArrayList<Bovino> lista = new ArrayList<>();

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Bovino b = new Bovino();

                b.setId(rs.getInt("bovino_id"));
                b.setAnimalId(rs.getInt("animal_id"));
                b.setNome(rs.getString("nome"));
                b.setPeso(rs.getDouble("peso"));
                b.setIdade(rs.getInt("idade"));
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
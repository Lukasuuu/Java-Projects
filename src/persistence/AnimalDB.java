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
 * DAO (Data Access Object) para gestão de animais na base de dados.
 * 
 * <p>Responsável por todas as operações CRUD (Create, Read, Update, Delete)
 * relacionadas à tabela animal e bovino.</p>
 * 
 * <p>Utiliza JDBC para comunicação com MySQL. As operações de INSERT
 * e UPDATE utilizam transações para garantir consistência entre as
 * tabelas animal (PAI) e bovino (FILHO).</p>
 * 
 * Schema utilizado:
 *
 * Animal (id, nome, peso, idade)
 * Bovino (id, animal_id, raca, linhagem, producao_leite)
 * vw_bovinos_completos: junta animal + bovino
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 * @see Bovino
 * @see Conexao
 */
public class AnimalDB {

    /**
     * Regista um bovino completo (Animal + Bovino) usando transação.
     *
     * Passos:
     * Insere na tabela Animal
     * Obtém o ID gerado
     * Insere na tabela Bovino usando esse ID como animal_id
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

        try ( Connection con = Conexao.getConexao()) {

            // Inicia transação: garante que os 2 inserts acontecem juntos
            con.setAutoCommit(false);

            int animalIdGerado;

            // 1) Inserir animal e obter o ID gerado
            try ( PreparedStatement psAnimal = con.prepareStatement(sqlAnimal, Statement.RETURN_GENERATED_KEYS)) {

                psAnimal.setString(1, nome);
                psAnimal.setDouble(2, peso);
                psAnimal.setInt(3, idade);

                psAnimal.executeUpdate();

                // Pega o ID gerado automaticamente pelo MySQL
                try ( ResultSet keys = psAnimal.getGeneratedKeys()) {
                    if (keys.next()) {
                        animalIdGerado = keys.getInt(1);
                    } else {
                        // Se não vier ID, não dá para inserir o bovino
                        throw new ConexaoBDException("Não foi possível obter o ID gerado do animal.");
                    }
                }
            }

            // 2) Inserir bovino com o animal_id obtido
            try ( PreparedStatement psBovino = con.prepareStatement(sqlBovino)) {

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
     * Este método é útil se você quiser inserir o Animal primeiro, e depois, em
     * outro ponto, inserir o Bovino.
     *
     * @param animal Objeto Animal com (nome, peso, idade).
     * @return ID gerado na tabela animal.
     * @throws ConexaoBDException Se ocorrer erro de SQL ou ligação.
     */
    public int inserirAnimal(Animal animal) throws ConexaoBDException {

        final String sql = "INSERT INTO animal (nome, peso, idade) VALUES (?, ?, ?)";

        try ( Connection con = Conexao.getConexao();  
              PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, animal.getNome());
            ps.setDouble(2, animal.getPeso());
            ps.setInt(3, animal.getIdade());

            ps.executeUpdate();

            try ( ResultSet keys = ps.getGeneratedKeys()) {
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
     * @param bovino Objeto Bovino contendo animalId, raça, linhagem e produção.
     * @throws ConexaoBDException Se ocorrer erro de SQL ou ligação.
     */
    public void inserirBovino(Bovino bovino) throws ConexaoBDException {

        final String sql = "INSERT INTO bovino (animal_id, raca, linhagem, producao_leite) VALUES (?, ?, ?, ?)";

        try ( Connection con = Conexao.getConexao();  
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
     * É o método mais prático para preencher a JTable, porque a view já traz
     * dados do Animal + dados do Bovino.
     *
     * @return Lista de BovinoCompleto (pronto para interface).
     * @throws ConexaoBDException Se ocorrer erro de SQL ou ligação.
     */
    public ArrayList<Bovino> listarBovinos() throws ConexaoBDException {

        final String sql
                = "SELECT bovino_id, animal_id, nome, peso, idade, raca, linhagem, producao_leite "
                + "FROM vw_bovinos_completos ORDER BY bovino_id";

        ArrayList<Bovino> lista = new ArrayList<>();

        try ( Connection con = Conexao.getConexao();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {

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

    /**
     * Apaga um animal (bovino) da base de dados.
     *
     * bovino → apaga animal automaticamente (CASCADE)l
     *
     * @param animalId ID do animal a apagar
     * @throws ConexaoBDException se houver erro de BD
     */
    public void apagar(int animalId) {
        // SQL para apagar da tabela bovino
        String sql = "DELETE FROM bovino WHERE animal_id = ?";

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
            stmt.setInt(1, animalId);

            // Executar
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new ConexaoBDException("Animal com ID " + animalId + " não foi encontrado!");
            }

            System.out.println("[AnimalDB] Animal apagado. Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao apagar animal: " + e.getMessage(), e);

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

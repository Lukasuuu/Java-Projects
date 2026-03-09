package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import exception.ConexaoBDException;

/**
 * Classe Conexao - Responsável por estabelecer ligação com o banco de dados MySQL.
 * Fornece métodos utilitários para obter e testar conexões.
 * 
 * Como funciona:
 * - Armazena os dados do servidor, base de dados, utilizador e senha.
 * - O método getConexao() retorna uma Connection ativa.
 * 
 * <p>Configuração:
 * <ul>
 *   <li>Host: 62.28.39.135</li>
 *   <li>Porta: 3306</li>
 *   <li>Base de dados: efa0125_08_projeto_java</li>
 *   <li>Utilizador: efa0125_08</li>
 * </ul>
 * </p>
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class Conexao {

    // ===== DADOS DA BASE DE DADOS =====
    private static final String SERVIDOR = "62.28.39.135";
    private static final String BASE_DADOS = "efa0125_08_projeto_java";
    private static final String UTILIZADOR = "efa0125";
    private static final String SENHA = "123.Abc";

    // URL de conexão JDBC
    private static final String URL = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASE_DADOS;

    /**
     * Estabelece e retorna uma conexão com o banco de dados MySQL.
     * 
     * @return Objeto Connection ativo.
     * @throws ConexaoBDException se ocorrer erro ao conectar.
     */
    public static Connection getConexao() throws ConexaoBDException {
        try {
            Connection conexao = DriverManager.getConnection(URL, UTILIZADOR, SENHA);
            System.out.println("Ligado ao MySQL com sucesso!");
            return conexao;
        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao conectar ao MySQL: " + e.getMessage(), e);
        }
    }

    /**
     * Método utilitário para testar a conexão com o banco de dados.Exibe mensagens no console com o resultado do teste.
     * @throws SQLException  se ocorrer erro ao tentar estabelecer a conexão com a base de dados
     */
    public static void testarConexao() throws SQLException {
        System.out.println("========================================");
        System.out.println("  TESTE DE CONEXÃO AO MYSQL");
        System.out.println("========================================");
        System.out.println("Servidor: " + SERVIDOR);
        System.out.println("Base de Dados: " + BASE_DADOS);
        System.out.println("Utilizador: " + UTILIZADOR);
        System.out.println("========================================");

        try (Connection conexao = getConexao()) {
            if (conexao != null) {
                System.out.println("SUCESSO! A conexao esta a funcionar!");
            }
        } catch (ConexaoBDException e) {
            System.out.println("ERRO! Verifica:");
            System.out.println("  1. O servidor está ligado?");
            System.out.println("  2. A base de dados existe?");
            System.out.println("  3. O utilizador e senha estao corretos?");
            System.out.println("  4. O JAR do MySQL esta na pasta lib/?");
            System.out.println("Detalhes: " + e.getMessage());
        }

        System.out.println("========================================");
    }

   /**
     * Método main para executar o teste de conexão diretamente.
     * 
     * @param args Argumentos da linha de comando.
     * @throws SQLException se ocorrer erro ao tentar estabelecer a conexão com a base de dados
     */
    public static void main(String[] args) throws SQLException {
        testarConexao();
    }
}
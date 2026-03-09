package persistence;
import model.Animal;

import java.sql.*;

/**
 * Classe DBWorker - Executa comandos SQL diretamente no banco de dados.
 * Permite executar consultas e atualizações genéricas.
 * Também possui um método específico para guardar um Animal.
 * 
 * OBS: Esta classe é útil para testes rápidos ou comandos diretos.
 * Para uso em produção, prefira DAOs específicos como AnimalDB.
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class DBWorker {

    private final String servidor = "62.28.39.135";
    private final String baseDados = "efa0125_08_projeto_java";
    private final String user = "efa0125";
    private final String password = "123.Abc";
    private final String stringConnection = "jdbc:mysql://" + servidor + ":3306/" + baseDados;

    private Connection con;
    private Statement st;

    /**
     * Construtor - Estabelece conexão com o banco de dados.
     */
    public DBWorker() {
        try {
            con = DriverManager.getConnection(stringConnection, user, password);
            st = con.createStatement();
            System.out.println("Conexão estabelecida com sucesso.");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
        }
    }

    /**
     * Executa uma consulta SQL (SELECT).
     * 
     * @param sql Comando SQL do tipo SELECT.
     * @return ResultSet com os resultados da consulta.
     * @throws SQLException se ocorrer erro na execução.
     */
    public ResultSet getConsulta(String sql) throws SQLException {
        return st.executeQuery(sql);
    }

    /**
     * Executa um comando SQL de modificação (INSERT, UPDATE, DELETE).
     * 
     * @param sql Comando SQL a ser executado.
     * @return Número de linhas afetadas.
     * @throws SQLException se ocorrer erro na execução.
     */
    public int setDados(String sql) throws SQLException {
        return st.executeUpdate(sql);
    }

    /**
     * Insere um animal na base de dados com apenas o nome.
     * Este método é apenas ilustrativo.
     * 
     * @param animal Objeto Animal com o nome preenchido.
     * @return true se a inserção for bem-sucedida.
     * @throws SQLException se ocorrer erro na execução.
     */
    public boolean guardar(Animal animal) throws SQLException {
        String sql = "INSERT INTO animal (nome) VALUES ('" + animal.getNome() + "')";
        return setDados(sql) > 0;
    }

    /**
     * Fecha a conexão com o banco de dados.
     */
    public void fechar() {
        try {
            if (st != null) {
                st.close();
                    }
            if (con != null){
                con.close();
            } 
            System.out.println("Conexão encerrada.");
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexão: " + ex.getMessage());
        }
    }
}
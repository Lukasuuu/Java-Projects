package persistence;

import model.Usuario;
import exception.ConexaoBDException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe UsuarioDB - Responsável pelas operações de acesso à base de dados
 * relacionadas com a entidade Usuario.
 * Permite autenticar utilizadores com base no nome de utilizador e senha.
 * 
 * @author Lucas
 */
public class UsuarioDB {

    /**
     * Realiza o login de um utilizador com base no nome de utilizador e senha.
     * 
     * @param nomeUtilizador Nome de utilizador (login).
     * @param senha Senha correspondente.
     * @return Objeto Usuario se as credenciais forem válidas, ou null se inválidas.
     * @throws IllegalArgumentException se os campos estiverem vazios.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public Usuario fazerLogin(String nomeUtilizador, String senha) throws ConexaoBDException {
        if (nomeUtilizador == null || nomeUtilizador.isBlank() ||
            senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("Preencha todos os campos obrigatórios.");
        }

        String sql = "SELECT * FROM usuario WHERE nome_utilizador = ? AND senha = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nomeUtilizador);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome_utilizador"),
                    rs.getString("senha"),
                    rs.getString("nome_completo"),
                    rs.getBoolean("e_admin")
                );
            } else {
                System.out.println("Utilizador ou senha incorretos.");
            }

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao aceder à base de dados: " + e.getMessage(), e);
        }

        return null;
    }
}
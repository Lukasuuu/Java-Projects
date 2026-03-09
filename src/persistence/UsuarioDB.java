package persistence;

import model.Usuario;
import exception.ConexaoBDException;
import exception.DadosInvalidosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe UsuarioDB - Responsável pelas operações de acesso à base de dados
 * relacionadas com a entidade Usuario.
 * Permite autenticar utilizadores com base no username e password.
 *
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class UsuarioDB {

    /**
     * Realiza o login de um utilizador com base no username e password.
     *
     * @param username Username do utilizador (login).
     * @param password Password correspondente.
     * @return Objeto Usuario se as credenciais forem válidas, ou null se inválidas.
     * @throws DadosInvalidosException se os campos estiverem vazios.
     * @throws ConexaoBDException se ocorrer erro de conexão ou SQL.
     */
    public Usuario fazerLogin(String username, String password) throws ConexaoBDException {
        if (username == null || username.isBlank() ||
            password == null || password.isBlank()) {
            throw new DadosInvalidosException("Preencha todos os campos obrigatórios.");
        }

        String sql = "SELECT id, username, password, is_admin FROM usuario " +
                     "WHERE username = ? AND password = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("is_admin")
                    );
                } 
                else {
                    System.out.println("Utilizador ou password incorretos.");
                }
            }

        } catch (SQLException e) {
            throw new ConexaoBDException("Erro ao aceder à base de dados: " + e.getMessage(), e);
        }

        return null;
    }
}
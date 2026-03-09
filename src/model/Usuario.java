package model;

/**
 * Classe Usuario - Representa um utilizador do sistema.
 * Versão simplificada para iniciantes:
 * - username (login)
 * - password (senha)
 * - isAdmin (se é administrador)
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class Usuario {

    private int id;
    private String username;
    private String password;
    private boolean isAdmin;

    /**
     * Construtor vazio (útil para frameworks/DAO).
     */
    public Usuario() {
    }

    /**
     * Construtor completo.
     *
     * @param id ID do utilizador na base de dados.
     * @param username Nome de utilizador (login).
     * @param password Senha do utilizador.
     * @param isAdmin Indica se o utilizador é administrador.
     */
    public Usuario(int id, String username, String password, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    /**
     * @return ID do utilizador.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id ID do utilizador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Username (login).
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username Username (login).
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Password (senha).
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password Password (senha).
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return true se for admin; false caso contrário.
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin Define se é admin.
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
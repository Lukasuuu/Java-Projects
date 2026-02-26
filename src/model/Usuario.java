package model;

/**
 * Classe Usuario - representa um utilizador do sistema.
 * Contém informações de login, nome completo e permissões de administrador.
 * Pode ser usada para autenticação e controle de acesso.
 * 
 * @author Lucas
 */
public class Usuario {

    /** ID único do utilizador */
    private int id;

    /** Nome de utilizador (login) */
    private String nomeUtilizador;

    /** Senha de acesso */
    private String senha;

    /** Nome completo do utilizador */
    private String nomeCompleto;

    /** Indica se o utilizador tem permissões de administrador */
    private boolean admin;

    /**
     * Construtor vazio.
     */
    public Usuario() {}

    /**
     * Construtor com parâmetros.
     * 
     * @param id ID do utilizador.
     * @param nomeUtilizador Nome de login.
     * @param senha Senha de acesso.
     * @param nomeCompleto Nome completo do utilizador.
     * @param admin true se for administrador, false caso contrário.
     */
    public Usuario(int id, String nomeUtilizador, String senha, String nomeCompleto, boolean admin) {
        this.id = id;
        this.nomeUtilizador = nomeUtilizador;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.admin = admin;
    }

    /**
     * Retorna o ID do utilizador.
     * @return ID numérico.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do utilizador.
     * @param id Valor numérico.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome de utilizador (login).
     * @return Nome de utilizador.
     */
    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    /**
     * Define o nome de utilizador (login).
     * @param nomeUtilizador Nome de login.
     */
    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    /**
     * Retorna a senha do utilizador.
     * @return Senha de acesso.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do utilizador.
     * @param senha Senha de acesso.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna o nome completo do utilizador.
     * @return Nome completo.
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     * Define o nome completo do utilizador.
     * @param nomeCompleto Nome completo.
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * Verifica se o utilizador é administrador.
     * @return true se for admin, false caso contrário.
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Define se o utilizador é administrador.
     * @param admin true para admin, false para utilizador comum.
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nomeUtilizador='" + nomeUtilizador + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", admin=" + admin +
                '}';
    }
}
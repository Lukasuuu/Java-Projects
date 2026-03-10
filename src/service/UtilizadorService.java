
package service;

import exception.ConexaoBDException;
import model.Utilizador;
import persistence.UtilizadorDB;

/**
  * Classe UsuarioService - Camada de serviço para regras de negócio do utilizador.
 * Objetivo:
 * Validar dados vindos da interface (Login)
 * Chamar a persistência (UsuarioDB)
 * Deixar a JFrame mais limpa
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class UtilizadorService {
    private final UtilizadorDB usuarioDB;
    
    /**
     * Construtor padrão.
     * Inicializa o acesso à camada de persistência.
     */
    public UtilizadorService() {
        this.usuarioDB = new UtilizadorDB();
    }
      /**
     * Autentica um utilizador (login).
     * Regras simples:
     * Não aceitar campos vazios
     * Se as credenciais estiverem erradas, retorna null
     * @param username Nome de utilizador (login).
     * @param password Senha.
     * @return Utilizador autenticado ou null se inválido.
     * @throws ConexaoBDException se houver erro na base de dados.
     */
    public Utilizador autenticar(String username, String password) throws ConexaoBDException {
        
        if(username == null || username.isBlank()){
            throw new ConexaoBDException("Informe o utilizador.");
        }
        if (password == null || password.isBlank()) {
            throw new ConexaoBDException("informe a senha");
        }
        
        // Chama a persistência dos dados
        return usuarioDB.fazerLogin(username.trim(), password);
    
    };
}

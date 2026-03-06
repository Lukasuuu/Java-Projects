/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import exception.ConexaoBDException;
import persistence.UsuarioDB;
import model.Usuario;

/**
  * Classe UsuarioService - Camada de serviço para regras de negócio do utilizador.
 * Objetivo:
 * Validar dados vindos da interface (Login)
 * Chamar a persistência (UsuarioDB)
 * Deixar a JFrame mais limpa
 * @author Lucas
 */
public class UsuarioService {
    private final UsuarioDB usuarioDB;
    
    /**
     * Construtor padrão.
     * Inicializa o acesso à camada de persistência.
     */
    public UsuarioService() {
        this.usuarioDB = new UsuarioDB();
    }
      /**
     * Autentica um utilizador (login).
     * Regras simples:
     * Não aceitar campos vazios
     * Se as credenciais estiverem erradas, retorna null
     * @param username Nome de utilizador (login).
     * @param password Senha.
     * @return Usuario autenticado ou null se inválido.
     * @throws ConexaoBDException se houver erro na base de dados.
     */
    public Usuario autenticar(String username, String password) throws ConexaoBDException {
        
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

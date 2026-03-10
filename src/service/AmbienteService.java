
package service;

import exception.ConexaoBDException;
import exception.DadosInvalidosException;
import java.util.ArrayList;
import model.Ambiente;
import persistence.AmbienteDB;


/**
 * Classe AmbienteService - Regras e validações do Ambiente.
 *
 * A interface Swing chama este service, e o service chama o AmbienteDB.
 *
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class AmbienteService {
    /** Objeto responsável por executar SQL no banco. */
    private final AmbienteDB ambienteDB;

    /**
     * Construtor padrão.
     */
    public AmbienteService() {
        this.ambienteDB = new AmbienteDB();
    }

    /**
     * Regista um ambiente após validações simples.
     *
     * @param temperatura Temperatura (°C).
     * @param umidade Umidade (%) deve estar entre 0 e 100.
     * @param local Local (obrigatório).
     * @throws DadosInvalidosException se algum dado for inválido.
     * @throws ConexaoBDException se ocorrer erro na base de dados.
     */
    public void registar(double temperatura, double umidade, String local) throws ConexaoBDException {

        if (local == null || local.isBlank()) {
            throw new DadosInvalidosException("O local é obrigatório.");
        }

        if (umidade < 0 || umidade > 100) {
            throw new DadosInvalidosException("A umidade deve estar entre 0 e 100.");
        }

        Ambiente ambiente = new Ambiente(temperatura, umidade, local.trim());
        ambienteDB.inserir(ambiente);
    }

    /**
     * Lista todos os ambientes para exibir na JTable.
     * @return lista completa de ambientes.
     * @throws ConexaoBDException se ocorrer erro na base de dados.
     */
    public ArrayList<Ambiente> listarTodos() throws ConexaoBDException {
        return ambienteDB.listarTodos();
    }
    
    
    /**
 * Apaga um ambiente da base de dados.
 * 
 * @param ambienteId ID do ambiente a apagar
 * @throws DadosInvalidosException se o ID for inválido
 * @throws ConexaoBDException se houver erro de BD
 */
    public void apagar(int ambienteId)throws DadosInvalidosException {
         // Validação: ID deve ser positivo
    if (ambienteId <= 0) {
        throw new DadosInvalidosException("ID do ambiente deve ser maior que zero!");
    }
    
    // Chamar o DAO para apagar
    AmbienteDB ambientedb = new AmbienteDB();
    ambienteDB.apagar(ambienteId);
    
    System.out.println("[AmbienteService] Ambiente com ID " + ambienteId + " apagado.");
    }
}

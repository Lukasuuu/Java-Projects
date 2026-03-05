package service;

import exception.ConexaoBDException;
import exception.DadosInvalidosException;
import exception.ProjetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ambiente;
import persistence.AmbienteDB;

/**
 * Classe AmbienteService - Regras e validações do Ambiente.
 *
 * A interface Swing chama este service, e o service chama o AmbienteDB.
 *
 * @author Lucas
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
}

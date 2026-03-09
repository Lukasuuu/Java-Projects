package service;

import exception.ConexaoBDException;
import java.util.ArrayList;
import model.Bovino;
import persistence.BovinoDB;

/**
 * Classe BovinoService - regras de negócio relacionadas aos bovinos.
 *
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class BovinoService {

    /** Objeto responsável por executar SQL na tabela bovino. */
    private final BovinoDB bovinoDB;

    /**
     * Construtor padrão.
     */
    public BovinoService() {
        this.bovinoDB = new BovinoDB();
    }

    /**
     * Lista todos os bovinos registados na base de dados.
     *
     * @return Lista de bovinos.
     * @throws ConexaoBDException se ocorrer erro na base de dados.
     */
    public ArrayList<Bovino> listarTodos() throws ConexaoBDException {
        return bovinoDB.listarTodos();
    }
}
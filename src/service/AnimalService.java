/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import exception.ConexaoBDException;
import exception.DadosInvalidosException;
import java.util.ArrayList;
import model.Bovino;
import persistence.AnimalDB;

/**
 * Classe AnimalService - Camada de serviço (regras de negócio).
 *
 * <p>
 * Responsável por:</p>
 * <ul>
 * <li>Validar dados vindos da interface</li>
 * <li>Chamar a camada de persistência (AnimalDB)</li>
 * <li>Deixar a JFrame mais limpa e organizada</li>
 * </ul>
 *
 * @author Lucas Goncalves
 * @version 1.0
 * @since 2026-03-06
 * @see AnimalDB
 * @see Bovino
 */
public class AnimalService {

    private final AnimalDB animalDB;

    /**
     * Construtor padrão. 
     * Inicializa o acesso à camada de persistência.
     * Regista um novo bovino na base de dados.
     */
    public AnimalService() {
        this.animalDB = new AnimalDB();
    }

    /**
     * Regista um bovino (Animal + Bovino) na base de dados.
     * <p>Valida todos os campos antes de persistir. Utiliza transação
     * para garantir consistência entre as tabelas animal e bovino.</p>
     *
     * @param nome Nome do animal.
     * @param peso Peso em kg (> 0).
     * @param idade Idade em meses (>= 0).
     * @param raca Raça do bovino.
     * @param linhagem Linhagem do bovino.
     * @param producaoLeite Produção de leite (>= 0).
     * @throws IllegalArgumentException se algum dado for inválido.
     * @throws ConexaoBDException se ocorrer erro na base de dados.
     */
    public void registarBovino(String nome, double peso, int idade,
            String raca, String linhagem, double producaoLeite) throws ConexaoBDException {

        // ===== Validações simples (iniciante) =====
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        if (raca == null || raca.isBlank()) {
            throw new IllegalArgumentException("A raça é obrigatória.");
        }
        if (linhagem == null || linhagem.isBlank()) {
            throw new IllegalArgumentException("A linhagem é obrigatória.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que 0.");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }
        if (producaoLeite < 0) {
            throw new IllegalArgumentException("A produção de leite não pode ser negativa.");
        }

        // Chama a persistência (DB)
        animalDB.registarBovino(nome, peso, idade, raca, linhagem, producaoLeite);
    }

    /**
     * Lista todos os bovinos para exibir na JTable.
     *
     * @return Lista de bovinos.
     * @throws ConexaoBDException se ocorrer erro na base de dados.
     */
    public ArrayList<Bovino> listarBovinos() throws ConexaoBDException {
        return animalDB.listarBovinos();
    }

    /**
     * Apaga um animal da base de dados.
     * 
     * <p><strong>ATENÇÃO:</strong> Esta operação é irreversível.
     * Todas as avaliações associadas também serão apagadas.</p>
     * 
     * @param animalId ID do animal a apagar
     * @throws DadosInvalidosException se o ID for inválido
     * @throws ConexaoBDException se houver erro de conexão
     */
    public void apagar(int animalId) throws DadosInvalidosException {

        // Validação: ID deve ser positivo
        if (animalId <= 0) {
            throw new DadosInvalidosException("ID do animal deve ser maior que zero!");
        }

        // Chamar o DAO para apagar
        AnimalDB animaldb = new AnimalDB();
        animalDB.apagar(animalId);

        System.out.println("Animal com ID " + animalId + " apagado.");
    }
}

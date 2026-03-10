
package model;

import java.time.LocalDateTime;

/**
 * Representa uma avaliação de conforto térmico de um bovino.
 * 
 * <p>Contém o resultado do cálculo do ITU (Índice de Temperatura
 * e Umidade) para um bovino específico em condições ambientais
 * específicas.</p>
 * 
 * <p>Fórmula do ITU:
 * <pre>
 * ITU = 0.8 × T + (UR/100) × (T - 14.4) + 46.4
 * </pre>
 * Onde:
 * <ul>
 *   <li>T = temperatura em °C</li>
 *   <li>UR = umidade relativa em %</li>
 * </ul>
 * </p>
 * 
 * <p>Classificação do resultado:
 * <ul>
 *   <li>ITU &lt; 72: CONFORTO</li>
 *   <li>72 ≤ ITU &lt; 79: ALERTA</li>
 *   <li>ITU ≥ 79: ESTRESSE</li>
 * </ul>
 * </p>
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 * @see Bovino
 * @see Ambiente
 */
public class Avaliacao {

    /**
     * Identificador único da avaliação na base de dados.
     */
    private int id;

    /**
     * ID do bovino avaliado.
     */
    private int bovinoId;

    /**
     * ID do ambiente usado na avaliação.
     */
    private int ambienteId;

    /**
     * Valor calculado do ITU.
     */
    private double valorItu;

    /**
     * Resultado textual da avaliação. Valores possíveis: "CONFORTO", "ALERTA",
     * "ESTRESSE"
     */
    private String resultado;

    /**
     * Data e hora em que a avaliação foi realizada.
     */
    private LocalDateTime dataAvaliacao;

    // ── Campos extras para exibir na tabela ──────────────────────────────────
    /**
     * Nome do bovino (vem do JOIN com animal).
     */
    private String nomeAnimal;

    /**
     * Local do ambiente (vem do JOIN com ambiente).
     */
    private String localAmbiente;

    // ── Construtores ─────────────────────────────────────────────────────────
    /**
     * Construtor vazio (necessário em alguns casos).
     */
    public Avaliacao() {
    }

    /**
     *
     * @param bovinoId Id referente ao Bovino
     * @param ambienteId Id referente ao Ambiente
     * @param valorItu parametro do valorItu
     * @param resultado parametro referente ao resultado
     */
    public Avaliacao(int bovinoId, int ambienteId, double valorItu, String resultado) {
        this.bovinoId = bovinoId;
        this.ambienteId = ambienteId;
        this.valorItu = valorItu;
        this.resultado = resultado;
    }

    /**
 * Cria uma avaliação completa.
 *
 * @param id identificador da avaliação
 * @param bovinoId identificador do bovino
 * @param ambienteId identificador do ambiente
 * @param valorItu valor do índice de temperatura e umidade
 * @param resultado classificação da avaliação
 * @param dataAvaliacao data e hora da avaliação
 * @param nomeAnimal nome do animal avaliado
 * @param localAmbiente local onde a avaliação foi realizada
 */
    public Avaliacao(int id, int bovinoId, int ambienteId, double valorItu,
            String resultado, LocalDateTime dataAvaliacao,
            String nomeAnimal, String localAmbiente) {
        this.id = id;
        this.bovinoId = bovinoId;
        this.ambienteId = ambienteId;
        this.valorItu = valorItu;
        this.resultado = resultado;
        this.dataAvaliacao = dataAvaliacao;
        this.nomeAnimal = nomeAnimal;
        this.localAmbiente = localAmbiente;
    }

    // ── Getters e Setters ─────────────────────────────────────────────────────
    /**
     * @return id Retorna ID da avaliação.
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id ID da avaliação.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return bovinoId Retorna ID do bovino avaliado.
     */
    public int getBovinoId() {
        return bovinoId;
    }

    /**
     * 
     * @param bovinoId ID do bovino.
     */
    public void setBovinoId(int bovinoId) {
        this.bovinoId = bovinoId;
    }

    /**
     * 
     * @return ambienteId Retorna o ID do ambiente utilizado.
     */
    public int getAmbienteId() {
        return ambienteId;
    }

    /**
     * 
     * @param ambienteId ID do ambiente
     */
    public void setAmbienteId(int ambienteId) {
        this.ambienteId = ambienteId;
    }

    /**
     * 
     * @return valorItu Valor numérico do ITU.
     */
    public double getValorItu() {
        return valorItu;
    }

    /**
     * 
     * @param valorItu Valor do ITU.
     */
    public void setValorItu(double valorItu) {
        this.valorItu = valorItu;
    }

    /**
     * 
     * @return resultado Resultado textual: CONFORTO, ALERTA ou ESTRESSE.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * 
     * @param resultado Classificação do ITU.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * 
     * @return dataAvaliacao Data e hora da avaliação.
     */
    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    /**
     * 
     * @param dataAvaliacao Data e hora do registo.
     */
    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    /**
     * 
     * @return nomeAnimal Nome do animal (usado na tabela de exibição).
     */
    public String getNomeAnimal() {
        return nomeAnimal;
    }

    /**
     * 
     * @param nomeAnimal Nome do animal.
     */
    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    /**
     * 
     * @return localAmbiente Local do ambiente (usado na tabela de exibição).
     */
    public String getLocalAmbiente() {
        return localAmbiente;
    }

    /**
     * 
     * @param localAmbiente Local do ambiente.
     */
    public void setLocalAmbiente(String localAmbiente) {
        this.localAmbiente = localAmbiente;
    }

    @Override
    public String toString() {
        return "Avaliacao{"
                + "animal='" + nomeAnimal + "'"
                + ", local='" + localAmbiente + "'"
                + ", ITU=" + valorItu
                + ", resultado='" + resultado + "'"
                + "}";
    }
}

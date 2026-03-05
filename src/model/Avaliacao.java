package model;

import java.time.LocalDateTime;

/**
 * Classe Avaliacao - representa o resultado do cálculo do ITU (Índice de
 * Temperatura e Umidade) para um bovino num dado ambiente.
 *
 * Fórmula utilizada:
 *
 * ITU = (0.8 × temperatura) + ((umidade / 100) × (temperatura - 14.4)) + 46.4
 *
 *
 * Classificação do resultado:
 *
 * ITU menor que 72 → CONFORTO ITU entre 72 e 79 → ALERTA ITU maior ou igual a
 * 79 → ESTRESSE
 *
 * @author Lucas
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
     * Construtor usado ao INSERIR uma nova avaliação.
     * 
     * ID do bovino a ser avaliado.
     * ID do ambiente utilizado.
     * Valor calculado do ITU.
     * Classificação: "CONFORTO", "ALERTA" ou "ESTRESSE".
     * 
     */
    public Avaliacao(int bovinoId, int ambienteId, double valorItu, String resultado) {
        this.bovinoId = bovinoId;
        this.ambienteId = ambienteId;
        this.valorItu = valorItu;
        this.resultado = resultado;
    }

    /**
     * Construtor completo usado ao LISTAR avaliações da base de dados.
     *
     * ID da avaliação.
     * ID do bovino.
     * ID do ambiente.
     * Valor do ITU calculado.
     * Classificação do resultado.
     * Data e hora do registo.
     * Nome do animal (obtido via JOIN).
     * Local do ambiente (obtido via JOIN).
     * 
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
     * Retorna ID da avaliação.
     */
    public int getId() {
        return id;
    }

    /**
     * ID da avaliação.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna ID do bovino avaliado.
     */
    public int getBovinoId() {
        return bovinoId;
    }

    /**
     * ID do bovino.
     */
    public void setBovinoId(int bovinoId) {
        this.bovinoId = bovinoId;
    }

    /**
     * Retorna o ID do ambiente utilizado.
     */
    public int getAmbienteId() {
        return ambienteId;
    }

    /**
     * ID do ambiente.
     */
    public void setAmbienteId(int ambienteId) {
        this.ambienteId = ambienteId;
    }

    /**
     * Valor numérico do ITU.
     */
    public double getValorItu() {
        return valorItu;
    }

    /**
     * Valor do ITU.
     */
    public void setValorItu(double valorItu) {
        this.valorItu = valorItu;
    }

    /**
     * Resultado textual: CONFORTO, ALERTA ou ESTRESSE.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Classificação do ITU.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Data e hora da avaliação.
     */
    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    /**
     * Data e hora do registo.
     */
    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    /**
     * Nome do animal (usado na tabela de exibição).
     */
    public String getNomeAnimal() {
        return nomeAnimal;
    }

    /**
     * Nome do animal.
     */
    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    /**
     * Local do ambiente (usado na tabela de exibição).
     */
    public String getLocalAmbiente() {
        return localAmbiente;
    }

    /**
     * Local do ambiente.
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

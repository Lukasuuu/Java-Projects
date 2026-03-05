package model;

import java.time.LocalDateTime;

/**
 * Classe Ambiente - representa as condições climáticas de um local em uma data
 * específica. Contém informações como temperatura, umidade, local e data de
 * registo.
 *
 * @author Lucas
 */
public class Ambiente {

    private int id;
    private double temperatura;
    private double umidade;
    private String local;
    private LocalDateTime dataRegisto;

    /**
     * Construtor vazio.
     */
    public Ambiente() {
    }

    /**
     * Construtor para inserir
     *
     * @param temperatura temperatura (°C)
     * @param umidade umidade (%)
     * @param local local do registo
     */
        public Ambiente(double temperatura, double umidade, String local) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.local = local;
    }

    /**
     * Construtor completo (listagem).
     *
     * @param id id do registo
     * @param temperatura temperatura (°C)
     * @param umidade umidade (%)
     * @param local local do registo
     * @param dataRegisto data/hora do registo
     */
    public Ambiente(int id, double temperatura, double umidade, String local, LocalDateTime dataRegisto) {
        this.id = id;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.local = local;
        this.dataRegisto = dataRegisto;
    }



    public Ambiente(int id, double temp, double umid, String local) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Retorna o ID do ambiente.
     *
     * @return ID numérico.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do ambiente.
     *
     * @param id Identificador numérico.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a temperatura registrada.
     *
     * @return Temperatura em graus Celsius.
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * Define a temperatura do ambiente.
     *
     * @param temperatura Valor da temperatura.
     */
    public void setTemperatura(double temperatura) {
        if (temperatura < -50 || temperatura > 60) {
            throw new IllegalArgumentException("Temperatura fora do intervalo aceitável.");
        }
        this.temperatura = temperatura;
    }

    /**
     * Retorna a umidade registrada.
     *
     * @return Umidade relativa em porcentagem.
     */
    public double getUmidade() {
        return umidade;
    }

    /**
     * Define a umidade do ambiente.
     *
     * @param umidade Valor da umidade.
     */
    public void setUmidade(double umidade) {
        if (umidade < 0 || umidade > 100) {
            throw new IllegalArgumentException("Umidade deve estar entre 0% e 100%.");
        }
        this.umidade = umidade;
    }

    /**
     * Retorna o local do registo.
     *
     * @return Nome do local.
     */
    public String getLocal() {
        return local;
    }

    /**
     * Define o local do registo.
     *
     * @param local Nome do local.
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * Retorna a data do registo.
     *
     * @return Data no formato texto.
     */
    public LocalDateTime getDataRegisto() {
        return dataRegisto;
    }

    /**
     * Define a data do registo.
     *
     * @param dataRegisto Data no formato texto.
     */
    public void setDataRegisto(LocalDateTime dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

@Override
public String toString() {
    return local + " (" + temperatura + "°C / " + umidade + "%)";
}
}

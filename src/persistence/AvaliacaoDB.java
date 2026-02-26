/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Avaliacao;

/**
 *
 * @author Lucas
 */
public class AvaliacaoDB {
    /**
     * Metodo inserir - guarda uma nova avaliacao
     * @param avaliacao
     */
    public boolean inserir(Avaliacao avaliacao) throws Exception{
        String sql = "INSERT INTO avaliacao (id_animal, id_ambiente, valor_itu, resultado, data_avaliacao) " +
                     "VALUES (?, ?, ?, ?, NOW())";
        
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, avaliacao.getIdAnimal());
            ps.setInt(2, avaliacao.getIdAmbiente());
            ps.setDouble(3, avaliacao.getValorITU());
            ps.setString(4, avaliacao.getResultado());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException erro) {
            System.out.println("Erro ao inserir avaliacao: " + erro.getMessage());
            return false;
        }
    }
    
    /**
     * Metodo listarTodos - devolve todas as avaliacoes
     */
    public ArrayList<Avaliacao> listarTodos() throws Exception{
        ArrayList<Avaliacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM avaliacao ORDER BY data_avaliacao DESC";
        
        try (Connection con = Conexao.getConexao();
             Statement st = con.createStatement();
             ResultSet resultado = st.executeQuery(sql)) {
            
            while (resultado.next()) {
                Avaliacao a = new Avaliacao(
                    resultado.getInt("id"),
                    resultado.getInt("id_animal"),
                    resultado.getInt("id_ambiente"),
                    resultado.getDouble("valor_itu"),
                    resultado.getString("resultado"),
                    resultado.getString("data_avaliacao")
                );
                lista.add(a);
            }
            
        } catch (exception.ProjetoException exception) {
            System.out.println("Erro ao listar avaliacoes: " + exception.getMessage());
        }
        
        return lista;
    }
}

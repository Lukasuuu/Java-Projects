package apresentation;
import persistence.*;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import model.Usuario;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Animal;
import model.Bovino;

/**
 * ============================================
 * JANELA PRINCIPAL - COM HERANCA
 * ============================================
 * Esta versão trabalha com a hierarquia:
 * Animal (PAI) -> Bovino (FILHO)
 * 
 * Demonstra POLIMORFISMO na prática
 */
public class Confort extends JFrame {
    
    private final Usuario usuarioLogado;
    
    public Confort(Usuario usuario) throws Exception {
        this.usuarioLogado = usuario;
        criarJanela();
    }
    
    private void criarJanela() throws Exception {
        setTitle("Sistema - " + usuarioLogado.getNomeCompleto());
        setSize(950, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JTabbedPane abas = new JTabbedPane();
        abas.setFont(new Font("Arial", Font.PLAIN, 14));
        
        abas.addTab("Bovinos (Heranca)", criarAbaBovinos());
        abas.addTab("Ambientes", criarAbaAmbientes());
        abas.addTab("Avaliacoes", criarAbaAvaliacoes());
        
        add(abas);
    }
    
    // =======================================
    //  ABA BOVINOS - COM HERANCA
    // =======================================
    private JPanel criarAbaBovinos() throws Exception{
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // TABELA
        String[] colunas = {"ID", "Nome", "Peso", "Idade", "Raca", "Linhagem", "Prod.Leite"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        tabela.setRowHeight(25);
        JScrollPane scroll = new JScrollPane(tabela);
        
        JPanel painelCentro = new JPanel(new BorderLayout());
        painelCentro.add(scroll, BorderLayout.CENTER);
        painel.add(painelCentro, BorderLayout.CENTER);
        
        // FORMULARIO
        JPanel form = new JPanel(new GridLayout(7, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Adicionar Bovino"));
        
        JTextField txtNome = new JTextField();
        JTextField txtPeso = new JTextField();
        JTextField txtIdade = new JTextField();
        JTextField txtRaca = new JTextField();
        JComboBox<String> cmbLinhagem = new JComboBox<>(new String[]{"LEITE", "CARNE", "DUPLA_APTIDAO"});
        JTextField txtProducao = new JTextField();
        
        form.add(new JLabel("Nome (de Animal):"));
        form.add(txtNome);
        form.add(new JLabel("Peso kg (de Animal):"));
        form.add(txtPeso);
        form.add(new JLabel("Idade meses (de Animal):"));
        form.add(txtIdade);
        form.add(new JLabel("Raca (de Bovino):"));
        form.add(txtRaca);
        form.add(new JLabel("Linhagem (de Bovino):"));
        form.add(cmbLinhagem);
        form.add(new JLabel("Producao L/dia (de Bovino):"));
        form.add(txtProducao);
        
        JButton btnAdicionar = new JButton("Adicionar Bovino");
        JButton btnAtualizar = new JButton("Atualizar Lista");
        form.add(btnAdicionar);
        form.add(btnAtualizar);
        
        painel.add(form, BorderLayout.SOUTH);
        
        // ACOES
        btnAdicionar.addActionListener((ActionEvent e) -> {
            try {
                // Cria um objeto BOVINO (classe FILHA)
                Bovino bovino = new Bovino();
                
                // Define propriedades HERDADAS de Animal
                bovino.setNome(txtNome.getText());
                bovino.setPeso(Double.parseDouble(txtPeso.getText()));
                bovino.setIdade(Integer.parseInt(txtIdade.getText()));
                
                // Define propriedades PROPRIAS de Bovino
                bovino.setRaca(txtRaca.getText());
                bovino.setLinhagem((String) cmbLinhagem.getSelectedItem());
                bovino.setProducaoLeite(Double.parseDouble(txtProducao.getText()));
                
                // Guarda na BD
                if (new AnimalDB().inserir(bovino)) {
                    JOptionPane.showMessageDialog(this, 
                        "Bovino adicionado com sucesso!\\n\\n" +
                        "HERANCA em acao:\\n" +
                        "- Propriedades de Animal: nome, peso, idade\\n" +
                        "- Propriedades de Bovino: raca, linhagem, producao");
                    
                    txtNome.setText("");
                    txtPeso.setText("");
                    txtIdade.setText("");
                    txtRaca.setText("");
                    txtProducao.setText("");
                    atualizarTabelaBovinos(modelo);
                }
            } catch (exception.ProjetoException exception) {
                JOptionPane.showMessageDialog(this, "Erro: " + exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnAtualizar.addActionListener(e -> atualizarTabelaBovinos(modelo));
        
        atualizarTabelaBovinos(modelo);
        return painel;
    }
    
    private void atualizarTabelaBovinos(DefaultTableModel modelo) {
        try {
            modelo.setRowCount(0);
            
            // POLIMORFISMO: lista de Animal contém objetos Bovino
            ArrayList<Animal> animais = new AnimalDB().listarTodos();
            
            for (Animal animal : animais) {
                // Como sabemos que são todos Bovino, fazemos CAST
                if (animal instanceof Bovino b) {
                    modelo.addRow(new Object[]{
                        b.getId(),           // Herdado de Animal
                        b.getNome(),         // Herdado de Animal
                        b.getPeso(),         // Herdado de Animal
                        b.getIdade(),        // Herdado de Animal
                        b.getRaca(),         // Proprio de Bovino
                        b.getLinhagem(),     // Proprio de Bovino
                        b.getProducaoLeite() // Proprio de Bovino
                    });
                }
            }
        } catch (exception.ProjetoException ex) {
            Logger.getLogger(ConfortAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // =======================================
    //  ABA AMBIENTES (igual ao anterior)
    // =======================================
    private JPanel criarAbaAmbientes() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        String[] colunas = {"ID", "Temperatura", "Umidade", "Local", "Data"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        tabela.setRowHeight(25);
        JScrollPane scroll = new JScrollPane(tabela);
        painel.add(scroll, BorderLayout.CENTER);
        
        JPanel form = new JPanel(new GridLayout(4, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Registar Ambiente"));
        
        JTextField txtTemp = new JTextField();
        JTextField txtUmi = new JTextField();
        JTextField txtLocal = new JTextField();
        
        form.add(new JLabel("Temperatura (C):"));
        form.add(txtTemp);
        form.add(new JLabel("Umidade (%):"));
        form.add(txtUmi);
        form.add(new JLabel("Local:"));
        form.add(txtLocal);
        
        JButton btnRegistar = new JButton("Registar");
        JButton btnAtualizar = new JButton("Atualizar");
        form.add(btnRegistar);
        form.add(btnAtualizar);
        
        painel.add(form, BorderLayout.SOUTH);
        
        btnRegistar.addActionListener((ActionEvent e) -> {
            try {
                Ambiente a = new Ambiente();
                a.setTemperatura(Double.parseDouble(txtTemp.getText()));
                a.setUmidade(Double.parseDouble(txtUmi.getText()));
                a.setLocal(txtLocal.getText());
                
                try {
                    if (new AmbienteDB().inserir(a)) {
                        JOptionPane.showMessageDialog(this, "Ambiente registado!");
                        txtTemp.setText("");
                        txtUmi.setText("");
                        txtLocal.setText("");
                        atualizarTabelaAmbientes(modelo);
                    }
                } catch (java.lang.Exception ex) {
                    Logger.getLogger(ConfortAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (exception.ProjetoException exeException) {
                JOptionPane.showMessageDialog(this, "Erro: " + exeException.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnAtualizar.addActionListener(e -> atualizarTabelaAmbientes(modelo));
        
        atualizarTabelaAmbientes(modelo);
        return painel;
    }
    
    private void atualizarTabelaAmbientes(DefaultTableModel modelo) {
        try {
            modelo.setRowCount(0);
            for (Ambiente a : new AmbienteDB().listarTodos()) {
                modelo.addRow(new Object[]{a.getId(), a.getTemperatura(), a.getUmidade(), a.getLocal(), a.getDataRegisto()});
            }
        } catch (java.lang.Exception ex) {
            Logger.getLogger(ConfortAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // =======================================
    //  ABA AVALIACOES (igual ao anterior)
    // =======================================
    private JPanel criarAbaAvaliacoes() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        String[] colunas = {"ID", "ID Animal", "ID Ambiente", "ITU", "Resultado", "Data"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        tabela.setRowHeight(25);
        JScrollPane scroll = new JScrollPane(tabela);
        painel.add(scroll, BorderLayout.CENTER);
        
        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Fazer Avaliacao"));
        
        JTextField txtIdAnimal = new JTextField();
        JTextField txtIdAmbiente = new JTextField();
        
        form.add(new JLabel("ID do Animal:"));
        form.add(txtIdAnimal);
        form.add(new JLabel("ID do Ambiente:"));
        form.add(txtIdAmbiente);
        
        JButton btnAvaliar = new JButton("Fazer Avaliacao");
        JButton btnAtualizar = new JButton("Atualizar");
        form.add(btnAvaliar);
        form.add(btnAtualizar);
        
        painel.add(form, BorderLayout.SOUTH);
        
        btnAvaliar.addActionListener((var e) -> {
            try {
                int idAnimal = Integer.parseInt(txtIdAnimal.getText());
                int idAmbiente = Integer.parseInt(txtIdAmbiente.getText());
                
                Ambiente amb = null;
                try {
                    for (Ambiente a : new AmbienteDB().listarTodos()) {
                        if (a.getId() == idAmbiente) {
                            amb = a;
                            break;
                        }
                    }
                } catch (java.lang.Exception ex) {
                    Logger.getLogger(ConfortAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (amb != null) {
                    double temp = amb.getTemperatura();
                    double umi = amb.getUmidade();
                    double itu = 0.8 * temp + (umi / 100.0) * (temp - 14.4) + 46.4;
                    
                    String resultado;
                    if (itu < 72) resultado = "CONFORTO";
                    else if (itu < 79) resultado = "ALERTA";
                    else resultado = "ESTRESSE";
                    
                    Avaliacao av = new Avaliacao();
                    av.setIdAnimal(idAnimal);
                    av.setIdAmbiente(idAmbiente);
                    av.setValorITU(itu);
                    av.setResultado(resultado);
                    
                    try {
                        if (new AvaliacaoDB().inserir(av)) {
                            String msg = String.format(
                                    "Avaliacao concluida!%n%nITU: %.2f%nResultado: %s", itu, resultado);
                            JOptionPane.showMessageDialog(this, msg);
                            txtIdAnimal.setText("");
                            txtIdAmbiente.setText("");
                            atualizarTabelaAvaliacoes(modelo);
                        }
                    } catch (java.lang.Exception ex) {
                        Logger.getLogger(ConfortAnimal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ambiente nao encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (exception.ProjetoException exception) {
                JOptionPane.showMessageDialog(this, "Erro: " + exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnAtualizar.addActionListener(e -> atualizarTabelaAvaliacoes(modelo));
        
        atualizarTabelaAvaliacoes(modelo);
        return painel;
    }
    
    private void atualizarTabelaAvaliacoes(DefaultTableModel modelo) {
        try {
            modelo.setRowCount(0);
            for (Avaliacao a : new AvaliacaoDB().listarTodos()) {
                modelo.addRow(new Object[]{
                    a.getId(), a.getIdAnimal(), a.getIdAmbiente(),
                    String.format("%.2f", a.getValorITU()), a.getResultado(), a.getDataAvaliacao()
                });
            }
        } catch (java.lang.Exception ex) {
            Logger.getLogger(ConfortAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

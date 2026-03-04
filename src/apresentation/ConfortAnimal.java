package apresentation;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistence.AnimalDB;
import model.Animal;
import model.Bovino;
import persistence.AnimalDB;

/**
 * Classe ConfortAnimal - Janela principal do sistema.
 *
 * Estrutura pensada para iniciantes: - Menu superior: Home / Dados / Logout -
 * Abas (JTabbedPane): Animal / Ambiente / Avaliações - Cada aba tem uma tabela
 * (JTable) para listar dados.
 *
 * Mais tarde, você pode adicionar: - Formulários de cadastro (Animal, Ambiente)
 * - Botões para inserir, listar, atualizar e apagar - Fluxo de avaliação
 * (Animal + Ambiente -> Avaliação)
 *
 * @author Lucas
 */
public class ConfortAnimal extends javax.swing.JFrame {

    /**
     * Creates new form ConfortAnimal
     */
    public ConfortAnimal() {
        initComponents();
        setLocationRelativeTo(null);
        mostrarCard("HOME");
    }

    /**
     * Mostra um painel específico dentro do CardLayout.
     *
     * @param nomeCard Nome do card configurado no Card Name.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cardHome = new javax.swing.JPanel();
        cardAnimal = new javax.swing.JPanel();
        panelFormAnimal = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbPeso = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        lbIdade = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        lbRaca = new javax.swing.JLabel();
        txtRaca = new javax.swing.JTextField();
        lbLinhagem = new javax.swing.JLabel();
        cbLinhagem = new javax.swing.JComboBox<>();
        lbProducaoDeLeite = new javax.swing.JLabel();
        txtProducao = new javax.swing.JTextField();
        btnRegistarAnimal = new javax.swing.JButton();
        btnListarAnimal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AnimalTable = new javax.swing.JTable();
        cardAmbiente = new javax.swing.JPanel();
        cardAvaliacoes = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        Home = new javax.swing.JMenu();
        Dados = new javax.swing.JMenu();
        animalItem = new javax.swing.JMenuItem();
        ambienteItem = new javax.swing.JMenuItem();
        avaliacoesItem = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenu();
        sairItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.CardLayout());

        panelFormAnimal.setLayout(new java.awt.GridBagLayout());

        lbNome.setText("Nome");

        txtNome.setPreferredSize(new java.awt.Dimension(120, 25));

        lbPeso.setText("Peso");

        txtPeso.setPreferredSize(new java.awt.Dimension(120, 25));

        lbIdade.setText("Idade");

        txtIdade.setPreferredSize(new java.awt.Dimension(120, 25));

        lbRaca.setText("Raça");

        txtRaca.setPreferredSize(new java.awt.Dimension(120, 25));

        lbLinhagem.setText("Linhagem");

        cbLinhagem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LEITE", "CARNE", "DUPLA_APTIDAO" }));
        cbLinhagem.setPreferredSize(new java.awt.Dimension(120, 25));
        cbLinhagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhagemActionPerformed(evt);
            }
        });

        lbProducaoDeLeite.setText("Produção de Leite");

        txtProducao.setPreferredSize(new java.awt.Dimension(120, 25));

        btnRegistarAnimal.setText("Registar");
        btnRegistarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarAnimalActionPerformed(evt);
            }
        });

        btnListarAnimal.setText("Listar");
        btnListarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAnimalActionPerformed(evt);
            }
        });

        AnimalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Raça", "Linhagem", "Peso (Kg)", "Idade (Anos)", "Produção de Leite (Litros)"
            }
        ));
        jScrollPane1.setViewportView(AnimalTable);

        javax.swing.GroupLayout cardAnimalLayout = new javax.swing.GroupLayout(cardAnimal);
        cardAnimal.setLayout(cardAnimalLayout);
        cardAnimalLayout.setHorizontalGroup(
            cardAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(cardAnimalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistarAnimal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarAnimal))
                    .addGroup(cardAnimalLayout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPeso)
                        .addGap(18, 18, 18)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbIdade)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbRaca)
                        .addGap(18, 18, 18)
                        .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbLinhagem)
                        .addGap(18, 18, 18)
                        .addComponent(cbLinhagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbProducaoDeLeite)
                        .addGap(18, 18, 18)
                        .addComponent(txtProducao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(cardAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardAnimalLayout.createSequentialGroup()
                    .addContainerGap(411, Short.MAX_VALUE)
                    .addComponent(panelFormAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(448, Short.MAX_VALUE)))
        );
        cardAnimalLayout.setVerticalGroup(
            cardAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLinhagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbProducaoDeLeite)
                    .addComponent(txtProducao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLinhagem)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRaca)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIdade)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPeso)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome))
                .addGap(21, 21, 21)
                .addGroup(cardAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListarAnimal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistarAnimal))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(cardAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardAnimalLayout.createSequentialGroup()
                    .addContainerGap(260, Short.MAX_VALUE)
                    .addComponent(panelFormAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(261, Short.MAX_VALUE)))
        );

        lbNome.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout cardHomeLayout = new javax.swing.GroupLayout(cardHome);
        cardHome.setLayout(cardHomeLayout);
        cardHomeLayout.setHorizontalGroup(
            cardHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardHomeLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(cardAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        cardHomeLayout.setVerticalGroup(
            cardHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(cardHome, "HOME");

        javax.swing.GroupLayout cardAmbienteLayout = new javax.swing.GroupLayout(cardAmbiente);
        cardAmbiente.setLayout(cardAmbienteLayout);
        cardAmbienteLayout.setHorizontalGroup(
            cardAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1222, Short.MAX_VALUE)
        );
        cardAmbienteLayout.setVerticalGroup(
            cardAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );

        jPanel1.add(cardAmbiente, "AMBIENTE");

        javax.swing.GroupLayout cardAvaliacoesLayout = new javax.swing.GroupLayout(cardAvaliacoes);
        cardAvaliacoes.setLayout(cardAvaliacoesLayout);
        cardAvaliacoesLayout.setHorizontalGroup(
            cardAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1222, Short.MAX_VALUE)
        );
        cardAvaliacoesLayout.setVerticalGroup(
            cardAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );

        jPanel1.add(cardAvaliacoes, "AVALIACOES");

        getContentPane().add(jPanel1, "card2");

        Home.setText("Home");
        Home.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                HomeMenuSelected(evt);
            }
        });
        MenuBar.add(Home);

        Dados.setText("Dados");
        Dados.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                DadosMenuSelected(evt);
            }
        });

        animalItem.setText("Animal");
        animalItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalItemActionPerformed(evt);
            }
        });
        Dados.add(animalItem);
        animalItem.getAccessibleContext().setAccessibleName("ANIMAL");

        ambienteItem.setText("Ambiente");
        ambienteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ambienteItemActionPerformed(evt);
            }
        });
        Dados.add(ambienteItem);
        ambienteItem.getAccessibleContext().setAccessibleName("AMBIENTE");

        avaliacoesItem.setText("Avaliacoes");
        avaliacoesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaliacoesItemActionPerformed(evt);
            }
        });
        Dados.add(avaliacoesItem);
        avaliacoesItem.getAccessibleContext().setAccessibleName("AVALIACOES");

        MenuBar.add(Dados);

        Logout.setText("Logout");
        Logout.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                LogoutMenuSelected(evt);
            }
        });

        sairItem.setText("Sair");
        sairItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairItemActionPerformed(evt);
            }
        });
        Logout.add(sairItem);
        sairItem.getAccessibleContext().setAccessibleName("SAIR");

        MenuBar.add(Logout);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void mostrarCard(String nomeCard) {

        java.awt.CardLayout cl = (java.awt.CardLayout) jPanel1.getLayout();
        cl.show(jPanel1, nomeCard);

    }
    private void HomeMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_HomeMenuSelected
        mostrarCard("HOME");
    }//GEN-LAST:event_HomeMenuSelected

    private void DadosMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_DadosMenuSelected
        mostrarCard("ANIMAL");
    }//GEN-LAST:event_DadosMenuSelected

    private void LogoutMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_LogoutMenuSelected

    }//GEN-LAST:event_LogoutMenuSelected

    private void avaliacoesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaliacoesItemActionPerformed
        mostrarCard("AVALIACOES");
    }//GEN-LAST:event_avaliacoesItemActionPerformed

    private void ambienteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ambienteItemActionPerformed
        mostrarCard("AMBIENTE");
    }//GEN-LAST:event_ambienteItemActionPerformed

    private void animalItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalItemActionPerformed
        mostrarCard("ANIMAL");
    }//GEN-LAST:event_animalItemActionPerformed

    private void sairItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairItemActionPerformed
        int op = JOptionPane.showConfirmDialog(
                this,
                "Deseja sair do sistema?",
                "Logout",
                JOptionPane.YES_NO_OPTION
        );

        if (op == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_sairItemActionPerformed

    private void cbLinhagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLinhagemActionPerformed

    }//GEN-LAST:event_cbLinhagemActionPerformed
    /**
     * Registar os animais na JTable usando a view vw_bovinos_completos.
     */
    private void RegistarAnimal() {
        try {
            // 1) Ler textos
            String nome = txtNome.getText().trim();
            String pesoTxt = txtPeso.getText().trim();
            String idadeTxt = txtIdade.getText().trim();
            String raca = txtRaca.getText().trim();
            String producaoTxt = txtProducao.getText().trim();
            String linhagem = cbLinhagem.getSelectedItem().toString();

            // 2) Validar campos obrigatórios
            if (nome.isEmpty() || pesoTxt.isEmpty() || idadeTxt.isEmpty() || raca.isEmpty() || producaoTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Preencha todos os campos (Nome, Peso, Idade, Raça e Produção).",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 3) Converter numéricos
            double peso = Double.parseDouble(pesoTxt);
            int idade = Integer.parseInt(idadeTxt);
            double producao = Double.parseDouble(producaoTxt);

            // 4) Inserir na BD
            AnimalDB db = new AnimalDB();
            db.registarBovino(nome, peso, idade, raca, linhagem, producao);

            JOptionPane.showMessageDialog(this,
                    "Animal registado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            // 5) Limpar e atualizar tabela
            limparCamposAnimal();
            listarAnimais();
            
             System.out.println("Registo OK: " + nome + " (" + raca + ")");
             
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Peso/Idade/Produção devem ser números válidos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } catch (exception.DadosInvalidosException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao registar:"+ e.getMessage(),
                    "Dados inválidos",
                    JOptionPane.WARNING_MESSAGE);

        } catch (exception.ConexaoBDException e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Erro BD",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnRegistarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarAnimalActionPerformed
        RegistarAnimal();
    }//GEN-LAST:event_btnRegistarAnimalActionPerformed
    /**
     * Lista os animais na JTable usando a view vw_bovinos_completos.
     */
    private void listarAnimais() {
             try {

        AnimalDB db = new AnimalDB();

        // buscar lista de bovinos
        ArrayList<Bovino> lista = db.listarBovinos();

        DefaultTableModel model = (DefaultTableModel) AnimalTable.getModel();

        // limpar tabela
        model.setRowCount(0);

        // adicionar cada bovino à tabela
        for (Bovino b : lista) {

            model.addRow(new Object[]{
                b.getAnimalId(),
                b.getNome(),
                b.getRaca(),
                b.getLinhagem(),
                b.getPeso(),
                b.getIdade(),
                b.getProducaoLeite()
            });
        }

    } catch (exception.DadosInvalidosException e) {

        JOptionPane.showMessageDialog(this,
                "Erro ao listar animais: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }
    }
    private void btnListarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAnimalActionPerformed
        listarAnimais();
    }//GEN-LAST:event_btnListarAnimalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfortAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ConfortAnimal().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AnimalTable;
    private javax.swing.JMenu Dados;
    private javax.swing.JMenu Home;
    private javax.swing.JMenu Logout;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem ambienteItem;
    private javax.swing.JMenuItem animalItem;
    private javax.swing.JMenuItem avaliacoesItem;
    private javax.swing.JButton btnListarAnimal;
    private javax.swing.JButton btnRegistarAnimal;
    private javax.swing.JPanel cardAmbiente;
    private javax.swing.JPanel cardAnimal;
    private javax.swing.JPanel cardAvaliacoes;
    private javax.swing.JPanel cardHome;
    private javax.swing.JComboBox<String> cbLinhagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIdade;
    private javax.swing.JLabel lbLinhagem;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPeso;
    private javax.swing.JLabel lbProducaoDeLeite;
    private javax.swing.JLabel lbRaca;
    private javax.swing.JPanel panelFormAnimal;
    private javax.swing.JMenuItem sairItem;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtProducao;
    private javax.swing.JTextField txtRaca;
    // End of variables declaration//GEN-END:variables

    /**
     * Limpa os campos do formulário Animal.
     */
    private void limparCamposAnimal() {
        txtNome.setText("");
        txtPeso.setText("");
        txtIdade.setText("");
        txtRaca.setText("");
        txtProducao.setText("");
        cbLinhagem.setSelectedIndex(0);
    }

}

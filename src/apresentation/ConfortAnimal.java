package apresentation;

import exception.ConexaoBDException;
import exception.DadosInvalidosException;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Animal;
import model.Bovino;
import model.Ambiente;
import model.Avaliacao;
import service.AnimalService;
import service.AmbienteService;
import service.AvaliacaoService;
import service.BovinoService;

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
        inicializarHome();
        setLocationRelativeTo(null);
        mostrarCard("HOME");
    }
    /**
     * Service do Ambiente e o Animal. A tela chama o Service, e o Service chama
     * o DB.
     */
    private final AvaliacaoService avaliacaoService = new AvaliacaoService();
    private final AmbienteService ambienteService = new AmbienteService();
    private final AnimalService animalService = new AnimalService();
    private final BovinoService bovinoService = new BovinoService();

    /**
     * Mostra um painel específico dentro do CardLayout.
     *
     * @param nomeCard Nome do card configurado no Card Name.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cardHome = new javax.swing.JPanel();
        cardAvaliacoes = new javax.swing.JPanel();
        panelFormAvaliacoes = new javax.swing.JPanel();
        lbAmbientes = new javax.swing.JLabel();
        cbAmbiente = new javax.swing.JComboBox<>();
        btnGerarAvaliacoes = new javax.swing.JButton();
        btnListarAvaliacoes = new javax.swing.JButton();
        Avaliacoes = new javax.swing.JScrollPane();
        avaliacoesTable = new javax.swing.JTable();
        cardAmbiente = new javax.swing.JPanel();
        panelFormAmbiente = new javax.swing.JPanel();
        lbLocal = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        lbTemperatura = new javax.swing.JLabel();
        txtTemperatura = new javax.swing.JTextField();
        lbUmidade = new javax.swing.JLabel();
        txtUmidade = new javax.swing.JTextField();
        btnRegistarAmbiente = new javax.swing.JButton();
        btnListarAmbiente = new javax.swing.JButton();
        btnApagarAmbiente = new javax.swing.JButton();
        Ambiente = new javax.swing.JScrollPane();
        AmbienteTable = new javax.swing.JTable();
        cardAnimal = new javax.swing.JPanel();
        panelFormAnimal = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        lbPeso = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        lbIdade = new javax.swing.JLabel();
        lbRaca = new javax.swing.JLabel();
        txtRaca = new javax.swing.JTextField();
        lbLinhagem = new javax.swing.JLabel();
        cbLinhagem = new javax.swing.JComboBox<>();
        lbProducaoDeLeite = new javax.swing.JLabel();
        txtProducao = new javax.swing.JTextField();
        btnApagarAnimal = new javax.swing.JButton();
        btnRegistarAnimal = new javax.swing.JButton();
        btnListarAnimal = new javax.swing.JButton();
        Animal = new javax.swing.JScrollPane();
        AnimalTable = new javax.swing.JTable();
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

        javax.swing.GroupLayout cardHomeLayout = new javax.swing.GroupLayout(cardHome);
        cardHome.setLayout(cardHomeLayout);
        cardHomeLayout.setHorizontalGroup(
            cardHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1322, Short.MAX_VALUE)
        );
        cardHomeLayout.setVerticalGroup(
            cardHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jPanel1.add(cardHome, "HOME");

        lbAmbientes.setText("Selecionar Ambiente: ");

        cbAmbiente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGerarAvaliacoes.setText("Gerar Avaliações");
        btnGerarAvaliacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarAvaliacoesActionPerformed(evt);
            }
        });

        btnListarAvaliacoes.setText("Listar Avaliações");
        btnListarAvaliacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAvaliacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormAvaliacoesLayout = new javax.swing.GroupLayout(panelFormAvaliacoes);
        panelFormAvaliacoes.setLayout(panelFormAvaliacoesLayout);
        panelFormAvaliacoesLayout.setHorizontalGroup(
            panelFormAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormAvaliacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormAvaliacoesLayout.createSequentialGroup()
                        .addComponent(lbAmbientes)
                        .addGap(18, 18, 18)
                        .addComponent(cbAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFormAvaliacoesLayout.createSequentialGroup()
                        .addComponent(btnListarAvaliacoes)
                        .addGap(18, 18, 18)
                        .addComponent(btnGerarAvaliacoes)))
                .addContainerGap(549, Short.MAX_VALUE))
        );
        panelFormAvaliacoesLayout.setVerticalGroup(
            panelFormAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormAvaliacoesLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelFormAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAmbientes)
                    .addComponent(cbAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarAvaliacoes)
                    .addComponent(btnGerarAvaliacoes))
                .addContainerGap(482, Short.MAX_VALUE))
        );

        cbAmbiente.getAccessibleContext().setAccessibleName("");

        avaliacoesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Animal", "Local", "ITU", "Resultado", "Data"
            }
        ));
        Avaliacoes.setViewportView(avaliacoesTable);

        javax.swing.GroupLayout cardAvaliacoesLayout = new javax.swing.GroupLayout(cardAvaliacoes);
        cardAvaliacoes.setLayout(cardAvaliacoesLayout);
        cardAvaliacoesLayout.setHorizontalGroup(
            cardAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAvaliacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Avaliacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 1235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(cardAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cardAvaliacoesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelFormAvaliacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(509, Short.MAX_VALUE)))
        );
        cardAvaliacoesLayout.setVerticalGroup(
            cardAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardAvaliacoesLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(Avaliacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(cardAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cardAvaliacoesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelFormAvaliacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(cardAvaliacoes, "AVALIACOES");

        lbLocal.setText("Local");

        txtLocal.setPreferredSize(new java.awt.Dimension(120, 25));

        lbTemperatura.setText("Temperatura");

        txtTemperatura.setPreferredSize(new java.awt.Dimension(120, 25));

        lbUmidade.setText("Umidade");

        txtUmidade.setPreferredSize(new java.awt.Dimension(120, 25));

        btnRegistarAmbiente.setText("Registar");
        btnRegistarAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarAmbienteActionPerformed(evt);
            }
        });

        btnListarAmbiente.setText("Listar");
        btnListarAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAmbienteActionPerformed(evt);
            }
        });

        btnApagarAmbiente.setText("Apagar");

        AmbienteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Temperatura", "Umidade", "Local", "Data de Registo"
            }
        ));
        Ambiente.setViewportView(AmbienteTable);

        javax.swing.GroupLayout panelFormAmbienteLayout = new javax.swing.GroupLayout(panelFormAmbiente);
        panelFormAmbiente.setLayout(panelFormAmbienteLayout);
        panelFormAmbienteLayout.setHorizontalGroup(
            panelFormAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormAmbienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormAmbienteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelFormAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormAmbienteLayout.createSequentialGroup()
                                .addComponent(lbLocal)
                                .addGap(18, 18, 18)
                                .addComponent(txtLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbTemperatura)
                                .addGap(18, 18, 18)
                                .addComponent(txtTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbUmidade)
                                .addGap(18, 18, 18)
                                .addComponent(txtUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(704, 704, 704))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormAmbienteLayout.createSequentialGroup()
                                .addComponent(btnApagarAmbiente)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistarAmbiente)
                                .addGap(18, 18, 18)
                                .addComponent(btnListarAmbiente))))
                    .addComponent(Ambiente))
                .addContainerGap())
        );
        panelFormAmbienteLayout.setVerticalGroup(
            panelFormAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormAmbienteLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelFormAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLocal)
                    .addComponent(txtLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTemperatura)
                    .addComponent(txtUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUmidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApagarAmbiente)
                    .addComponent(btnRegistarAmbiente)
                    .addComponent(btnListarAmbiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Ambiente, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardAmbienteLayout = new javax.swing.GroupLayout(cardAmbiente);
        cardAmbiente.setLayout(cardAmbienteLayout);
        cardAmbienteLayout.setHorizontalGroup(
            cardAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAmbienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFormAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardAmbienteLayout.setVerticalGroup(
            cardAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAmbienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFormAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel1.add(cardAmbiente, "AMBIENTE");

        lbNome.setText("Nome");

        txtNome.setPreferredSize(new java.awt.Dimension(125, 25));

        txtPeso.setPreferredSize(new java.awt.Dimension(125, 25));

        lbPeso.setText("Peso");

        txtIdade.setPreferredSize(new java.awt.Dimension(125, 25));

        lbIdade.setText("Idade");

        lbRaca.setText("Raça");

        txtRaca.setPreferredSize(new java.awt.Dimension(120, 25));

        lbLinhagem.setText("Linhagem");

        cbLinhagem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LEITE", "CARNE", "DUPLA_APTIDAO" }));
        cbLinhagem.setPreferredSize(new java.awt.Dimension(125, 25));
        cbLinhagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhagemActionPerformed(evt);
            }
        });

        lbProducaoDeLeite.setText("Produção de Leite");

        txtProducao.setPreferredSize(new java.awt.Dimension(125, 25));

        btnApagarAnimal.setText("Apagar");

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
        Animal.setViewportView(AnimalTable);
        if (AnimalTable.getColumnModel().getColumnCount() > 0) {
            AnimalTable.getColumnModel().getColumn(5).setResizable(false);
            AnimalTable.getColumnModel().getColumn(5).setHeaderValue("Idade (Anos)");
            AnimalTable.getColumnModel().getColumn(6).setResizable(false);
            AnimalTable.getColumnModel().getColumn(6).setHeaderValue("Produção de Leite (Litros)");
        }

        javax.swing.GroupLayout panelFormAnimalLayout = new javax.swing.GroupLayout(panelFormAnimal);
        panelFormAnimal.setLayout(panelFormAnimalLayout);
        panelFormAnimalLayout.setHorizontalGroup(
            panelFormAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormAnimalLayout.createSequentialGroup()
                .addGroup(panelFormAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormAnimalLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnApagarAnimal)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistarAnimal)
                        .addGap(18, 18, 18)
                        .addComponent(btnListarAnimal))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormAnimalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelFormAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Animal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelFormAnimalLayout.createSequentialGroup()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(lbLinhagem)
                                .addGap(18, 18, 18)
                                .addComponent(cbLinhagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbProducaoDeLeite, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtProducao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelFormAnimalLayout.setVerticalGroup(
            panelFormAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormAnimalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelFormAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPeso)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIdade)
                    .addComponent(lbRaca)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLinhagem)
                    .addComponent(cbLinhagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbProducaoDeLeite)
                    .addComponent(txtProducao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApagarAnimal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnListarAnimal)
                        .addComponent(btnRegistarAnimal)))
                .addGap(18, 18, 18)
                .addComponent(Animal, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        lbNome.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout cardAnimalLayout = new javax.swing.GroupLayout(cardAnimal);
        cardAnimal.setLayout(cardAnimalLayout);
        cardAnimalLayout.setHorizontalGroup(
            cardAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAnimalLayout.createSequentialGroup()
                .addComponent(panelFormAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        cardAnimalLayout.setVerticalGroup(
            cardAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAnimalLayout.createSequentialGroup()
                .addComponent(panelFormAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jPanel1.add(cardAnimal, "ANIMAL");
        cardAnimal.getAccessibleContext().setAccessibleName("");

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

    }//GEN-LAST:event_DadosMenuSelected

    private void LogoutMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_LogoutMenuSelected

    }//GEN-LAST:event_LogoutMenuSelected

    private void avaliacoesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaliacoesItemActionPerformed
        mostrarCard("AVALIACOES");
        carregarAmbientesNoCombo(); // carrega os ambientes ao abrir o painel
        listarAvaliacoes();
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
    private void registarAnimal() {
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
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 3) Converter numéricos
            double peso = Double.parseDouble(pesoTxt);
            int idade = Integer.parseInt(idadeTxt);
            double producao = Double.parseDouble(producaoTxt);

            // 4) Inserir na BD
            animalService.registarBovino(nome, peso, idade, raca, linhagem, producao);

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
                    "Erro ao registar:" + e.getMessage(),
                    "Dados inválidos",
                    JOptionPane.WARNING_MESSAGE);

        } catch (exception.ConexaoBDException e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Erro BD",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Evento do botão "Registar" do Ambiente.
     *
     * Lê os valores digitados pelo utilizador Valida se não estão vazios
     * Converte temperatura e umidade para número Chama o Service para guardar
     * no banco Limpa o formulário e atualiza a tabela
     */
    private void registarAmbientes() {
        try {

            // Ler valores da interface
            String local = txtLocal.getText().trim();
            String tempTxt = txtTemperatura.getText().trim();
            String umidTxt = txtUmidade.getText().trim();

            // Validação simples de campos obrigatórios
            if (local.isEmpty() || tempTxt.isEmpty() || umidTxt.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Preencha Local, Temperatura e Umidade.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            // Converter valores numéricos
            double temperatura = Double.parseDouble(tempTxt);
            double umidade = Double.parseDouble(umidTxt);

            // Chamar camada service
            ambienteService.registar(temperatura, umidade, local);

            JOptionPane.showMessageDialog(this,
                    "Ambiente registado com sucesso!");

            // Limpar campos e atualizar tabela
            limparCamposAmbiente();
            listarAmbientes();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Temperatura e Umidade devem ser números válidos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } catch (DadosInvalidosException e) {

            JOptionPane.showMessageDialog(this,
                    "Erro ao registar ambiente: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Lista os animais na JTable usando a view vw_bovinos_completos.
     */
    private void listarAnimais() {
        try {

            // buscar lista de bovinos
            ArrayList<Bovino> lista = animalService.listarBovinos();

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
                    "Erro BD",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Lista os animais na JTable usando a view vw_bovinos_completos.
     */
    private void listarAmbientes() {

        try {

            ArrayList<Ambiente> lista = ambienteService.listarTodos();

            DefaultTableModel model
                    = (DefaultTableModel) AmbienteTable.getModel();

            model.setRowCount(0);

            for (Ambiente a : lista) {

                model.addRow(new Object[]{
                    a.getId(),
                    a.getTemperatura(),
                    a.getUmidade(),
                    a.getLocal(),
                    a.getDataRegisto()
                });

            }

        } catch (ConexaoBDException e) {

            JOptionPane.showMessageDialog(this,
                    "Erro ao listar ambientes: " + e.getMessage());

        }
    }

    /**
     * Lista todas as avaliações na JTable do painel. Exibe: Animal | Local |
     * ITU | Resultado | Data
     */
    private void listarAvaliacoes() {
        try {
            ArrayList<Avaliacao> lista = avaliacaoService.listarTodos();

            // Definir os cabeçalhos da tabela
            String[] colunas = {"Animal", "Local", "ITU", "Resultado", "Data"};

            // Preencher as linhas com os dados
            Object[][] dados = new Object[lista.size()][5];

            for (int i = 0; i < lista.size(); i++) {
                Avaliacao av = lista.get(i);
                dados[i][0] = av.getNomeAnimal();
                dados[i][1] = av.getLocalAmbiente();
                dados[i][2] = String.format("%.2f", av.getValorItu());
                dados[i][3] = av.getResultado();
                dados[i][4] = av.getDataAvaliacao() != null
                        ? av.getDataAvaliacao().toString().replace("T", " ")
                        : "-";
            }

            // Aplicar os dados na tabela (não editável pelo utilizador)
            avaliacoesTable.setModel(new javax.swing.table.DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // impede edição direta na tabela
                }
            });

        } catch (ConexaoBDException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao listar avaliações: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Gera automaticamente avaliações de conforto térmico (ITU) para todos os
     * bovinos registados, usando o ambiente selecionado no JComboBox.
     *
     * Fluxo do método:
     *
     * Obtém o texto do ambiente selecionado no JComboBox Pesquisa o objeto
     * Ambiente correspondente na base de dados Carrega todos os bovinos
     * registados Chama o service para calcular o ITU e gerar as avaliações
     * Atualiza a tabela com os novos resultados
     *
     * Possíveis resultados do ITU
     *
     * CONFORTO → ITU menor que 72 ALERTA → ITU entre 72 e 79 ESTRESSE → ITU
     * maior ou igual a 79
     *
     * @throws DadosInvalidosException se a lista de bovinos ou o ambiente forem
     * inválidos.
     * @throws ConexaoBDException se ocorrer erro de comunicação com a base de
     * dados.
     */
    private void gerarAvaliacoes() {
        try {
            // 1. Obter o texto selecionado no combo
            String textoSelecionado = (String) cbAmbiente.getSelectedItem();

            if (textoSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Selecione um ambiente.");
                return;
            }

            // 2. Buscar o objeto Ambiente correspondente ao texto selecionado
            Ambiente ambienteSelecionado = null;
            ArrayList<Ambiente> ambientes = ambienteService.listarTodos();

            for (Ambiente a : ambientes) {
                if (a.toString().equals(textoSelecionado)) {
                    ambienteSelecionado = a; // encontrou o ambiente correto
                    break;
                }
            }

            if (ambienteSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Ambiente não encontrado.");
                return;
            }

            // 3. Buscar todos os bovinos registados na base de dados
            ArrayList<Bovino> listaBovinos = bovinoService.listarTodos();

            // 4. Gerar avaliações para cada bovino com o ambiente selecionado
            int total = avaliacaoService.gerarAvaliacoes(listaBovinos, ambienteSelecionado);

            JOptionPane.showMessageDialog(this, total + " avaliação(ões) gerada(s) com sucesso!");

            // 5. Atualizar a tabela para mostrar os novos resultados
            listarAvaliacoes();

        } catch (DadosInvalidosException | ConexaoBDException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    /**
     * Carrega os ambientes disponíveis no JComboBox de seleção. É chamado ao
     * entrar no painel de avaliações.
     */
    private void carregarAmbientesNoCombo() {
        try {
            // Limpar o combo antes de preencher
            cbAmbiente.removeAllItems();

            ArrayList<Ambiente> lista = ambienteService.listarTodos();

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Nenhum ambiente registado. Registe um ambiente primeiro.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Adicionar cada ambiente como opção no combo
            for (Ambiente a : lista) {
                // Exibe: "Estábulo Principal (28.5°C / 75.0%)"
                cbAmbiente.addItem(a.toString());
            }

        } catch (ConexaoBDException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar ambientes: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Evento do botão "Registar Ambiente".
     *
     * Lê os campos da tela, valida, converte para número e chama o service.
     * Depois atualiza a tabela.
     */
    private void btnRegistarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarAnimalActionPerformed
        registarAnimal();
    }//GEN-LAST:event_btnRegistarAnimalActionPerformed

    private void btnListarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAnimalActionPerformed
        listarAnimais();
    }//GEN-LAST:event_btnListarAnimalActionPerformed

    private void btnRegistarAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarAmbienteActionPerformed
        registarAmbientes();
    }//GEN-LAST:event_btnRegistarAmbienteActionPerformed

    private void btnListarAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAmbienteActionPerformed
        listarAmbientes();
    }//GEN-LAST:event_btnListarAmbienteActionPerformed

    private void btnGerarAvaliacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarAvaliacoesActionPerformed
        gerarAvaliacoes();
    }//GEN-LAST:event_btnGerarAvaliacoesActionPerformed

    private void btnListarAvaliacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAvaliacoesActionPerformed
        listarAvaliacoes();
    }//GEN-LAST:event_btnListarAvaliacoesActionPerformed

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
    private javax.swing.JScrollPane Ambiente;
    private javax.swing.JTable AmbienteTable;
    private javax.swing.JScrollPane Animal;
    private javax.swing.JTable AnimalTable;
    private javax.swing.JScrollPane Avaliacoes;
    private javax.swing.JMenu Dados;
    private javax.swing.JMenu Home;
    private javax.swing.JMenu Logout;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem ambienteItem;
    private javax.swing.JMenuItem animalItem;
    private javax.swing.JMenuItem avaliacoesItem;
    private javax.swing.JTable avaliacoesTable;
    private javax.swing.JButton btnApagarAmbiente;
    private javax.swing.JButton btnApagarAnimal;
    private javax.swing.JButton btnGerarAvaliacoes;
    private javax.swing.JButton btnListarAmbiente;
    private javax.swing.JButton btnListarAnimal;
    private javax.swing.JButton btnListarAvaliacoes;
    private javax.swing.JButton btnRegistarAmbiente;
    private javax.swing.JButton btnRegistarAnimal;
    private javax.swing.JPanel cardAmbiente;
    private javax.swing.JPanel cardAnimal;
    private javax.swing.JPanel cardAvaliacoes;
    private javax.swing.JPanel cardHome;
    private javax.swing.JComboBox<String> cbAmbiente;
    private javax.swing.JComboBox<String> cbLinhagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAmbientes;
    private javax.swing.JLabel lbIdade;
    private javax.swing.JLabel lbLinhagem;
    private javax.swing.JLabel lbLocal;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPeso;
    private javax.swing.JLabel lbProducaoDeLeite;
    private javax.swing.JLabel lbRaca;
    private javax.swing.JLabel lbTemperatura;
    private javax.swing.JLabel lbUmidade;
    private javax.swing.JPanel panelFormAmbiente;
    private javax.swing.JPanel panelFormAnimal;
    private javax.swing.JPanel panelFormAvaliacoes;
    private javax.swing.JMenuItem sairItem;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtProducao;
    private javax.swing.JTextField txtRaca;
    private javax.swing.JTextField txtTemperatura;
    private javax.swing.JTextField txtUmidade;
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

    /**
     * Limpa os campos do formulário de Ambiente.
     *
     * Este método é chamado após registar um ambiente, para facilitar o próximo
     * registo.
     */
    private void limparCamposAmbiente() {
        txtLocal.setText("");
        txtTemperatura.setText("");
        txtUmidade.setText("");
        txtLocal.requestFocus();
    }

    /**
     * Inicializa o painel Home com uma mensagem de boas-vindas simples.
     */
    private void inicializarHome() {
        cardHome.setLayout(new java.awt.GridBagLayout());
        cardHome.setBackground(new java.awt.Color(245, 250, 240));
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        // Ícone
        javax.swing.JLabel lblIcone = new javax.swing.JLabel("🐄", javax.swing.SwingConstants.CENTER);
        lblIcone.setFont(new java.awt.Font("Segoe UI Emoji", java.awt.Font.PLAIN, 60));
        gbc.gridy = 0;
        cardHome.add(lblIcone, gbc);

        // Título
        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("Bem-vindo ao ConfortAnimal", javax.swing.SwingConstants.CENTER);
        lblTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22));
        lblTitulo.setForeground(new java.awt.Color(34, 85, 34));
        gbc.gridy = 1;
        cardHome.add(lblTitulo, gbc);

        // Subtítulo
        javax.swing.JLabel lblSub = new javax.swing.JLabel("Usa o menu de Dados para gerir animais, ambientes e avaliações.", javax.swing.SwingConstants.CENTER);
        lblSub.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
        lblSub.setForeground(new java.awt.Color(100, 100, 100));
        gbc.gridy = 2;
        cardHome.add(lblSub, gbc);
    }
}

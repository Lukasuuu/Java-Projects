
package apresentation;

import exception.ConexaoBDException;
import exception.DadosInvalidosException;
import javax.swing.JOptionPane;
import model.Utilizador;
import service.UtilizadorService;

/**
 *  * Classe Login - Interface gráfica para autenticação de utilizadores. 
 * Permite o acesso ao sistema ConfortAnimal mediante nome de utilizador e senha válidos.
 * Após login bem-sucedido, redireciona para a tela principal.
 *
 * Esta classe utiliza Swing (JFrame) e foi parcialmente gerada por IDE.
 * 
 * @author Lucas Gonçalves
 * @version 1.0
 * @since 2026-03-06
 */
public class Login extends javax.swing.JFrame {

    private final UtilizadorService usuario = new UtilizadorService();

    /**
     * Construtor padrão da janela de login.
     */
    public Login() {
        initComponents();
        // Permite pressionar Enter para fazer login
        getRootPane().setDefaultButton(btnGuardar);
        setLocationRelativeTo(null);
        setTitle("ConfortAnimal - Login");
        
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        passwordPanel = new javax.swing.JPanel();
        lbPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lbNome = new javax.swing.JLabel();
        txtUtilizador = new javax.swing.JFormattedTextField();
        btnGuardar = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        lbNome1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbPassword.setText("Senha:");

        lbNome.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbNome.setText("Utilizador:");

        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnGuardar.setText("Entrar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lbLogin.setBackground(new java.awt.Color(0, 0, 0));
        lbLogin.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Login.png"))); // NOI18N
        lbLogin.setToolTipText("");

        btnSair.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lbNome1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lbNome1.setText("Login:");

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(passwordPanelLayout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(passwordPanelLayout.createSequentialGroup()
                                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUtilizador, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                    .addComponent(txtPassword)))))
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(lbNome1))
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Faz o login no sistema. - Lê os campos da tela - Chama o UsuarioDB para
     * validar no banco - Se der certo, abre a tela principal - Se der errado,
     * mostra mensagem e não abre o sistema
     */
    private void fazerLogin() {

        // 1) Ler os campos
        String username = txtUtilizador.getText().trim();
        String password = new String(txtPassword.getPassword());

        // 2) Validar no banco
        try {
            Utilizador u = usuario.autenticar(username, password);

            // 3) Se u == null, login inválido
            if (u == null) {
                JOptionPane.showMessageDialog(this,
                        "Utilizador ou password incorretos.",
                        "Login inválido",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 4) Login OK
            JOptionPane.showMessageDialog(this,
                    "Bem-vindo, " + u.getUsername() + "!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            // 5) Abrir a janela principal e fechar o login
            ConfortAnimal janela = new ConfortAnimal();
            janela.setVisible(true);

            dispose();

        } catch (DadosInvalidosException e) {
            // Campos vazios (lançado no UsuarioDB)
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE);

        } catch (ConexaoBDException e) {
            // Erro de banco/conexão
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Erro de Base de Dados",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Ação do botão Entrar (antes chamado btnGuardar)
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        fazerLogin();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
       dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSair;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNome1;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JFormattedTextField txtUtilizador;
    // End of variables declaration//GEN-END:variables

}

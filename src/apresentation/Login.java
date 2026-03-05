package apresentation;

import exception.ConexaoBDException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import persistence.UsuarioDB;
import service.UsuarioService;

/**
 * Classe Login - Interface gráfica para autenticação de utilizadores. Permite o
 * acesso ao sistema ConfortAnimal mediante nome de utilizador e senha válidos.
 * Após login bem-sucedido, redireciona para a tela principal.
 *
 * Esta classe utiliza Swing (JFrame) e foi parcialmente gerada por IDE.
 *
 * @author Lucas
 */
public class Login extends javax.swing.JFrame {

    private final UsuarioService usuarioService = new UsuarioService();

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

    /**
     * Construtor auxiliar (caso seja necessário receber parâmetros).
     *
     * @param aThis Referência à janela principal.
     * @param b Flag de controle (não utilizado).
     */


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        passwordPanel = new javax.swing.JPanel();
        lbPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lbNome = new javax.swing.JLabel();
        txtUtilizador = new javax.swing.JFormattedTextField();
        btnGuardar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbPassword.setText("Senha:");

        lbNome.setText("Utilizador:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword)
                    .addComponent(txtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            Usuario u = usuarioService.autenticar(username, password);

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

        } catch (IllegalArgumentException e) {
            // Campos vazios (lançado no UsuarioDB)
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE);

        } catch (exception.ConexaoBDException e) {
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JFormattedTextField txtUtilizador;
    // End of variables declaration//GEN-END:variables

}

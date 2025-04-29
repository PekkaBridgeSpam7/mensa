/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mensa;

import javax.swing.*;
import java.awt.*;
import javax.swing.SwingConstants;

/**
 *
 * @author hp
 */
public class CassaPrincipalee extends javax.swing.JFrame {

    public static boolean cassaAperta = true;

    public static double fondoCassa = 300.0;  
    public static double saldo = 0.0;

    private static CassaPrincipalee instance;
    private static Mensa1 mensa1Instance;

    private static final String PASSWORD = "Berlino2025"; 

    /**
     * Crea una nuova istanza di CassaPrincipalee
     */
    public CassaPrincipalee() {
        initComponents();
        jTextField1.setText("300.00");  
        jTextSaldo.setText("0.00");
        instance = this;
    }

    public static CassaPrincipalee getInstance() {
        if (instance == null) {
            instance = new CassaPrincipalee();
        }
        return instance;
    }

    /**
     * Questo metodo viene chiamato dal costruttore per inizializzare il form.
     * ATTENZIONE: NON modificare questo codice.
     * Il contenuto di questo metodo viene sempre rigenerato dall'editor del Form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Inizializzazione componenti base
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabelSaldo = new javax.swing.JLabel();
        jTextSaldo = new javax.swing.JTextField();

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Impostazioni del pannello principale
        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        // Definizione stili e font
        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 36));
        jLabel1.setText("Cassa Principale");

        Font labelFont = new java.awt.Font("Segoe UI", Font.BOLD, 24);
        jLabel2.setFont(labelFont);
        jLabel3.setFont(labelFont);
        jLabelSaldo.setFont(labelFont);

        // Configurazione campi di testo e dimensioni
        Font textFieldFont = new java.awt.Font("Segoe UI", Font.BOLD, 24);
        Dimension textFieldSize = new Dimension(150, 40);

        jTextField1.setFont(textFieldFont);
        jTextField3.setFont(textFieldFont);
        jTextSaldo.setFont(textFieldFont);

        jTextField1.setPreferredSize(textFieldSize);
        jTextField3.setPreferredSize(textFieldSize);
        jTextSaldo.setPreferredSize(textFieldSize);

        // Configurazione pulsanti
        Font buttonFont = new java.awt.Font("Segoe UI", Font.BOLD, 20);
        Dimension buttonSize = new Dimension(200, 50);

        jButton1.setFont(buttonFont);
        jButton2.setFont(buttonFont);
        jButton3.setFont(buttonFont);
        jButton4.setFont(buttonFont);
        jButton5.setFont(buttonFont);

        jButton1.setPreferredSize(buttonSize);
        jButton2.setPreferredSize(buttonSize);
        jButton3.setPreferredSize(buttonSize);
        jButton4.setPreferredSize(buttonSize);
        jButton5.setPreferredSize(buttonSize);

        jButton1.setText("DEPOSITA");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    double importo = Double.parseDouble(jTextField3.getText());
                    updateFondoCassa(importo, false); // false = not a sale
                    jTextField3.setText("");
                    JOptionPane.showMessageDialog(null, "Deposito effettuato con successo");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Inserire un importo valido", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jButton2.setText("PRELEVA");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    double importo = Double.parseDouble(jTextField3.getText());
                    if (importo > fondoCassa) {
                        JOptionPane.showMessageDialog(null, "Fondi insufficienti", "Errore", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    updateFondoCassa(-importo, false); // false = not a sale
                    jTextField3.setText("");
                    JOptionPane.showMessageDialog(null, "Prelievo effettuato con successo");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Inserire un importo valido", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jLabel2.setText("FONDO CASSA:");

        jTextField1.setText("300.00");
        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("APRI CASSA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPasswordField pf = new JPasswordField();
                int result = JOptionPane.showConfirmDialog(null, pf, "Inserisci password:",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if (result == JOptionPane.OK_OPTION) {
                    String password = new String(pf.getPassword());
                    if (password.equals(PASSWORD)) {
                        cassaAperta = true;
                        jButton1.setEnabled(true);
                        jButton2.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Cassa Aperta");
                    } else {
                        JOptionPane.showMessageDialog(null, "Password errata!", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        jButton4.setText("CHIUDI CASSA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cassaAperta = false;
                jButton1.setEnabled(false);  // Disabilita il pulsante DEPOSITA
                jButton2.setEnabled(false);  // Disabilita il pulsante PRELEVA
                JOptionPane.showMessageDialog(null, "Cassa Chiusa");
            }
        });

        jButton5.setText("VAI AL MENU");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
                if (mensa1Instance == null) {
                    mensa1Instance = new Mensa1();
                }
                mensa1Instance.setVisible(true);
            }
        });

        jLabel3.setText("IMPORTO:");
        jLabel3.setPreferredSize(new Dimension(100, jLabel3.getPreferredSize().height));

        jLabelSaldo.setText("SALDO:");
        jTextSaldo.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)  // Increased from 20/30 to 100 to move title right
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(50, 50, 50)
                        .addComponent(jButton5)
                        .addGap(50, 50, 50)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabelSaldo)
                        .addGap(20, 20, 20)
                        .addComponent(jTextSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)
                        .addGap(50, 50, 50)
                        .addComponent(jButton1)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton3))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSaldo)
                    .addComponent(jTextSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        setLocationRelativeTo(null); // Centra il frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Gestione evento per jTextField1
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Gestione evento per jTextField2
    }

    /**
     * Metodo per aggiornare sia il fondo cassa che le operazioni di vendita
     */
    public static void updateFondoCassa(double amount, boolean isSale) {
        fondoCassa += amount;
        if (isSale) {
            saldo += amount;
        }
        java.awt.EventQueue.invokeLater(() -> {
            for (Window window : Window.getWindows()) {
                if (window instanceof CassaPrincipalee) {
                    CassaPrincipalee instance = (CassaPrincipalee) window;
                    instance.jTextField1.setText(String.format("%.2f", fondoCassa));
                    instance.jTextSaldo.setText(String.format("%.2f", saldo));
                }
            }
        });
    }

    /**
     * @param args argomenti dalla riga di comando
     */
    public static void main(String args[]) {
        /* Imposta il look and feel Nimbus */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CassaPrincipalee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CassaPrincipalee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CassaPrincipalee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CassaPrincipalee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Crea e visualizza il form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CassaPrincipalee().setVisible(true);
            }
        });
    }

    // Dichiarazione variabili
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextSaldo;
}

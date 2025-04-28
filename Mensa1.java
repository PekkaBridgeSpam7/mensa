package mensa;

import java.awt.*;
import java.util.Random;
import java.util.function.BiConsumer;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Mensa1 extends javax.swing.JFrame {
    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton backButton; 
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;

    private ButtonGroup primiGroup = new ButtonGroup();
    private ButtonGroup secondiGroup = new ButtonGroup();
    private ButtonGroup contorniGroup = new ButtonGroup();
    private ButtonGroup dessertGroup = new ButtonGroup();
    private ButtonGroup bevandeGroup = new ButtonGroup();

    private JSpinner[] spinners;

    // Add these static variables at the class level
    private static int scontiRimasti = 10;
    private static final double PERCENTUALE_SCONTO = 0.10; 
    private static final double PROBABILITA_SCONTO = 0.3; 
    private static Random random = new Random();

    private static final int SPINNER_X_POSITION = 450; 
    private static final int SPINNER_WIDTH = 70;
    private static final int SPINNER_HEIGHT = 25;

    public Mensa1() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("control", new Color(245, 245, 245));
            UIManager.put("nimbusBase", new Color(51, 98, 140));
            UIManager.put("nimbusBlueGrey", new Color(169, 176, 190));
            UIManager.put("nimbusFocus", new Color(115, 164, 209));
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        setupButtonGroups();
        setupFrame();
        customizeComponents();
    }

    private void setupButtonGroups() {
        // Primi piatti
        primiGroup.add(jRadioButton1);
        jRadioButton1.addActionListener(e -> spinners[0].setValue(1));

        primiGroup.add(jRadioButton2);
        jRadioButton2.addActionListener(e -> spinners[1].setValue(1));

        primiGroup.add(jRadioButton3);
        jRadioButton3.addActionListener(e -> spinners[2].setValue(1));

        // Secondi piatti
        secondiGroup.add(jRadioButton4);
        jRadioButton4.addActionListener(e -> spinners[3].setValue(1));

        secondiGroup.add(jRadioButton5);
        jRadioButton5.addActionListener(e -> spinners[4].setValue(1));

        secondiGroup.add(jRadioButton6);
        jRadioButton6.addActionListener(e -> spinners[5].setValue(1));

        // Contorni
        contorniGroup.add(jRadioButton7);
        jRadioButton7.addActionListener(e -> spinners[6].setValue(1));

        contorniGroup.add(jRadioButton8);
        jRadioButton8.addActionListener(e -> spinners[7].setValue(1));

        contorniGroup.add(jRadioButton9);
        jRadioButton9.addActionListener(e -> spinners[8].setValue(1));

        // Dessert
        dessertGroup.add(jRadioButton13);
        jRadioButton13.addActionListener(e -> spinners[9].setValue(1));

        dessertGroup.add(jRadioButton14);
        jRadioButton14.addActionListener(e -> spinners[10].setValue(1));

        dessertGroup.add(jRadioButton15);
        jRadioButton15.addActionListener(e -> spinners[11].setValue(1));

        // Bevande
        bevandeGroup.add(jRadioButton16);
        jRadioButton16.addActionListener(e -> spinners[12].setValue(1));

        bevandeGroup.add(jRadioButton17);
        jRadioButton17.addActionListener(e -> spinners[13].setValue(1));

        bevandeGroup.add(jRadioButton18);
        jRadioButton18.addActionListener(e -> spinners[14].setValue(1));
    }

    private void setupFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        pack();
    }

    private void customizeComponents() {
        // Personalizzazione del pannello principale
        jPanel1.setBackground(new Color(255, 250, 240)); // Colore crema chiaro

        // Personalizzazione del titolo
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 36));
        jLabel2.setForeground(new Color(139, 69, 19)); // Marrone scuro

        // Personalizzazione dei pulsanti
        customizeButton(jButton1, new Color(76, 175, 80), Color.WHITE, "Conferma Ordine");
        customizeButton(resetButton, new Color(244, 67, 54), Color.WHITE, "Annulla");
        customizeButton(backButton, new Color(63, 81, 181), Color.WHITE, "← Indietro");

        // Personalizzazione delle categorie
        customizeCategoryLabel(jLabel11, "Primi Piatti");
        customizeCategoryLabel(jLabel12, "Secondi Piatti");
        customizeCategoryLabel(jLabel13, "Contorni");
        customizeCategoryLabel(jLabel7, "Dessert");
        customizeCategoryLabel(jLabel8, "Bevande");

        // Personalizzazione area scontrino
        jTextArea1.setFont(new Font("Consolas", Font.PLAIN, 14));
        jTextArea1.setBackground(new Color(255, 255, 250));
        jScrollPane1.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(139, 69, 19), 2),
            "Riepilogo Ordine",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14),
            new Color(139, 69, 19)
        ));

        // Personalizzazione radio buttons
        Component[] components = jPanel1.getComponents();
        for (Component comp : components) {
            if (comp instanceof JRadioButton) {
                JRadioButton radio = (JRadioButton) comp;
                radio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                radio.setBackground(new Color(255, 250, 240));
                radio.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        }

        // Personalizzazione spinners
        for (JSpinner spinner : spinners) {
            spinner.setBackground(new Color(255, 255, 255));
            ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setBackground(new Color(255, 255, 255));
            spinner.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 1));
        }
    }

    private void customizeButton(JButton button, Color bgColor, Color fgColor, String text) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setText(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
    }

    private void customizeCategoryLabel(JLabel label, String text) {
        label.setText(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(new Color(139, 69, 19));
        label.setBorder(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        calculateTotal();
    }

    private int getQuantity(JSpinner spinner) {
        return (Integer) spinner.getValue();
    }

    private void calculateTotal() {
        if (!CassaPrincipalee.cassaAperta) {
            JOptionPane.showMessageDialog(this, "La cassa è chiusa! Impossibile effettuare ordini.",
                "Cassa Chiusa", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double totale = 0;
        StringBuilder receipt = new StringBuilder();
        receipt.append("          Mensa da Salvatore          \n");
        receipt.append("             Via Irno n7              \n");
        receipt.append("=====================================\n");
        receipt.append("PIATTO                         PREZZO\n");
        receipt.append("-------------------------------------\n");

        jTextArea1.setFont(new Font("Courier New", Font.PLAIN, 12));

        // Metodo helper per formattare le righe
        BiConsumer<String, Double> addItem = (item, price) -> {
            receipt.append(String.format("%-30s€%7.2f\n", item, price));
        };

        // Check primi piatti
        if (jRadioButton1.isSelected()) {
            int qty = getQuantity(spinners[0]);
            if (qty > 0) {
                double price = 8.50 * qty;
                totale += price;
                addItem.accept(String.format("Pasta al sugo (x%d)", qty), price);
            }
        }
        if (jRadioButton2.isSelected()) {
            int qty = getQuantity(spinners[1]);
            if (qty > 0) {
                double price = 9.00 * qty;
                totale += price;
                addItem.accept(String.format("Pasta e pesto (x%d)", qty), price);
            }
        }
        if (jRadioButton3.isSelected()) {
            int qty = getQuantity(spinners[2]);
            if (qty > 0) {
                double price = 9.50 * qty;
                totale += price;
                addItem.accept(String.format("Pasta e patate (x%d)", qty), price);
            }
        }

        // Check secondi piatti
        if (jRadioButton4.isSelected()) {
            int qty = getQuantity(spinners[3]);
            if (qty > 0) {
                double price = 12.00 * qty;
                totale += price;
                addItem.accept(String.format("Cotoletta (x%d)", qty), price);
            }
        }
        if (jRadioButton5.isSelected()) {
            int qty = getQuantity(spinners[4]);
            if (qty > 0) {
                double price = 11.00 * qty;
                totale += price;
                addItem.accept(String.format("Salsiccia (x%d)", qty), price);
            }
        }
        if (jRadioButton6.isSelected()) {
            int qty = getQuantity(spinners[5]);
            if (qty > 0) {
                double price = 13.00 * qty;
                totale += price;
                addItem.accept(String.format("Bastoncini di pesce (x%d)", qty), price);
            }
        }

        // Check contorni
        if (jRadioButton7.isSelected()) {
            int qty = getQuantity(spinners[6]);
            if (qty > 0) {
                double price = 4.50 * qty;
                totale += price;
                addItem.accept(String.format("Patatine (x%d)", qty), price);
            }
        }
        if (jRadioButton8.isSelected()) {
            int qty = getQuantity(spinners[7]);
            if (qty > 0) {
                double price = 4.00 * qty;
                totale += price;
                addItem.accept(String.format("Insalata (x%d)", qty), price);
            }
        }
        if (jRadioButton9.isSelected()) {
            int qty = getQuantity(spinners[8]);
            if (qty > 0) {
                double price = 4.50 * qty;
                totale += price;
                addItem.accept(String.format("Broccoli (x%d)", qty), price);
            }
        }

        // Check dessert 
        if (jRadioButton13.isSelected()) {
            int qty = getQuantity(spinners[9]);
            if (qty > 0) {
                double price = 1.50 * qty;
                totale += price;
                addItem.accept(String.format("Banana (x%d)", qty), price);
            }
        }
        if (jRadioButton14.isSelected()) {
            int qty = getQuantity(spinners[10]);
            if (qty > 0) {
                double price = 5.00 * qty;
                totale += price;
                addItem.accept(String.format("Tortino al cioccolato (x%d)", qty), price);
            }
        }
        if (jRadioButton15.isSelected()) {
            int qty = getQuantity(spinners[11]);
            if (qty > 0) {
                double price = 4.00 * qty;
                totale += price;
                addItem.accept(String.format("Gelato alla fragola (x%d)", qty), price);
            }
        }

        // Check bevande 
        if (jRadioButton16.isSelected()) {
            int qty = getQuantity(spinners[12]);
            if (qty > 0) {
                double price = 1.00 * qty;
                totale += price;
                addItem.accept(String.format("Acqua (x%d)", qty), price);
            }
        }
        if (jRadioButton17.isSelected()) {
            int qty = getQuantity(spinners[13]);
            if (qty > 0) {
                double price = 3.50 * qty;
                totale += price;
                addItem.accept(String.format("Birra (x%d)", qty), price);
            }
        }
        if (jRadioButton18.isSelected()) {
            int qty = getQuantity(spinners[14]);
            if (qty > 0) {
                double price = 4.00 * qty;
                totale += price;
                addItem.accept(String.format("Vino (x%d)", qty), price);
            }
        }

        receipt.append("=====================================\n");
        receipt.append(String.format("%-30s€%7.2f\n", "TOTALE:", totale));

        // Applica sconto casuale se ci sono ancora sconti disponibili
        if (scontiRimasti > 0 && random.nextDouble() < PROBABILITA_SCONTO) {
            double sconto = totale * PERCENTUALE_SCONTO;
            totale = totale - sconto;
            scontiRimasti--;

            receipt.append("=====================================\n");
            receipt.append(String.format("%-30s€%7.2f\n", "SCONTO 10%:", sconto));
            receipt.append(String.format("%-30s€%7.2f", "TOTALE SCONTATO:", totale));
            receipt.append("\n** Congratulazioni! Hai vinto uno sconto! **\n");
            receipt.append(String.format("Sconti rimasti: %d", scontiRimasti));
        } else {
            receipt.append(String.format("%-30s€%7.2f", "TOTALE:", totale));
        }

        jTextArea1.setText(receipt.toString());

        CassaPrincipalee.updateFondoCassa(totale);
    }

    private void resetAll() {
        primiGroup.clearSelection();
        secondiGroup.clearSelection();
        contorniGroup.clearSelection();
        dessertGroup.clearSelection();
        bevandeGroup.clearSelection();

        // Reset all spinners to 0
        for (JSpinner spinner : spinners) {
            spinner.setValue(0);
        }

        // Clear the text area
        jTextArea1.setText("");
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        // Add back button
        backButton = new javax.swing.JButton();
        backButton.setText("Torna Indietro");
        backButton.setFont(new Font("Arial", Font.PLAIN, 12));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
                CassaPrincipalee.getInstance().setVisible(true);
            }
        });

        // Inizializza spinners 
        spinners = new JSpinner[15];
        for (int i = 0; i < 15; i++) {
            spinners[i] = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
            
            // Set size for all spinners
            Dimension spinnerSize = new Dimension(70, 25);
            spinners[i].setPreferredSize(spinnerSize);
            spinners[i].setMinimumSize(spinnerSize);
            spinners[i].setMaximumSize(spinnerSize);
            
            // Create a container panel for fixed positioning
            JPanel spinnerContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
            spinnerContainer.setOpaque(false);
            spinnerContainer.add(Box.createHorizontalStrut(600)); 
            spinnerContainer.add(spinners[i]);
            jPanel1.add(spinnerContainer);
            
            // Style the spinner
            spinners[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            ((JSpinner.DefaultEditor) spinners[i].getEditor()).getTextField().setHorizontalAlignment(JTextField.CENTER);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRadioButton1.setText("Pasta al sugo (€8.50)");
        jRadioButton2.setText("Pata e pesto (€9.00)");
        jRadioButton3.setText("Pasta e patate (€9.50)");
        jRadioButton4.setText("Cotoletta (€12.00)");
        jRadioButton5.setText("Salsiccia (€11.00)");
        jRadioButton6.setText("Bastoncini di pesce (€13.00)");
        jRadioButton7.setText("Patatine (€4.50)");
        jRadioButton8.setText("Insalata (€4.00)");
        jRadioButton9.setText("Broccoli (€4.50)");
        jRadioButton13.setText("Banana (€1.50)");
        jRadioButton14.setText("Tortino al cioccolato (€5.00)");
        jRadioButton15.setText("Gelato alla fragola (€4.00)");
        jRadioButton16.setText("Acqua (€1.00)");
        jRadioButton17.setText("Birra (€3.50)");
        jRadioButton18.setText("Vino (€4.00)");

        jLabel2.setFont(new java.awt.Font("Rockwell", Font.BOLD | Font.ITALIC, 36));
        jLabel2.setText("Mensa da Salvatore");

        jLabel11.setFont(new java.awt.Font("Arial Black", Font.BOLD, 18));
        jLabel11.setText("Primi Piatti");

        jLabel12.setFont(new java.awt.Font("Arial Black", Font.BOLD, 18));
        jLabel12.setText("Secondi Piatti");

        jLabel13.setFont(new java.awt.Font("Arial Black", Font.BOLD, 18));
        jLabel13.setText("Contorni");

        jLabel7.setFont(new java.awt.Font("Arial Black", Font.BOLD, 18));
        jLabel7.setText("Frutta o Dessert");

        jLabel8.setFont(new java.awt.Font("Arial Black", Font.BOLD, 18));
        jLabel8.setText("Bevande");

        jLabel9.setFont(new java.awt.Font("Arial Black", Font.BOLD, 12));
        jLabel9.setText("Totale:");

        jTextArea1.setColumns(20);  
        jTextArea1.setRows(8);      
        jScrollPane1.setPreferredSize(new Dimension(300, 400));  
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Paga");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!CassaPrincipalee.cassaAperta) {
                    JOptionPane.showMessageDialog(null, "La cassa è chiusa! Impossibile effettuare ordini.",
                        "Cassa Chiusa", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                jButton1ActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.setBackground(new java.awt.Color(128, 128, 128));
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetAll();
            }
        });

        // Layout code
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(backButton) // Added back button to layout
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[0]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[1]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addGap(300, 300, 300) 
                        .addComponent(spinners[2]))
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[3]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton5)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[4]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton6)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[5]))
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton7)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[6]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton8)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[7]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton9)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[8]))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton13)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[9]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton14)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[10]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton15)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[11]))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton16)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[12]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton17)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[13]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton18)
                        .addGap(300, 300, 300)  
                        .addComponent(spinners[14])))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(resetButton)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1))))
            .addGap(50, 50, 50)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(backButton)) 
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(spinners[0]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(spinners[1]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(spinners[2]))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(spinners[3]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton5)
                            .addComponent(spinners[4]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton6)
                            .addComponent(spinners[5]))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton7)
                            .addComponent(spinners[6]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton8)
                            .addComponent(spinners[7]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton9)
                            .addComponent(spinners[8]))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton13)
                            .addComponent(spinners[9]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton14)
                            .addComponent(spinners[10]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton15)
                            .addComponent(spinners[11]))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton16)
                            .addComponent(spinners[12]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton17)
                            .addComponent(spinners[13]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton18)
                            .addComponent(spinners[14])))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetButton)
                            .addComponent(jButton1))))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CassaPrincipalee.getInstance().setVisible(true);
        });
    }
}
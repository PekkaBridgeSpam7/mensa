package mensa;

import java.awt.*;
import java.util.Random;
import java.util.function.BiConsumer;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Mensa1 extends javax.swing.JFrame {
    // Dichiarazione variabili UI
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;

    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;

    private javax.swing.JLabel totaleParziale;

    private JSpinner[] spinners;

    // Variabili per la gestione degli sconti
    private static int scontiRimasti = 10;
    private static final double PERCENTUALE_SCONTO = 0.10; 
    private static final double PROBABILITA_SCONTO = 0.3; 
    private static Random random = new Random();

    // Costanti per il posizionamento degli spinner
    private static final int SPINNER_X_POSITION = 450; 
    private static final int SPINNER_WIDTH = 70;
    private static final int SPINNER_HEIGHT = 25;

    public Mensa1() {
        // Configurazione look and feel
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
        // Configurazione listener per le checkbox
        jCheckBox1.addActionListener(e -> {
            spinners[0].setValue(jCheckBox1.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox2.addActionListener(e -> {
            spinners[1].setValue(jCheckBox2.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox3.addActionListener(e -> {
            spinners[2].setValue(jCheckBox3.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox4.addActionListener(e -> {
            spinners[3].setValue(jCheckBox4.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox5.addActionListener(e -> {
            spinners[4].setValue(jCheckBox5.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox6.addActionListener(e -> {
            spinners[5].setValue(jCheckBox6.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox7.addActionListener(e -> {
            spinners[6].setValue(jCheckBox7.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox8.addActionListener(e -> {
            spinners[7].setValue(jCheckBox8.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox9.addActionListener(e -> {
            spinners[8].setValue(jCheckBox9.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox13.addActionListener(e -> {
            spinners[9].setValue(jCheckBox13.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox14.addActionListener(e -> {
            spinners[10].setValue(jCheckBox14.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox15.addActionListener(e -> {
            spinners[11].setValue(jCheckBox15.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox16.addActionListener(e -> {
            spinners[12].setValue(jCheckBox16.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox17.addActionListener(e -> {
            spinners[13].setValue(jCheckBox17.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });

        jCheckBox18.addActionListener(e -> {
            spinners[14].setValue(jCheckBox18.isSelected() ? 1 : 0);
            updateTotaleParziale();
        });
    }

    private void setupFrame() {
        // Configurazione finestra principale
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        pack();
    }

    private void customizeComponents() {
        // Personalizzazione aspetto componenti UI
        jPanel1.setBackground(new Color(255, 250, 240));

        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 42));
        jLabel2.setForeground(new Color(139, 69, 19));

        customizeButton(jButton1, new Color(76, 175, 80), Color.WHITE, "Conferma Ordine");
        customizeButton(resetButton, new Color(244, 67, 54), Color.WHITE, "Annulla");
        customizeButton(backButton, new Color(63, 81, 181), Color.WHITE, "← Indietro");

        customizeCategoryLabel(jLabel11, "Primi Piatti");
        customizeCategoryLabel(jLabel12, "Secondi Piatti");
        customizeCategoryLabel(jLabel13, "Contorni");
        customizeCategoryLabel(jLabel7, "Dessert");
        customizeCategoryLabel(jLabel8, "Bevande");

        jTextArea1.setFont(new Font("Courier New", Font.BOLD, 16));
        jTextArea1.setBackground(new Color(255, 255, 250));
        jScrollPane1.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(139, 69, 19), 2),
            "Riepilogo Ordine",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 16),
            new Color(139, 69, 19)
        ));
        jScrollPane1.setPreferredSize(new Dimension(450, 500));

        JCheckBox[] allCheckBoxes = {
            jCheckBox1, jCheckBox2, jCheckBox3,
            jCheckBox4, jCheckBox5, jCheckBox6,
            jCheckBox7, jCheckBox8, jCheckBox9,
            jCheckBox13, jCheckBox14, jCheckBox15,
            jCheckBox16, jCheckBox17, jCheckBox18
        };

        for (JCheckBox cb : allCheckBoxes) {
            cb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            cb.setBackground(new Color(255, 250, 240));
            cb.setCursor(new Cursor(Cursor.HAND_CURSOR));
            cb.setPreferredSize(new Dimension(250, cb.getPreferredSize().height));
        }

        for (JSpinner spinner : spinners) {
            spinner.setPreferredSize(new Dimension(70, 30));
            spinner.setFont(new Font("Segoe UI", Font.BOLD, 14));
            ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setFont(new Font("Segoe UI", Font.BOLD, 14));
            spinner.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 1));
        }
    }

    private void updateTotaleParziale() {
        double totale = 0;

        // Primi piatti
        if (jCheckBox1.isSelected()) totale += 5.50 * (Integer)spinners[0].getValue();
        if (jCheckBox2.isSelected()) totale += 5.50 * (Integer)spinners[1].getValue();
        if (jCheckBox3.isSelected()) totale += 5.50 * (Integer)spinners[2].getValue();

        // Secondi piatti
        if (jCheckBox4.isSelected()) totale += 7.00 * (Integer)spinners[3].getValue();
        if (jCheckBox5.isSelected()) totale += 7.00 * (Integer)spinners[4].getValue();
        if (jCheckBox6.isSelected()) totale += 7.00 * (Integer)spinners[5].getValue();

        // Contorni
        if (jCheckBox7.isSelected()) totale += 2.50 * (Integer)spinners[6].getValue();
        if (jCheckBox8.isSelected()) totale += 2.50 * (Integer)spinners[7].getValue();
        if (jCheckBox9.isSelected()) totale += 2.50 * (Integer)spinners[8].getValue();

        // Dessert
        if (jCheckBox13.isSelected()) totale += 1.50 * (Integer)spinners[9].getValue();
        if (jCheckBox14.isSelected()) totale += 5.00 * (Integer)spinners[10].getValue();
        if (jCheckBox15.isSelected()) totale += 2.50 * (Integer)spinners[11].getValue();

        // Bevande
        if (jCheckBox16.isSelected()) totale += 1.00 * (Integer)spinners[12].getValue();
        if (jCheckBox17.isSelected()) totale += 3.00 * (Integer)spinners[13].getValue();
        if (jCheckBox18.isSelected()) totale += 4.00 * (Integer)spinners[14].getValue();

        totaleParziale.setText(String.format("Totale: €%.2f", totale));
    }

    private void customizeButton(JButton button, Color bgColor, Color fgColor, String text) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setText(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(bgColor.darker(), 2),
            BorderFactory.createEmptyBorder(12, 20, 12, 20)
        ));
        button.setPreferredSize(new Dimension(150, 40));
    }

    private void customizeCategoryLabel(JLabel label, String text) {
        label.setText(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(new Color(139, 69, 19));
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        calculateTotal();
    }

    private int getQuantity(JSpinner spinner) {
        return (Integer) spinner.getValue();
    }

    private void calculateTotal() {
        // Verifica stato cassa
        if (!CassaPrincipalee.cassaAperta) {
            JOptionPane.showMessageDialog(this, "La cassa è chiusa! Impossibile effettuare ordini.",
                "Cassa Chiusa", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Inizializzazione scontrino
        double totale = 0;
        StringBuilder receipt = new StringBuilder();
        receipt.append("=====================================\n");
        receipt.append("         Mensa da Salvatore         \n");
        receipt.append("            Via Irno n7             \n");
        receipt.append("           Salerno, SA              \n");
        receipt.append("         Tel: 089 2134675           \n");
        receipt.append("=====================================\n\n");
        receipt.append("Piatti                        Prezzo\n");
        receipt.append("-------------------------------------\n");

        jTextArea1.setFont(new Font("Courier New", Font.BOLD, 16));

        // Helper per formattare le righe dello scontrino
        BiConsumer<String, Double> addItem = (item, price) -> {
            receipt.append(String.format("%-25s €%6.2f\n", item, price));
        };

        // Calcolo totale per categoria
        // Primi piatti
        if (jCheckBox1.isSelected()) {
            int qty = getQuantity(spinners[0]);
            if (qty > 0) {
                double price = 5.50 * qty;
                totale += price;
                addItem.accept(String.format("Pasta al sugo (x%d)", qty), price);
            }
        }
        if (jCheckBox2.isSelected()) {
            int qty = getQuantity(spinners[1]);
            if (qty > 0) {
                double price = 5.50 * qty;
                totale += price;
                addItem.accept(String.format("Pasta e pesto (x%d)", qty), price);
            }
        }
        if (jCheckBox3.isSelected()) {
            int qty = getQuantity(spinners[2]);
            if (qty > 0) {
                double price = 5.50 * qty;
                totale += price;
                addItem.accept(String.format("Pasta e patate (x%d)", qty), price);
            }
        }

        // Secondi piatti
        if (jCheckBox4.isSelected()) {
            int qty = getQuantity(spinners[3]);
            if (qty > 0) {
                double price = 7.00 * qty;
                totale += price;
                addItem.accept(String.format("Cotoletta (x%d)", qty), price);
            }
        }
        if (jCheckBox5.isSelected()) {
            int qty = getQuantity(spinners[4]);
            if (qty > 0) {
                double price = 7.00 * qty;
                totale += price;
                addItem.accept(String.format("Salsiccia (x%d)", qty), price);
            }
        }
        if (jCheckBox6.isSelected()) {
            int qty = getQuantity(spinners[5]);
            if (qty > 0) {
                double price = 7.00 * qty;
                totale += price;
                addItem.accept(String.format("Bastoncini di pesce (x%d)", qty), price);
            }
        }

        // Contorni
        if (jCheckBox7.isSelected()) {
            int qty = getQuantity(spinners[6]);
            if (qty > 0) {
                double price = 2.50 * qty;
                totale += price;
                addItem.accept(String.format("Patatine (x%d)", qty), price);
            }
        }
        if (jCheckBox8.isSelected()) {
            int qty = getQuantity(spinners[7]);
            if (qty > 0) {
                double price = 2.50 * qty;
                totale += price;
                addItem.accept(String.format("Insalata (x%d)", qty), price);
            }
        }
        if (jCheckBox9.isSelected()) {
            int qty = getQuantity(spinners[8]);
            if (qty > 0) {
                double price = 2.50 * qty;
                totale += price;
                addItem.accept(String.format("Broccoli (x%d)", qty), price);
            }
        }

        // Dessert
        if (jCheckBox13.isSelected()) {
            int qty = getQuantity(spinners[9]);
            if (qty > 0) {
                double price = 1.50 * qty;
                totale += price;
                addItem.accept(String.format("Banana (x%d)", qty), price);
            }
        }
        if (jCheckBox14.isSelected()) {
            int qty = getQuantity(spinners[10]);
            if (qty > 0) {
                double price = 5.00 * qty;
                totale += price;
                addItem.accept(String.format("Tortino al cioccolato (x%d)", qty), price);
            }
        }
        if (jCheckBox15.isSelected()) {
            int qty = getQuantity(spinners[11]);
            if (qty > 0) {
                double price = 2.50 * qty;
                totale += price;
                addItem.accept(String.format("Gelato alla fragola (x%d)", qty), price);
            }
        }

        // Bevande
        if (jCheckBox16.isSelected()) {
            int qty = getQuantity(spinners[12]);
            if (qty > 0) {
                double price = 1.00 * qty;
                totale += price;
                addItem.accept(String.format("Acqua (x%d)", qty), price);
            }
        }
        if (jCheckBox17.isSelected()) {
            int qty = getQuantity(spinners[13]);
            if (qty > 0) {
                double price = 3.00 * qty;
                totale += price;
                addItem.accept(String.format("Birra (x%d)", qty), price);
            }
        }
        if (jCheckBox18.isSelected()) {
            int qty = getQuantity(spinners[14]);
            if (qty > 0) {
                double price = 4.00 * qty;
                totale += price;
                addItem.accept(String.format("Vino (x%d)", qty), price);
            }
        }

        // Gestione pagamento e sconti
        String[] options = {"Carta", "Contanti"};
        int paymentMethod = JOptionPane.showOptionDialog(
            this,
            "Seleziona il metodo di pagamento:",
            "Metodo di Pagamento",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );

        if (paymentMethod == -1) {
            return;
        }

        double totalePrima = totale;
        double sconto = 0;
        if (scontiRimasti > 0 && random.nextDouble() < PROBABILITA_SCONTO) {
            sconto = totale * PERCENTUALE_SCONTO;
            totale = totale - sconto;
            scontiRimasti--;
        }

        double cashReceived = 0;
        double change = 0;

        if (paymentMethod == 1) {
            String input = JOptionPane.showInputDialog(
                this,
                "Totale da pagare: €" + String.format("%.2f", totale) + "\nInserisci l'importo ricevuto:",
                "Pagamento in Contanti",
                JOptionPane.QUESTION_MESSAGE
            );

            if (input == null) {
                return;
            }

            try {
                cashReceived = Double.parseDouble(input);
                if (cashReceived < totale) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Importo insufficiente!",
                        "Errore",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                change = cashReceived - totale;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    this,
                    "Importo non valido!",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        CassaPrincipalee.updateFondoCassa(totale, true);

        receipt.append("\n-------------------------------------\n");
        receipt.append(String.format("%-25s €%6.2f\n", "TOTALE:", totalePrima));
        
        if (sconto > 0) {
            receipt.append("-------------------------------------\n");
            receipt.append(String.format("%-25s €%6.2f\n", "SCONTO 10%:", sconto));
            receipt.append(String.format("%-25s €%6.2f\n", "TOTALE SCONTATO:", totale));
            receipt.append("\n      ** Hai vinto uno sconto! **      \n");
            receipt.append(String.format("        Sconti rimasti: %d        \n", scontiRimasti));
        }

        receipt.append("-------------------------------------\n");
        receipt.append(String.format("%-25s %s\n", "Metodo:", options[paymentMethod]));
        
        if (paymentMethod == 1) {
            receipt.append(String.format("%-25s €%6.2f\n", "Ricevuti:", cashReceived));
            receipt.append(String.format("%-25s €%6.2f\n", "Resto:", change));
        }

        jTextArea1.setText(receipt.toString());
    }

    private void resetAll() {
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        jCheckBox13.setSelected(false);
        jCheckBox14.setSelected(false);
        jCheckBox15.setSelected(false);
        jCheckBox16.setSelected(false);
        jCheckBox17.setSelected(false);
        jCheckBox18.setSelected(false);

        for (JSpinner spinner : spinners) {
            spinner.setValue(0);
        }

        jTextArea1.setText("");
        totaleParziale.setText("Totale: €0.00");
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
        jCheckBox1 = new JCheckBox("Pasta al sugo (€5.50)");
        jCheckBox2 = new JCheckBox("Pasta e pesto (€5.50)");
        jCheckBox3 = new JCheckBox("Pasta e patate (€5.50)");
        jCheckBox4 = new JCheckBox("Cotoletta (€7.00)");
        jCheckBox5 = new JCheckBox("Salsiccia (€7.00)");
        jCheckBox6 = new JCheckBox("Bastoncini di pesce (€7.00)");
        jCheckBox7 = new JCheckBox("Patatine (€2.50)");
        jCheckBox8 = new JCheckBox("Insalata (€2.50)");
        jCheckBox9 = new JCheckBox("Broccoli (€2.50)");
        jCheckBox13 = new JCheckBox("Banana (€1.50)");
        jCheckBox14 = new JCheckBox("Tortino al cioccolato (€5.00)");
        jCheckBox15 = new JCheckBox("Gelato alla fragola (€2.50)");
        jCheckBox16 = new JCheckBox("Acqua (€1.00)");
        jCheckBox17 = new JCheckBox("Birra (€3.00)");
        jCheckBox18 = new JCheckBox("Vino (€4.00)");
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        totaleParziale = new JLabel("Totale: €0.00");
        totaleParziale.setFont(new Font("Segoe UI", Font.BOLD, 24));
        totaleParziale.setForeground(new Color(139, 69, 19));
        totaleParziale.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        backButton = new javax.swing.JButton();
        backButton.setText("Torna Indietro");
        backButton.setFont(new Font("Arial", Font.PLAIN, 12));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
                CassaPrincipalee.getInstance().setVisible(true);
            }
        });

        spinners = new JSpinner[15];
        for (int i = 0; i < 15; i++) {
            spinners[i] = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
            spinners[i].addChangeListener(e -> updateTotaleParziale());
            
            Dimension spinnerSize = new Dimension(70, 30);
            spinners[i].setPreferredSize(spinnerSize);
            spinners[i].setMinimumSize(spinnerSize);
            spinners[i].setMaximumSize(spinnerSize);
            
            JPanel spinnerContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
            spinnerContainer.setOpaque(false);
            spinnerContainer.add(Box.createHorizontalStrut(400));
            spinnerContainer.add(spinners[i]);
            jPanel1.add(spinnerContainer);
            
            spinners[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            ((JSpinner.DefaultEditor) spinners[i].getEditor()).getTextField().setHorizontalAlignment(JTextField.CENTER);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JComponent[] allComponents = {
            jCheckBox1, jCheckBox2, jCheckBox3,
            jCheckBox4, jCheckBox5, jCheckBox6,
            jCheckBox7, jCheckBox8, jCheckBox9,
            jCheckBox13, jCheckBox14, jCheckBox15,
            jCheckBox16, jCheckBox17, jCheckBox18
        };
        
        Font componentFont = new Font("Arial", Font.PLAIN, 16);
        int maxWidth = 250;
        
        for (JComponent comp : allComponents) {
            comp.setFont(componentFont);
            comp.setPreferredSize(new Dimension(maxWidth, comp.getPreferredSize().height));
            comp.setMinimumSize(new Dimension(maxWidth, comp.getPreferredSize().height));
        }

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

        jTextArea1.setColumns(25);
        jTextArea1.setRows(25);
        jTextArea1.setFont(new Font("Courier New", Font.BOLD, 16));
        jScrollPane1.setPreferredSize(new Dimension(400, 500));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[0]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[1]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addGap(20, 20, 20)  
                        .addComponent(spinners[2]))
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox4)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[3]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox5)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[4]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox6)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[5]))
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox7)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[6]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox8)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[7]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox9)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[8]))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox13)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[9]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox14)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[10]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox15)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[11]))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox16)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[12]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox17)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[13]))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox18)
                        .addGap(20, 20, 20)   
                        .addComponent(spinners[14]))
                    .addComponent(totaleParziale))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(resetButton)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1))))
            .addGap(20, 20, 20)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(backButton)) 
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(spinners[0]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(spinners[1]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3)
                            .addComponent(spinners[2]))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox4)
                            .addComponent(spinners[3]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox5)
                            .addComponent(spinners[4]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox6)
                            .addComponent(spinners[5]))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox7)
                            .addComponent(spinners[6]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox8)
                            .addComponent(spinners[7]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox9)
                            .addComponent(spinners[8]))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox13)
                            .addComponent(spinners[9]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox14)
                            .addComponent(spinners[10]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox15)
                            .addComponent(spinners[11]))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox16)
                            .addComponent(spinners[12]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox17)
                            .addComponent(spinners[13]))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox18)
                            .addComponent(spinners[14]))
                        .addGap(20, 20, 20)
                        .addComponent(totaleParziale))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetButton)
                            .addComponent(jButton1))))
                .addGap(20, 20, 20))
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
package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa in care se defineste interfata corespunzatoare tabelei Order impreuna cu operatiile specifice
 */
public class OrderView extends JFrame {

    private JLabel clientLabel;
    private JLabel produsLabel;
    private JLabel orderLabel;
    private JLabel idLabel;
    private JLabel cantitateLabel;

    private JTextField idTextField;
    private JTextField cantitateTextField;

    private JTable clientTable;
    private JTable produsTable;
    private JTable orderTable;

    private JScrollPane clientScroll;
    private JScrollPane produsScroll;
    private JScrollPane orderScroll;

    private JButton adaugaButton;
    private JButton afisareButton;

    /**
     * Constructor pentr clasa OrderView
     */
    public OrderView() {

        // Marginile ferestrei interfei
        this.setBounds(100, 100, 1100, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        // Etichete
        clientLabel = new JLabel("CLIENT TABLE");
        clientLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clientLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        clientLabel.setBounds(73, 21, 171, 46);
        this.getContentPane().add(clientLabel);

        produsLabel = new JLabel("PRODUS TABLE");
        produsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        produsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        produsLabel.setBounds(409, 21, 171, 46);
        this.getContentPane().add(produsLabel);

        idLabel = new JLabel("ID:");
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        idLabel.setBounds(29, 393, 119, 36);
        this.getContentPane().add(idLabel);

        cantitateLabel = new JLabel("CANTITATE:");
        cantitateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cantitateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cantitateLabel.setBounds(29, 444, 119, 36);
        this.getContentPane().add(cantitateLabel);

        orderLabel = new JLabel("ORDER TABLE");
        orderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        orderLabel.setBounds(795, 21, 171, 46);
        this.getContentPane().add(orderLabel);

        // Casete text
        idTextField = new JTextField();
        idTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        idTextField.setColumns(10);
        idTextField.setBounds(158, 393, 156, 40);
        this.getContentPane().add(idTextField);

        cantitateTextField = new JTextField();
        cantitateTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cantitateTextField.setColumns(10);
        cantitateTextField.setBounds(158, 443, 156, 40);
        this.getContentPane().add(cantitateTextField);

        // Tabele
        clientTable = new JTable();
        this.clientScroll = new JScrollPane(this.clientTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.clientScroll.setBounds(23, 77, 291, 295);
        this.clientScroll.setViewportView(this.clientTable);
        this.getContentPane().add(this.clientScroll);

        produsTable = new JTable();
        this.produsScroll = new JScrollPane(this.produsTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.produsScroll.setBounds(344, 77, 327, 295);
        this.produsScroll.setViewportView(this.produsTable);
        this.getContentPane().add(this.produsScroll);

        orderTable = new JTable();
        this.orderScroll = new JScrollPane(this.orderTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.orderScroll.setBounds(710, 77, 327, 295);
        this.orderScroll.setViewportView(this.orderTable);
        this.getContentPane().add(this.orderScroll);

        // Butoane
        adaugaButton = new JButton("ADAUGA");
        adaugaButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        adaugaButton.setBounds(410, 441, 156, 38);
        this.getContentPane().add(adaugaButton);

        afisareButton = new JButton("AFISARE");
        afisareButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        afisareButton.setBounds(810, 441, 156, 38);
        this.getContentPane().add(afisareButton);

        // Afisare fereastra actuala
        this.setVisible(true);
    }

    /**
     * Metoda de get() pentru caseta ID
     *
     * @return caseta ID
     */
    public JTextField getIdTextField() {
        return idTextField;
    }

    /**
     * Metoda de get() pentru caseta cantitate
     *
     * @return caseta cantitate
     */
    public JTextField getCantitateTextField() {
        return cantitateTextField;
    }

    /**
     * Metoda de get() pentru tabel clienti
     *
     * @return tabelul clienti
     */
    public JTable getClientTable() {
        return clientTable;
    }

    /**
     * Metoda de get() pentru tabel produse
     *
     * @return tabelul produselor
     */
    public JTable getProdusTable() {
        return produsTable;
    }

    /**
     * Metoda de get() pentru tabelul comenzilor
     *
     * @return tabelul comenzilor
     */
    public JTable getOrderTable() {
        return orderTable;
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de afisare
     *
     * @param actionListener actionListener
     */
    public void addAfisareListener(ActionListener actionListener) {

        this.afisareButton.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de adaugare
     *
     * @param actionListener actionListener
     */
    public void addAdaugareListener(ActionListener actionListener) {

        this.adaugaButton.addActionListener(actionListener);
    }
}

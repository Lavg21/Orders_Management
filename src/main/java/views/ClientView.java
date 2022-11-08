package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa in care se defineste interfata corespunzatoare tabelei Client impreuna cu operatiile specifice
 */
public class ClientView extends JFrame {

    private JLabel titleLabel;
    private JLabel idLabel;
    private JLabel numeLabel;
    private JLabel adresaLabel;
    private JLabel dateLabel;

    private JTable clientTable;

    private JTextField idTextField;
    private JTextField numeTextField;
    private JTextField adresaTextField;

    private JButton adaugaButton;
    private JButton stergeButton;
    private JButton modificaButton;
    private JButton afisareButton;

    private JScrollPane tableScroll;

    /**
     * Constructor pentr clasa ClientView
     */
    public ClientView() {

        // Marginile ferestrei interfetei
        this.setBounds(100, 100, 1100, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        // Etichete
        titleLabel = new JLabel("CLIENT TABLE");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(578, 21, 171, 46);
        this.getContentPane().add(titleLabel);

        idLabel = new JLabel("ID:");
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        idLabel.setBounds(10, 77, 74, 36);
        this.getContentPane().add(idLabel);

        numeLabel = new JLabel("NUME:");
        numeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        numeLabel.setBounds(10, 123, 74, 36);
        this.getContentPane().add(numeLabel);

        adresaLabel = new JLabel("ADRESA:");
        adresaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        adresaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        adresaLabel.setBounds(10, 172, 86, 36);
        this.getContentPane().add(adresaLabel);

        dateLabel = new JLabel("DATE CLIENT");
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        dateLabel.setBounds(109, 21, 156, 46);
        this.getContentPane().add(dateLabel);

        // Tabel
        clientTable = new JTable();
        this.tableScroll = new JScrollPane(this.clientTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.tableScroll.setBounds(305, 77, 687, 389);
        this.tableScroll.setViewportView(this.clientTable);
        this.getContentPane().add(this.tableScroll);

        // Casete text
        idTextField = new JTextField();
        idTextField.setBounds(109, 77, 156, 36);
        this.getContentPane().add(idTextField);
        idTextField.setColumns(10);

        numeTextField = new JTextField();
        numeTextField.setColumns(10);
        numeTextField.setBounds(109, 126, 156, 36);
        this.getContentPane().add(numeTextField);

        adresaTextField = new JTextField();
        adresaTextField.setColumns(10);
        adresaTextField.setBounds(109, 172, 156, 36);
        this.getContentPane().add(adresaTextField);

        // Butoane
        adaugaButton = new JButton("ADAUGA");
        adaugaButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        adaugaButton.setBounds(109, 239, 156, 38);
        this.getContentPane().add(adaugaButton);

        stergeButton = new JButton("STERGE");
        stergeButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        stergeButton.setBounds(109, 287, 156, 38);
        this.getContentPane().add(stergeButton);

        modificaButton = new JButton("MODIFICA");
        modificaButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        modificaButton.setBounds(109, 335, 156, 38);
        this.getContentPane().add(modificaButton);

        afisareButton = new JButton("AFISARE");
        afisareButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        afisareButton.setBounds(109, 383, 156, 38);
        this.getContentPane().add(afisareButton);

        // Afisare fereastra actuala
        this.setVisible(true);
    }

    /**
     * Metoda de get() pentru tabel
     *
     * @return tabelul
     */
    public JTable getTable() {
        return clientTable;
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
     * Metoda de get() pentru caseta nume
     *
     * @return caseta nume
     */
    public JTextField getNumeTextField() {
        return numeTextField;
    }

    /**
     * Metoda de get() pentru caseta adresa
     *
     * @return caseta adresa
     */
    public JTextField getAdresaTextField() {
        return adresaTextField;
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

    /**
     * Metoda de adaugare a unui listener pe butonul de stergere
     *
     * @param actionListener actionListener
     */
    public void addStergereListener(ActionListener actionListener) {

        this.stergeButton.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de modificare
     *
     * @param actionListener actionListener
     */
    public void addModificareListener(ActionListener actionListener) {

        this.modificaButton.addActionListener(actionListener);
    }
}

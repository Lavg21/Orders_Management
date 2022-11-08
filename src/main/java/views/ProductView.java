package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa in care se defineste interfata corespunzatoare tabelei Product impreuna cu operatiile specifice
 */
public class ProductView extends JFrame {

    private JLabel titleLabel;
    private JLabel idLabel;
    private JLabel numeLabel;
    private JLabel pretLabel;
    private JLabel cantitateLabel;
    private JLabel dateLabel;

    private JTable produsTable;
    private JTextField idTextField;
    private JTextField numeTextField;
    private JTextField pretTextField;
    private JTextField cantitateTextField;

    private JButton adaugaButton;
    private JButton stergeButton;
    private JButton modificaButton;
    private JButton afisareButton;

    private JScrollPane tableScroll;

    /**
     * Constructor pentr clasa ProductView
     */
    public ProductView() {

        // Marginile ferestrei interfetei
        this.setBounds(100, 100, 1100, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        // Etichete
        titleLabel = new JLabel("PRODUS TABLE");
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

        pretLabel = new JLabel("PRET:");
        pretLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pretLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        pretLabel.setBounds(10, 172, 86, 36);
        this.getContentPane().add(pretLabel);

        cantitateLabel = new JLabel("CANTITATE:");
        cantitateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cantitateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cantitateLabel.setBounds(10, 219, 119, 36);
        this.getContentPane().add(cantitateLabel);

        dateLabel = new JLabel("DATE PRODUS");
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        dateLabel.setBounds(137, 21, 156, 46);
        this.getContentPane().add(dateLabel);

        // Casete text
        idTextField = new JTextField();
        idTextField.setBounds(137, 80, 156, 36);
        this.getContentPane().add(idTextField);
        idTextField.setColumns(10);

        numeTextField = new JTextField();
        numeTextField.setColumns(10);
        numeTextField.setBounds(137, 126, 156, 36);
        this.getContentPane().add(numeTextField);

        pretTextField = new JTextField();
        pretTextField.setColumns(10);
        pretTextField.setBounds(137, 175, 156, 36);
        this.getContentPane().add(pretTextField);

        cantitateTextField = new JTextField();
        cantitateTextField.setColumns(10);
        cantitateTextField.setBounds(137, 221, 156, 36);
        this.getContentPane().add(cantitateTextField);

        // Tabel
        produsTable = new JTable();
        this.tableScroll = new JScrollPane(this.produsTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.tableScroll.setBounds(305, 77, 687, 389);
        this.tableScroll.setViewportView(this.produsTable);
        this.getContentPane().add(this.tableScroll);

        // Butoane
        adaugaButton = new JButton("ADAUGA");
        adaugaButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        adaugaButton.setBounds(137, 278, 156, 38);
        this.getContentPane().add(adaugaButton);

        stergeButton = new JButton("STERGE");
        stergeButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        stergeButton.setBounds(137, 341, 156, 38);
        this.getContentPane().add(stergeButton);

        modificaButton = new JButton("MODIFICA");
        modificaButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        modificaButton.setBounds(137, 405, 156, 38);
        this.getContentPane().add(modificaButton);

        afisareButton = new JButton("AFISARE");
        afisareButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        afisareButton.setBounds(137, 465, 156, 38);
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
     * Metoda de get() pentru caseta nume
     *
     * @return caseta nume
     */
    public JTextField getNumeTextField() {
        return numeTextField;
    }


    public JTextField getPretTextField() {
        return pretTextField;
    }

    /**
     * Metoda de get() pentru caseta cantitate pe stoc
     *
     * @return caseta cantitate pe stoc
     */
    public JTextField getCantitateTextField() {
        return cantitateTextField;
    }

    /**
     * Metoda de get() pentru tabel
     *
     * @return tabelul
     */
    public JTable getTable() {

        return produsTable;
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

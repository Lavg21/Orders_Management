package controllers;

import bll.ClientBLL;
import models.Client;
import views.ClientView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa in care se realizeaza legatura cu view-ul corespunzator ferestrei Client
 */
public class ClientController {

    private ClientView view;

    private ClientBLL clientBLL;

    /**
     * Constructor pentru clasa ClientController
     *
     * @param view      view-ul pentru clienti
     * @param clientBLL bll-ul pentru clienti
     */
    public ClientController(ClientView view, ClientBLL clientBLL) {

        this.view = view;
        this.clientBLL = clientBLL;

        this.view.addAfisareListener(new AfisareListener());
        this.view.addAdaugareListener(new AdaugareListener());
        this.view.addStergereListener(new StergereListener());
        this.view.addModificareListener(new ModificareListener());
    }

    /**
     * Metoda pentru creare capurilor de tabel
     *
     * @param objectList lista de obiecte din care se va crea capul de tabel
     * @param table      tabelul obtinut
     */
    private void reflectionTableHeaders(List<Object> objectList, JTable table) {

        DefaultTableModel tableModel = new DefaultTableModel();

        Object obj = objectList.get(0);

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            try {

                // Adaugam drept coloana in tabel fiecare atribut al obiectului
                tableModel.addColumn(field.getName());
            } catch (IllegalArgumentException ex) {

                ex.printStackTrace();
            }
        }

        for (Object o : objectList) {

            // Vom avea cate o lista de valori pentru atribute pentru fiecare obiect din lista primita ca parametru
            List<Object> valoriAtribute = new ArrayList<>();

            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                try {

                    // Luam valorile pentru fiecare atribut
                    value = field.get(o);

                    // Adaugam valorile atributelor intr-o lista
                    valoriAtribute.add(value);
                } catch (IllegalArgumentException | IllegalAccessException ex) {

                    ex.printStackTrace();
                }
            }

            // Convertim lista de obiecte in vector de obiecte
            tableModel.addRow(valoriAtribute.toArray());
        }

        table.setModel(tableModel); // actualizam tabelul
    }

    /**
     * Clasa pentru implementarea afisarii datelor din tabela Client in interfata corespunzatoare
     */
    class AfisareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                List<Client> clients = clientBLL.findAll(); // lista clientilor din tabela Client

                List<Object> objects = new ArrayList<>(); // lista de obiecte

                for (Client c : clients) // cast manual pentru lista de clienti
                    objects.add(c);

                reflectionTableHeaders(objects, view.getTable()); // adaugam in tabel

            } catch (NumberFormatException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Clasa pentru implementarea inserarii datelor in tabela Client in interfata corespunzatoare
     */
    class AdaugareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                // Preluare date de pe interfata
                int id = Integer.parseInt(view.getIdTextField().getText());
                String nume = view.getNumeTextField().getText();
                String adresa = view.getAdresaTextField().getText();

                Client client = new Client(id, nume, adresa); // creare client

                clientBLL.insert(client); // inserare client

                JOptionPane.showMessageDialog(null, "Client adaugat cu succes!");
            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "ID invalid!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * Clasa pentru implementarea stergerea datelor din tabela Client in interfata corespunzatoare
     */
    class StergereListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                // Preluare date de pe interfata
                int id = Integer.parseInt(view.getIdTextField().getText());
                String nume = view.getNumeTextField().getText();
                String adresa = view.getAdresaTextField().getText();

                Client client = new Client(id, nume, adresa); // creare client

                clientBLL.delete(client); // stergere client

                JOptionPane.showMessageDialog(null, "Client sters cu succes!");
            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "ID invalid!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * Clasa pentru implementarea modificarii datelor din tabela Client in interfata corespunzatoare
     */
    class ModificareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                // Preluare date de pe interfata
                int id = Integer.parseInt(view.getIdTextField().getText());
                String nume = view.getNumeTextField().getText();
                String adresa = view.getAdresaTextField().getText();

                Client client = new Client(id, nume, adresa); // creare client

                clientBLL.update(client); // modificare client

                JOptionPane.showMessageDialog(null, "Client modificat cu succes!");
            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "ID invalid!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}

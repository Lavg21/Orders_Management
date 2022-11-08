package controllers;

import bll.ProductBLL;
import models.Product;
import views.ProductView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa in care se realizeaza legatura cu view-ul corespunzator ferestrei Product
 */
public class ProductController {

    private ProductView view;

    private ProductBLL productBLL;

    /**
     * Constructor pentru clasa ProductController
     *
     * @param view       view-ul pentru clienti
     * @param productBLL bll-ul pentru produse
     */
    public ProductController(ProductView view, ProductBLL productBLL) {

        this.view = view;
        this.productBLL = productBLL;

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

        table.setModel(tableModel); // actualizare tabel
    }

    /**
     * Clasa pentru implementarea afisarii datelor din tabela Product in interfata corespunzatoare
     */
    class AfisareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                List<Product> products = productBLL.findAll(); // lista produselor din tabela Product

                List<Object> objects = new ArrayList<>(); // lista de obiecte

                for (Product p : products) // cast manual pentru lista de produse
                    objects.add(p);

                reflectionTableHeaders(objects, view.getTable()); // adaugam in tabel

            } catch (NumberFormatException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Clasa pentru implementarea inserarii datelor in tabela Product in interfata corespunzatoare
     */
    class AdaugareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                // Preluare date de pe interfata
                int id = Integer.parseInt(view.getIdTextField().getText());
                String nume = view.getNumeTextField().getText();
                double pret = Double.parseDouble(view.getPretTextField().getText());
                int cantitate = Integer.parseInt(view.getCantitateTextField().getText());

                Product product = new Product(id, nume, pret, cantitate); // creare produs

                productBLL.insert(product); // inserare produs

                JOptionPane.showMessageDialog(null, "Produs adaugat cu succes!");
            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "ID invalid!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * Clasa pentru implementarea stergerea datelor din tabela Produs in interfata corespunzatoare
     */
    class StergereListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                // Preluare date de pe interfata
                int id = Integer.parseInt(view.getIdTextField().getText());

                Product product = new Product(id, null, -1, -1); // creare produs

                productBLL.delete(product); // stergere produs

                JOptionPane.showMessageDialog(null, "Produs sters cu succes!");
            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "ID invalid!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * Clasa pentru implementarea modificarii datelor din tabela Product in interfata corespunzatoare
     */
    class ModificareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                // Preluare date de pe interfata
                int id = Integer.parseInt(view.getIdTextField().getText());
                String nume = view.getNumeTextField().getText();
                double pret = Double.parseDouble(view.getPretTextField().getText());
                int cantitate = Integer.parseInt(view.getCantitateTextField().getText());

                Product product = new Product(id, nume, pret, cantitate); // creare produs

                productBLL.update(product); // modificare produs

                JOptionPane.showMessageDialog(null, "Produs modificat cu succes!");
            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "ID invalid!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

}

package controllers;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import models.Client;
import models.Order;
import models.Product;
import start.OrderFile;
import views.OrderView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa in care se realizeaza legatura cu view-ul corespunzator ferestrei Order
 */
public class OrderController {

    private OrderView view;

    private OrderBLL orderBLL;
    private ClientBLL clientBLL;
    private ProductBLL productBLL;

    /**
     * Constructor pentru clasa OrderController
     *
     * @param view       view-ul pentru comenzi
     * @param clientBLL  bll-ul pentru clienti
     * @param productBLL bll-ul pentru produse
     * @param orderBLL   bll-ul pentru comenzi
     */
    public OrderController(OrderView view, ClientBLL clientBLL, ProductBLL productBLL, OrderBLL orderBLL) {
        this.view = view;

        this.clientBLL = clientBLL;
        this.productBLL = productBLL;
        this.orderBLL = orderBLL;

        this.view.addAfisareListener(new AfisareListener());
        this.view.addAdaugareListener(new AdaugareListener());
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
     * Clasa pentru implementarea afisarii datelor din tabela Order
     */
    class AfisareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                List<Client> clients = clientBLL.findAll(); // lista clientilor din tabela Client

                List<Object> objects = new ArrayList<>(); // lista de obiecte

                for (Client c : clients) // cast manual pentru lista de clienti
                    objects.add(c);

                reflectionTableHeaders(objects, view.getClientTable()); // adaugam in tabel

                List<Product> products = productBLL.findAll(); // lista produselor din tabela Product

                objects = new ArrayList<>(); // reinitializare

                for (Product p : products) // cast manual pentru lista de produse
                    objects.add(p);

                reflectionTableHeaders(objects, view.getProdusTable()); // adaugam in tabel

                List<Order> orders = orderBLL.findAll(); // lista comenzilor din tabela Order

                objects = new ArrayList<>(); // reinitializare

                for (Order o : orders) // cast manual pentru lista de comenzi
                    objects.add(o);

                reflectionTableHeaders(objects, view.getOrderTable()); // adaugam in tabel

            } catch (NumberFormatException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Clasa pentru implementarea inserarii datelor in tabela Order in interfata corespunzatoare
     */
    class AdaugareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Preluare date de pe interfata
                int id = Integer.parseInt(view.getIdTextField().getText());
                int cantitate = Integer.parseInt(view.getCantitateTextField().getText());

                // Preluare randuri selectate din tabelele Client si Product
                int randSelectatClienti = view.getClientTable().getSelectedRow();
                int randSelectatProduse = view.getProdusTable().getSelectedRow();

                String idClientString = view.getClientTable().getModel().getValueAt(randSelectatClienti, 0).toString();
                String idProdusString = view.getProdusTable().getModel().getValueAt(randSelectatProduse, 0).toString();

                // Conversie date
                int idClient = Integer.parseInt(idClientString);
                int idProdus = Integer.parseInt(idProdusString);

                Order order = new Order(id, idClient, idProdus, cantitate); // creare comanda

                orderBLL.insert(order); // inserare comanda

                // Afisare in fisier
                String toFile = "ID: " + id + "\nID Client: " + idClient + "\nID Produs: " + idProdus + "\nCantitate: " + cantitate;
                OrderFile.writeToFile(toFile, "order" + order.getId() + ".txt");

                JOptionPane.showMessageDialog(null, "Comanda adaugata cu succes!");
            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "ID / Cantitate invalida!");
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

}

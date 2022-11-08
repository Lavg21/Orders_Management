package dao;

import connection.ConnectionFactory;
import models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa pentru extragerea datelor din tabele Order
 */
public class OrderDAO extends AbstractDAO<Order> {

    /**
     * Metoda care returneaza toate comenzile din tabela Order
     *
     * @return lista de comenzi din tabela Order
     */
    public List<Order> findAll() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM `order`";

        List<Order> lista = new ArrayList<>();

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                int idClient = resultSet.getInt(2);
                int idProdus = resultSet.getInt(3);
                int client = resultSet.getInt(4);

                lista.add(new Order(id, idClient, idProdus, client)); // adaugare comanda
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {

            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return lista; // lista de comenzi
    }

    /**
     * Metoda care returneaza comanda cu ID-ul corespunzator
     *
     * @param id ID-ul dupa care se cauta comanda in tabela Order
     * @return comanda cu ID-ul cautat
     */
    public Order findById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM `order` WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int idClient = resultSet.getInt(2);
                int idProdus = resultSet.getInt(3);
                int client = resultSet.getInt(4);

                return new Order(id, idClient, idProdus, client); // comanda cautata
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }

    /**
     * Metoda in care se adauga o comanda in tabela Order
     *
     * @param order comanda care trebuie sa fie adaugata in tabela Order
     * @return comanda care a fost adaugata
     */
    /*public Order insert(Order order) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "INSERT INTO `order` VALUES (?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            statement.setInt(1, order.getId());
            statement.setInt(2, order.getIdClient());
            statement.setInt(3, order.getIdProdus());
            statement.setInt(4, order.getCantitate());

            statement.executeUpdate();

            return order; // comanda adaugata

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }*/

    /**
     * Metoda in care se sterge o comanda in tabela Order
     *
     * @param order comanda care trebuie sa fie stearsa in tabela Order
     * @return comanda care a fost stearsa
     */
    /*public Order delete(Order order) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "DELETE FROM `order` WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, order.getId());

            statement.executeUpdate();

            return order; // comanda de sters

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }*/

    /**
     * Metoda in care se modifica o comanda in tabela Order
     *
     * @param order comanda care trebuie sa fie modificata in tabela Order
     * @return comanda care a fost modificata
     */
    /*public Order update(Order order) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "UPDATE `order` SET idclient = ?, idprodus = ?, cantitate = ? WHERE id = ?";

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            statement.setInt(1, order.getIdClient());
            statement.setInt(2, order.getIdProdus());
            statement.setInt(3, order.getCantitate());
            statement.setInt(4, order.getId());

            statement.executeUpdate();

            return order;

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }*/
}

package dao;

import connection.ConnectionFactory;
import models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa pentru extragerea datelor din tabele Client
 */
public class ClientDAO extends AbstractDAO<Client> {

    /**
     * Metoda care returneaza toti clientii din tabela Client
     *
     * @return lista de clienti din tabela Client
     */
    public List<Client> findAll() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM client";

        List<Client> lista = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String nume = resultSet.getString(2);
                String adresa = resultSet.getString(3);

                lista.add(new Client(id, nume, adresa)); // adaugare client in lista de clienti
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return lista;
    }

    /**
     * \
     * Metoda care returneaza clientul cu ID-ul corespunzator
     *
     * @param id ID-ul dupa care se cauta clientul in tabela Client
     * @return clientul cu ID-ul cautat
     */
    public Client findById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM client WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String nume = resultSet.getString(2);
                String adresa = resultSet.getString(3);

                return new Client(id, nume, adresa); // clientul cautat
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
     * Metoda in care se adauga un client in tabela Client
     *
     * @param client clientul care trebuie sa fie adaugat in tabela Client
     * @return clientul care a fost adaugat
     */
    /*public Client insert(Client client) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "INSERT INTO client VALUES (?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, client.getId());
            statement.setString(2, client.getNume());
            statement.setString(3, client.getAdresa());

            statement.executeUpdate();

            return client; // clientul adaugat

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }*/

    /**
     * Metoda in care se sterge un client in tabela Client
     *
     * @param client clientul care trebuie sa fie sters in tabela Client
     * @return clientul care trebuie sters
     */
    /*public Client delete(Client client) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "DELETE FROM client WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, client.getId());

            statement.executeUpdate();

            return client; // clientul de sters

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }*/

    /**
     * Metoda in care se modifica un client in tabela Client
     *
     * @param client clientul care trebuie sa fie modificat in tabela Client
     * @return clientul care a fost modificat
     */
    /*public Client update(Client client) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "UPDATE client SET nume = ?, adresa = ? WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            statement.setString(1, client.getNume());
            statement.setString(2, client.getAdresa());
            statement.setInt(3, client.getId());

            statement.executeUpdate();

            return client; // clientul modificat

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }*/
}

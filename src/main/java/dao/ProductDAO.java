package dao;

import connection.ConnectionFactory;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa pentru extragerea datelor din tabele Product
 */
public class ProductDAO extends AbstractDAO<Product> {

    /**
     * Metoda care returneaza toti clientii din tabela Product
     *
     * @return lista de produse din tabela Product
     */
    public List<Product> findAll() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM product";

        List<Product> lista = new ArrayList<>();

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String nume = resultSet.getString(2);
                double pret = resultSet.getDouble(3);
                int cantitate = resultSet.getInt(4);

                lista.add(new Product(id, nume, pret, cantitate)); // adugare produs
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {

            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return lista; // lista de produse
    }

    /**
     * Metoda care returneaza produsul cu ID-ul corespunzator
     *
     * @param id ID-ul dupa care se cauta clientul in tabela Product
     * @return produsul cu ID-ul cautat
     */
    public Product findById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM product WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String nume = resultSet.getString(2);
                double pret = resultSet.getDouble(3);
                int cantitate = resultSet.getInt(4);

                return new Product(id, nume, pret, cantitate); // produsul cautat
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
     * Metoda in care se adauga un produs in tabela Product
     *
     * @param product produsul care trebuie sa fie adaugat in tabela Product
     * @return produsul care a fost adaugat
     */
    /*public Product insert(Product product) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "INSERT INTO product VALUES (?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            statement.setInt(1, product.getId());
            statement.setString(2, product.getNume());
            statement.setDouble(3, product.getPret());
            statement.setInt(4, product.getCantitate());

            statement.executeUpdate();

            return product; // produsul adaugat

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }*/

    /**
     * Metoda in care se sterge un client in tabela Product
     *
     * @param product produsul care trebuie sa fie sters in tabela Product
     * @return produsul care trebuie fost sters
     */
   /* public Product delete(Product product) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "DELETE FROM product WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, product.getId());

            statement.executeUpdate();

            return product; // produsul de sters

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }*/

    /**
     * Metoda in care se modifica un produs in tabela Product
     *
     * @param product produsul care trebuie sa fie modificat in tabela Product
     * @return produsul care a fost modificat
     */
    /*public Product update(Product product) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "UPDATE product SET nume = ?, pret = ?, cantitate = ? WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            statement.setString(1, product.getNume());
            statement.setDouble(2, product.getPret());
            statement.setInt(3, product.getCantitate());
            statement.setInt(4, product.getId());

            statement.executeUpdate();

            return product; // produsul modificat

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }*/
}



package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clasa in care se realiza conexiunea cu baza de date corespunzatoare
 */
public class ConnectionFactory {

    private static final String DBURL = "jdbc:mysql://localhost:3306/depozit";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Constructor pentru clasa ConnectionFactory
     *
     * @return conexiunea creata
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Metoda pentru obtinerea conexiunii active
     *
     * @return conexiunea ceruta
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Metoda pentru inchiderea conexiunii
     *
     * @param connection conexiunea cu baza de date
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metoda pentru inchiderea unui Statement
     *
     * @param statement statement-ul care trebuie inchis
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metoda pentru inchiderea unui ResultSet
     *
     * @param resultSet ResultSet-ul care trebuie inchis
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

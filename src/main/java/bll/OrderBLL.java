package bll;

import bll.validators.Validator;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import models.Order;
import models.Product;

import java.util.List;

/**
 * Clasa care implementeaza logica din spatele operatiilor pentru comanda
 */
public class OrderBLL {

    private Validator<Order> validator;

    private ClientDAO clientDAO;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    /**
     * Constructor pentru clasa OrderBLL
     *
     * @param validator  validatorul pentru comanda
     * @param clientDAO  dao-ul pentru client responsabil pentru operatiile pe tabela Client
     * @param productDAO dao-ul pentru client responsabil pentru operatiile pe tabela Product
     * @param orderDAO   dao-ul pentru client responsabil pentru operatiile pe tabela Order
     */
    public OrderBLL(Validator<Order> validator, ClientDAO clientDAO, ProductDAO productDAO, OrderDAO orderDAO) {
        this.validator = validator;
        this.clientDAO = clientDAO;
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
    }

    /**
     * Metoda care returneaza toate comenzile din tabela Order
     *
     * @return lista de comenzi din tabela Order
     */
    public List<Order> findAll() {

        return this.orderDAO.findAll();
    }

    /**
     * Metoda care returneaza comanda cu ID-ul corespunzator
     *
     * @param id ID-ul dupa care se cauta comanda in tabela Order
     * @return comanda cu ID-ul cautat
     * @throws Exception daca nu exista un client cu ID-ul dat ca parametru
     */
    public Order findById(int id) throws Exception {

        Order order = this.orderDAO.findById(id);

        if (order == null)
            throw new Exception("Nu exista nicio comanda cu acest ID!");

        return order;
    }

    /**
     * Metoda in care se adauga o comanda in tabela Order
     *
     * @param order comanda care trebuie sa fie adaugata in tabela Order
     * @return comanda care a fost adugata
     * @throws Exception daca exista deja o comanda cu acel ID
     */
    public Order insert(Order order) throws Exception {

        this.validator.validate(order); // validare comanda

        if (this.orderDAO.findById(order.getId()) != null)
            throw new Exception("Exista deja o comanda cu acest id!");

        if (this.clientDAO.findById(order.getIdClient()) == null)
            throw new Exception("Nu exista acest client!");

        if (this.productDAO.findById(order.getIdProdus()) == null)
            throw new Exception("Nu exista acest produs!");

        Product product = this.productDAO.findById(order.getIdProdus());

        if (order.getCantitate() > product.getCantitate()) // verificare stoc
            throw new Exception("Nu exista destule produse pe stoc pentru a se face aceasta comanda!");

        product.setCantitate(product.getCantitate() - order.getCantitate()); // actualizare stoc
        productDAO.update(product); // modificare produs

        return this.orderDAO.insert(order);
    }

    /**
     * Metoda in care se sterge o comanda in tabela Order
     *
     * @param order comanda care trebuie sa fie stearsa in tabela Order
     * @return comanda care a fost stearsa
     * @throws Exception daca nu exista comanda respectiva
     */
    public Order delete(Order order) throws Exception {

        Order rezultat = this.orderDAO.delete(order);

        if (rezultat == null)
            throw new Exception("Nu exista aceasta comanda!");

        return rezultat;
    }

    /**
     * Metoda in care se modifica o comanda in tabela Order
     *
     * @param order comanda care trebuie sa fie modificata in tabela Order
     * @return comanda care a fost modificata
     * @throws Exception daca acel comanda respectiva nu poate fi modificata
     */
    public Order update(Order order) throws Exception {

        Order rezultat = this.findById(order.getId());

        if (rezultat == null)
            throw new Exception("Nu se poate face update la acest client!");

        if (this.clientDAO.findById(order.getIdClient()) == null)
            throw new Exception("Nu exista acest client!");

        if (this.productDAO.findById(order.getIdProdus()) == null)
            throw new Exception("Nu exista acest produs!");

        return this.orderDAO.update(order);
    }
}

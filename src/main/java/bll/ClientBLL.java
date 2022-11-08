package bll;

import bll.validators.Validator;
import dao.ClientDAO;
import models.Client;

import java.util.List;

/**
 * Clasa care implementeaza logica din spatele operatiilor pentru client
 */
public class ClientBLL {

    private Validator<Client> validator;

    private ClientDAO clientDAO;

    /**
     * Constructor pentru clasa ClientBLL
     *
     * @param validator validatorul pentru client
     * @param clientDAO dao-ul pentru client responsabil pentru operatiile pe tabela Client
     */
    public ClientBLL(Validator<Client> validator, ClientDAO clientDAO) {

        this.validator = validator;
        this.clientDAO = clientDAO;
    }

    /**
     * Metoda care returneaza toti clientii din tabela Client
     *
     * @return lista de clienti din tabela Client
     */
    public List<Client> findAll() {

        return this.clientDAO.findAll();
    }

    /**
     * Metoda care returneaza clientul cu ID-ul corespunzator
     *
     * @param id ID-ul dupa care se cauta clientul in tabela Client
     * @return clientul cu ID-ul cautat
     * @throws Exception daca nu exista un client cu ID-ul dat ca parametru
     */
    public Client findById(int id) throws Exception {

        Client client = this.clientDAO.findById(id);
        if (client == null)
            throw new Exception("Nu exista niciun client cu acest ID!");

        return client;
    }

    /**
     * Metoda in care se adauga un client in tabela Client
     *
     * @param client clientul care trebuie sa fie adaugat in tabela Client
     * @return clientul care a fost adaugat
     * @throws Exception daca exista deja un client cu acel ID
     */
    public Client insert(Client client) throws Exception {

        this.validator.validate(client); // validare client

        if (this.clientDAO.findById(client.getId()) != null)
            throw new Exception("Exista deja un client cu acest ID!");

        return this.clientDAO.insert(client);
    }

    /**
     * Metoda in care se sterge un client in tabela Client
     *
     * @param client clientul care trebuie sa fie sters in tabela Client
     * @return clientul trebuie sters
     * @throws Exception daca nu exista clientul respectiv
     */
    public Client delete(Client client) throws Exception {

        if (this.clientDAO.findById(client.getId()) == null)
            throw new Exception("Nu exista acest client!");

        Client rezultat = this.clientDAO.delete(client); // stergere client

        return rezultat;
    }

    /**
     * Metoda in care se modifica un client in tabela Client
     *
     * @param client clientul care trebuie sa fie modificat in tabela Client
     * @return clientul care a fost modificat
     * @throws Exception daca clientul respectiv nu poate fi modificat
     */
    public Client update(Client client) throws Exception {

        Client rezultat = this.findById(client.getId());

        if (rezultat == null)
            throw new Exception("Nu se poate face update la acest client!");

        return this.clientDAO.update(client);
    }
}

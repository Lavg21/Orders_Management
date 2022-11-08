package bll;

import bll.validators.Validator;
import dao.ProductDAO;
import models.Product;

import java.util.List;

/**
 * Clasa care implementeaza logica din spatele operatiilor pentru produs
 */
public class ProductBLL {

    private Validator<Product> validator;

    private ProductDAO productDAO;

    /**
     * Constructor pentru clasa ProdusBLL
     *
     * @param validator  validatorul pentru produs
     * @param productDAO dao-ul pentru client responsabil pentru operatiile pe tabela Product
     */
    public ProductBLL(Validator<Product> validator, ProductDAO productDAO) {
        this.validator = validator;
        this.productDAO = productDAO;
    }

    /**
     * Metoda care returneaza toti clientii din tabela Product
     *
     * @return lista de produse din tabela Product
     */
    public List<Product> findAll() {

        return this.productDAO.findAll();
    }

    /**
     * Metoda care returneaza produsul cu ID-ul corespunzator
     *
     * @param id ID-ul dupa care se cauta clientul in tabela Product
     * @return produsul cu ID-ul cautat
     * @throws Exception daca nu exista un produs cu ID-ul dat ca parametru
     */
    public Product findById(int id) throws Exception {

        Product product = this.productDAO.findById(id);

        if (product == null)
            throw new Exception("Nu exista niciun produs cu acest ID!");

        return product;
    }

    /**
     * Metoda in care se adauga un produs in tabela Product
     *
     * @param product produsul care trebuie sa fie adaugat in tabela Product
     * @return produsul care a fost adaugat
     * @throws Exception daca exista deja un produs cu acel ID
     */
    public Product insert(Product product) throws Exception {

        this.validator.validate(product); // validare produs

        if (this.productDAO.findById(product.getId()) != null)
            throw new Exception("Exista deja un produs cu acest ID!");

        return this.productDAO.insert(product);
    }

    /**
     * Metoda in care se sterge un client in tabela Product
     *
     * @param product produsul care trebuie sa fie sters in tabela Product
     * @return produsul care trebuie sters
     * @throws Exception daca nu exista produsul respectiv
     */
    public Product delete(Product product) throws Exception {

        if (this.productDAO.findById(product.getId()) == null)
            throw new Exception("Nu exista acest produs!");

        Product rezultat = this.productDAO.delete(product);

        return rezultat;
    }

    /**
     * Metoda in care se modifica un produs in tabela Product
     *
     * @param product produsul care trebuie sa fie modificat in tabela Product
     * @return produsul care a fost modificat
     * @throws Exception daca produsul respectiv nu poate fi modificat
     */
    public Product update(Product product) throws Exception {

        Product rezultat = this.findById(product.getId());

        if (rezultat == null)
            throw new Exception("Nu se poate face update la acest product!");

        return this.productDAO.update(product);
    }
}

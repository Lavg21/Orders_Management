package bll.validators;

import models.Product;

/**
 * Clasa in care se valideaza datele primite de pe interfata pentru produs
 */
public class ProductValidator implements Validator<Product> {

    /**
     * Metoda cade valideaza atributele specifice unui produs
     *
     * @param product produsul pentru care se vor face validari
     * @throws Exception daca daca datele produsului sunt invalide
     */
    @Override
    public void validate(Product product) throws Exception {

        if (product.getNume().equals("")) // verificare daca numele nu a fost introdus
            throw new Exception("Nume invalid pentru produs!");

        if (product.getPret() < 1) // verificare pret
            throw new Exception("Pret invalid pentru produs!");

        if (product.getCantitate() < 1) // verificare stoc
            throw new Exception("Cantitate invalida pentru produs!");
    }
}

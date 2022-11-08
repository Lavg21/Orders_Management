package bll.validators;

import models.Order;

/**
 * Clasa in care se valideaza datele primite de pe interfata pentru comanda
 */
public class OrderValidator implements Validator<Order> {

    /**
     * Metoda cade valideaza atributele specifice unei comenzi
     *
     * @param order comanda pentru care se vor face validari
     * @throws Exception daca datele comenzii sunt invalide
     */
    @Override
    public void validate(Order order) throws Exception {

        if (order.getCantitate() < 1) // verificare cantitate
            throw new Exception("Cantitate invalida pentru comanda!");
    }
}

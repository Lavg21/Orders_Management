package bll.validators;

import models.Client;

/**
 * Clasa in care se valideaza datele primite de pe interfata pentru client
 */
public class ClientValidator implements Validator<Client> {

    /**
     * Metoda care valideaza atributele specifice unui client
     *
     * @param client clientul pentru care se vor face validari
     * @throws Exception daca datele clientului sunt invalide
     */
    @Override
    public void validate(Client client) throws Exception {

        if (client.getNume().equals("")) // verificare daca numele nu a fost introdus
            throw new Exception("Nume invalid pentru client!");

        if (client.getAdresa().equals("")) // verificare daca adresa nu a fost introdusa
            throw new Exception("Adresa invalida pentru client!");
    }
}

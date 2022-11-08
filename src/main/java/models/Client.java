package models;

/**
 * Clasa care contine atributele tabelei Client
 */
public class Client {
    private int id;
    private String nume;
    private String adresa;

    /**
     * Constructor pentru clasa Client
     * @param id ID-ul clientului
     * @param nume numele clientului
     * @param adresa adresa de email a clientului
     */
    public Client(int id, String nume, String adresa) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
    }

    /**
     * Metoda de get() pentru ID
     * @return ID-ul
     */
    public int getId() {
        return id;
    }

    /**
     * Metoda de set() pentru ID
     * @param id ID-ul initial
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metoda de get() pentru nume
     * @return numele
     */
    public String getNume() {
        return nume;
    }

    /**
     * Metoda de set() pentru nume
     * @param nume numele initial
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Metoda de get() pentru adresa
     * @return adresa
     */
    public String getAdresa() {
        return adresa;
    }

}

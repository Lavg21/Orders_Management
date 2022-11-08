package models;

/**
 * Clasa care contine atributele tabelei Product
 */
public class Product {
    private int id;
    private String nume;
    private double pret;
    private int cantitate;

    /**
     * Constructor pentru clasa Product
     *
     * @param id        ID-ul produsului
     * @param nume      numele produsului
     * @param pret      pretul produsului
     * @param cantitate stocul produsului
     */
    public Product(int id, String nume, double pret, int cantitate) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    /**
     * Metoda de get() pentru ID
     *
     * @return ID-ul
     */
    public int getId() {
        return id;
    }

    /**
     * Metoda de set() pentru ID
     *
     * @param id ID-ul initial
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metoda de get() pentru nume
     *
     * @return numele
     */
    public String getNume() {
        return nume;
    }

    /**
     * Metoda de set() pentru nume
     *
     * @param nume numele initial
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Metoda de get() pentru pret
     *
     * @return pretul
     */
    public double getPret() {
        return pret;
    }

    /**
     * Metoda de get() pentru cantitate de pe stoc
     *
     * @return cantitatea de pe stoc
     */
    public int getCantitate() {
        return cantitate;
    }

    /**
     * Metoda de set() pentru cantitate de pe stoc
     *
     * @param cantitate cantitatea initiala de pe stoc
     */
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}

package by.weapon.product;

import java.io.Serializable;


public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int price;
    private int idcalibre;


    public Product() {
    }

    public Product(String name, int price, int idcalibre ) {

        this.name = name;
        this.price = price;
        this.idcalibre = idcalibre;

    }

    public Product(int id, String name, int price, int idcalibre) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.idcalibre = idcalibre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdcalibre() {
        return idcalibre;
    }

    public void setIdcalibre(int idcalibre) {
        this.idcalibre = idcalibre;
    }
}


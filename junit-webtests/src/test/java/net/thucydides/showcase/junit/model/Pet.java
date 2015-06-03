package net.thucydides.showcase.junit.model;

/**
 * Created by john on 27/05/2015.
 */
public class Pet {
    private String name;
    private String status;
    private int id;

    public Pet(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

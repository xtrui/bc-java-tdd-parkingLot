package com.oocl.cultivation;

public class Ticket {
    private int id;
    private boolean isValid;

    public Ticket(int id) {
        this.id = id;
        this.isValid = true;
    }

    boolean isValid() {
        return isValid;
    }

    void setValid() {
        this.isValid = false;
    }

    public Ticket() {

    }

    int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

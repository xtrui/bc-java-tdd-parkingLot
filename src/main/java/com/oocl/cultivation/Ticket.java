package com.oocl.cultivation;

public class Ticket {
    private int id;
    private boolean status;

    public Ticket(int id) {
        this.id = id;
        this.status = true;
    }

    boolean isStatus() {
        return status;
    }

    void setStatus(boolean status) {
        this.status = status;
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

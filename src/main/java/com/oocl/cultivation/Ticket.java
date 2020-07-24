package com.oocl.cultivation;

public class Ticket {
    private int id;
    private boolean status;

    public Ticket(int id) {
        this.id = id;
        this.status = true;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Ticket() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

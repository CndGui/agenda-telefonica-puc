package com.agenda.model;

public class Contato {

    private int id;
    private String name;
    private String phone;
    private String email;

    public Contato(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Contato(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Phone: %s | Email: %s", id, name, phone, email);
    }
}

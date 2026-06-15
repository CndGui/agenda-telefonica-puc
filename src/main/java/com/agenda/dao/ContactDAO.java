package com.agenda.dao;

import com.agenda.db.DatabaseConnection;
import com.agenda.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public void create(Contato contact) throws SQLException {
        String sql = "INSERT INTO contacts (name, phone, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            stmt.executeUpdate();
        }
    }

    public Contato findByName(String name) throws SQLException {
        String sql = "SELECT * FROM contacts WHERE LOWER(name) = LOWER(?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Contato(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email")
                );
            }
        }
        throw new IllegalArgumentException("Contact not found: " + name);
    }

    public void update(Contato contact) throws SQLException {
        findByName(contact.getName());
        String sql = "UPDATE contacts SET phone = ?, email = ? WHERE LOWER(name) = LOWER(?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getPhone());
            stmt.setString(2, contact.getEmail());
            stmt.setString(3, contact.getName());
            stmt.executeUpdate();
        }
    }

    public void delete(String name) throws SQLException {
        findByName(name);
        String sql = "DELETE FROM contacts WHERE LOWER(name) = LOWER(?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        }
    }

    public List<Contato> listAll() throws SQLException {
        List<Contato> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts ORDER BY name";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                contacts.add(new Contato(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email")
                ));
            }
        }
        return contacts;
    }
}

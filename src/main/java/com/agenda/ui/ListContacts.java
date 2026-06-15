package com.agenda.ui;

import com.agenda.model.Contato;
import com.agenda.service.AgendaTelefonica;

import java.sql.SQLException;
import java.util.List;

public class ListContacts {

    public static void run(AgendaTelefonica agenda) throws SQLException {
        List<Contato> contacts = agenda.listarContatos();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        System.out.println("\n--- Contacts ---");
        contacts.forEach(System.out::println);
    }
}

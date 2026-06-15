package com.agenda.ui;

import com.agenda.model.Contato;
import com.agenda.service.AgendaTelefonica;

import java.sql.SQLException;
import java.util.Scanner;

public class AddContact {

    public static void run(Scanner scanner, AgendaTelefonica agenda) throws SQLException {
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            throw new IllegalArgumentException("Name and phone are required.");
        }

        agenda.adicionarContato(new Contato(name, phone, email));
        System.out.println("Contact added successfully.");
    }
}

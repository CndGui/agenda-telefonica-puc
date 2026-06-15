package com.agenda.ui;

import com.agenda.model.Contato;
import com.agenda.service.AgendaTelefonica;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateContact {

    public static void run(Scanner scanner, AgendaTelefonica agenda) throws SQLException {
        System.out.print("Name to update: ");
        String name = scanner.nextLine().trim();
        System.out.print("New phone: ");
        String phone = scanner.nextLine().trim();
        System.out.print("New email: ");
        String email = scanner.nextLine().trim();

        if (phone.isEmpty()) {
            throw new IllegalArgumentException("Phone is required.");
        }

        agenda.atualizarContato(new Contato(name, phone, email));
        System.out.println("Contact updated successfully.");
    }
}

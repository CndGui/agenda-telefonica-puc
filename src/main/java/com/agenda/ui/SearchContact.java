package com.agenda.ui;

import com.agenda.model.Contato;
import com.agenda.service.AgendaTelefonica;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchContact {

    public static void run(Scanner scanner, AgendaTelefonica agenda) throws SQLException {
        System.out.print("Name to search: ");
        String name = scanner.nextLine().trim();
        Contato contact = agenda.buscarContato(name);
        System.out.println("Found: " + contact);
    }
}

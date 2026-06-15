package com.agenda.ui;

import com.agenda.service.AgendaTelefonica;

import java.sql.SQLException;
import java.util.Scanner;

public class RemoveContact {

    public static void run(Scanner scanner, AgendaTelefonica agenda) throws SQLException {
        System.out.print("Name to remove: ");
        String name = scanner.nextLine().trim();
        agenda.removerContato(name);
        System.out.println("Contact removed successfully.");
    }
}

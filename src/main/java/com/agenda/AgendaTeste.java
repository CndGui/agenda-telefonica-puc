package com.agenda;

import com.agenda.service.AgendaTelefonica;
import com.agenda.ui.*;

import java.sql.SQLException;
import java.util.Scanner;

public class AgendaTeste {

    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String option = scanner.nextLine().trim();

            try {
                switch (option) {
                    case "1" -> AddContact.run(scanner, agenda);
                    case "2" -> RemoveContact.run(scanner, agenda);
                    case "3" -> SearchContact.run(scanner, agenda);
                    case "4" -> ListContacts.run(agenda);
                    case "5" -> UpdateContact.run(scanner, agenda);
                    case "6" -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please choose 1-6.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== Phone Book =====");
        System.out.println("1. Add new contact");
        System.out.println("2. Remove contact");
        System.out.println("3. Search contact by name");
        System.out.println("4. List all contacts");
        System.out.println("5. Update contact");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }
}

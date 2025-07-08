package com.fawry;

import com.fawry.model.*;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addBook(new PaperBook("P001", "Abstract Algebra", 2010, 300, 5));
        inventory.addBook(new EBook("E001", "AI for Everyone", 2024, 100, "PDF"));
        inventory.addBook(new ShowcaseBook("S001", "Sample Book", 2000, 0));

        try {
            double amount = inventory.buyBook("P001", 4, "example@mail.com", "Cairo, Egypt");
            System.out.println("Paid amount for paper book: " + amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double amount = inventory.buyBook("P001", 10, "example@mail.com", "Cairo, Egypt");
            System.out.println("Paid amount for paper book: " + amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double amount = inventory.buyBook("E01", 1, "example@mail.com", null);
            System.out.println("Paid amount for ebook: " + amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            inventory.buyBook("S001", 1, "example@mail.com", "Cairo");
        } catch (Exception e) {
            System.out.println("Error - " + e.getMessage());
        }

        var removedBooks = inventory.removeOutDatedBooks();
        for (Book b : removedBooks) {
            System.out.println("Removed outdated book - " + b.getTitle());
        }
    }
}
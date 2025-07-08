package com.fawry.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
  private Map<String, Book> books;
  private int currentYear = java.time.Year.now().getValue();
  private int numberOfYearsAsOutdatedBefore = 20;

  public Inventory() {
    books = new HashMap<>();
  }

  public void addBook(Book book) {
    books.put(book.ISBN, book);
  }

  public void removeBook(Book book) {
    books.remove(book.ISBN);
  }

  public List<Book> removeOutDatedBooks() {
    List<Book> outdatedBooks = new ArrayList<>();
    for (Book book : books.values()) {
      if (book.publicationYear < currentYear - numberOfYearsAsOutdatedBefore) {
        outdatedBooks.add(book);
      }
    }
    for (var book : outdatedBooks) {
      books.remove(book.ISBN);
    }
    return outdatedBooks;
  }

  public double buyBook(String isbn, int qty, String email, String address) {
    if (!books.containsKey(isbn))
      throw new IllegalArgumentException("Book with ISBN : " + isbn + " not found");

    Book book = books.get(isbn);
    if (!book.isPurchasable())
      throw new IllegalStateException(" " + book.getTitle() + " is not purchasable");

    if (book instanceof PaperBook) {
      ((PaperBook) book).decreaseQuantity(qty);
      ((PaperBook) book).shipToAddress(address);
      
    } else if (book instanceof EBook) {
      ((EBook) book).sendViaEmail(email);
    } else if (book instanceof ShowcaseBook) {
      throw new IllegalStateException("Showcase books cannot be purchased");
    }
    
    double total = book.price * qty;
    return total;
  }
}

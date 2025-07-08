package com.fawry.model;

public abstract class Book {
  protected String ISBN;
  protected String title;
  protected int publicationYear;
  protected double price;

  public Book(String ISBN, String title, int publicationYear, double price) {
    this.ISBN = ISBN;
    this.title = title;
    this.publicationYear = publicationYear;
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  protected abstract boolean isPurchasable();
}

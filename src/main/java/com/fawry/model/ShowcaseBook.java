package com.fawry.model;

public class ShowcaseBook extends Book {

  public ShowcaseBook(String ISBN, String title, int publicationYear, double price) {
    super(ISBN, title, publicationYear, price);
  }

  @Override
  protected boolean isPurchasable() {
    return false;
  }
}

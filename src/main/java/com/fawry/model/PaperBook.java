package com.fawry.model;

public class PaperBook extends Book {
  private int stock;

  public PaperBook(String ISBN, String title, int publicationYear, double price, int stock) {
    super(ISBN, title, publicationYear, price);
    this.stock = stock;
  }

  public int getStock() {
    return stock;
  }

  public void shipToAddress(String address) {
    System.out.println("Shipping " + title + " to " + address);
    System.out.println("Shipping Successful!");
  }

  public void decreaseQuantity(int qty) {
    if (qty <= 0) {
      throw new IllegalArgumentException("Quantity (" + qty + ") must be greater than zero");
    }
    if (qty > stock) {
      throw new IllegalStateException("Not enough " + title + " in stock");
    }
    this.stock -= qty;
  }

  @Override
  protected boolean isPurchasable() {
    return stock > 0;
  }
}

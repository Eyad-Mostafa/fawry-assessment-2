package com.fawry.model;

public class EBook extends Book {
  private String fileFormat;

  public EBook(String ISBN, String title, int publicationYear, double price, String fileFormat) {
    super(ISBN, title, publicationYear, price);
    this.fileFormat = fileFormat;
  }

  public void sendViaEmail(String email) {
    System.out.println("Sending " + title + " in " + fileFormat + " format to " + email);
    System.out.println("Email Sent Successfully!");
  }

  @Override
  protected boolean isPurchasable() {
    return true;
  }
}

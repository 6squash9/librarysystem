package com.suyash;

public class Book {
    // Attributes (fields) - What a Book HAS
   private String title;
   private String author;
   private String isbn;
   private int totalCopies;
   private int copiesAvailable;

   // Constructor - How to create a Book object
   public Book(String title, String author, String isbn, int totalCopies) {
         this.title = title;
         this.author = author;
         this.isbn = isbn;
         this.totalCopies = totalCopies;
         this.copiesAvailable = totalCopies; // All copies available at the start!
   }
//Getters and Setters - How to access and modify the Book's attributes
   public String getTitle() { return title; }
   public void setTitle(String title) { this.title = title; }

   public String getAuthor() { return author; }
   public void setAuthor(String author) { this.author = author; }

   public String getIsbn() { return isbn; }

   public int getTotalCopies() {
         return totalCopies;
   }
   public int getCopiesAvailable() {
         return copiesAvailable;
   }
   public void setCopiesAvailable(int copiesAvailable) {
            if (copiesAvailable >= 0 && copiesAvailable <= totalCopies) {
                this.copiesAvailable = copiesAvailable;
            } else {
                System.out.println("Invalid number of available copies.");
            }
   }
   // Methods - What a Book can do
   public boolean isAvailable() {
         return copiesAvailable > 0;
   }
   public String getInfo(){
            return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn +
                    ", Total Copies: " + totalCopies + ", Available Copies: " + copiesAvailable;
   }

}

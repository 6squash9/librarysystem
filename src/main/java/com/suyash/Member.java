package com.suyash;

import java.util.ArrayList;
import java.util.List;

public class Member {
    // Attributes (fields) - What a Member HAS
    private String name;
    private String email;
    private int memberID;
    private List<Book> borrowedBooks; // List of borrowed books
    private double fine;

    // Constructor - How to create a Member object
    public Member(String name ,String email,int MemberID) {
        this.name = name;
        this.email = email;
        this.memberID = MemberID;
        this.borrowedBooks = new ArrayList<>(); // Initially, no books borrowed
    }

    // Getters and Setters - How to access and modify the Member's attributes
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getMemberID() {
        return memberID;
    }
    // method to borrow a book
    public void borrowBook(Book book) {
        if(!borrowedBooks.contains(book) && book.isAvailable()) {
            borrowedBooks.add(book);
            book.setCopiesAvailable(book.getCopiesAvailable() - 1);
            System.out.println(this.name + " borrowed: " + book.getTitle());
        }
    }

    // method to return a book
    public void returnBook(Book book){
        if(borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setCopiesAvailable(book.getCopiesAvailable() + 1);
            System.out.println(this.name + " returned: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by " + this.name);

        }
    }

    public String getInfo() {
        return "Name: " + name + ", Email: " + email + ", Member ID: " + memberID +
               ", Borrowed Books Count: " + borrowedBooks.size();
    }

    public void getFineInfo(Transaction transaction) {
        System.out.println("Member: " + name + ", Fine: " + transaction.getFine());
    }
}

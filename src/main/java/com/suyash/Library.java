package com.suyash;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // attributes (fields) - What a Library HAS
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;

    // Constructor - How to create a Library object
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Getters - How to access Library's attributes
    public List<Book> getBooks() {
        return books;
    }
    public List<Member> getMembers() {
        return members;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    //functions
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }
    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found: " + book.getTitle());
        }
    }
    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getInfo());
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }
    public void getAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getInfo());
            }
        }
    }

}

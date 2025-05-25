package com.suyash;

import java.time.LocalDateTime;

public class Transaction implements FineCalculable {
    private int transactionID;
    private Member member;
    private Book book;
    private Librarian librarian;
    private LocalDateTime issueDate;
    private LocalDateTime returnDate;
    private LocalDateTime dueDate;
    private double fine;
    private String type; // Type of transaction (issue/return)


    // Constructor - How to create a Transaction object
    public Transaction(int transactionID, Member member, Book book, Librarian librarian, LocalDateTime issueDate, LocalDateTime dueDate,String type) {
        this.transactionID = transactionID;
        this.member = member;
        this.book = book;
        this.librarian = librarian;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = null; // Initially null until the book is returned
        this.fine = 0.0; // Initially no fine
        this.type = type; // Set the type of transaction
    }

    // Getters and Setters - How to access and modify the Transaction's attributes
    public int getTransactionID() {
        return transactionID;
    }
    public LocalDateTime getIssueDate() {
        return issueDate;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public double getFine() {
        return fine;
    }

    //functions
    // is book returned?
    public boolean isBookReturned() {
        return returnDate != null;
    }
    //get transaction info
    public String getTransactionInfo() {
        String info = "Transaction ID: " + transactionID + "\n" +
                "Member: " + member.getName() + "\n" +
                "Book: " + book.getTitle() + "\n" +
                "Librarian: " + librarian.getName() + "\n" +
                "Issue Date: " + issueDate + "\n" +
                "Due Date: " + dueDate;

        if (isBookReturned()) {
            info += "\nReturn Date: " + returnDate;
            info += "\nFine: $" + fine;
        } else {
            info += "\nBook not returned yet.";
        }
        return info;
    }

    // Method to calculate fine based on the number of days overdue
    @Override
    public double calculateFine() {
        if (returnDate == null || !returnDate.isAfter(dueDate)) {
            return 0.0;
        }
        long daysLate = java.time.temporal.ChronoUnit.DAYS.between(dueDate, returnDate);
        return daysLate * 10.0; // a fine of Rs10 per day late
    }

    @Override
    public String toString() {
        return getTransactionInfo();
    }
}

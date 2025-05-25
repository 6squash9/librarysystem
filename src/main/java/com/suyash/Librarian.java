package com.suyash;

public class Librarian extends Member {
    private String role; //only new field for Librarian

    // Constructor - How to create a Librarian object
    public Librarian(String name,String email,int memberID,String role) {
        super(name,email,memberID); // Call the constructor of the Member class
        this.role = role;
    }
    // Getters and Setters - How to access and modify the Librarian's attributes
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    // Methods - What a Librarian can do
    //issue a book to a member
    public void issueBook(Book book,Member member,Library library) {
        if(book.isAvailable()) {
            library.getTransactions().add(new Transaction(library.getTransactions().size() + 1, member, book, this, java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusDays(14),"ISSUE")); // Add transaction
            member.borrowBook(book);
            System.out.println("Book issued: " + book.getTitle() + " to " + member.getName());
        } else {
            System.out.println("Book not available: " + book.getTitle());
        }
    }

    //return a book from a member
    public void returnBook(Book book, Member member,Library library) {
        library.getTransactions().add(new Transaction(library.getTransactions().size() + 1, member, book, this, java.time.LocalDateTime.now(), null,"RETURN")); // Add transaction
        member.returnBook(book);
        System.out.println("Book returned: " + book.getTitle() + " from " + member.getName());
    }

    // register a new member
    public void registerMember(Member member, Library library) {
        library.addMember(member);
        System.out.println("Member registered: " + member.getName());
    }

    // getInfo method to display Librarian's information
    @Override
    public String getInfo() {
        return super.getInfo() + ", Role: " + role; // Call the getInfo method from Member class and append role
    }
}

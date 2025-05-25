package com.suyash;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("📚 Welcome to Bro Library System Test! 📚\n");

        // 1️⃣ Register Members
        Library library = new Library();
        Librarian librarian = new Librarian("Bro Librarian", "bro@gmail.com", 0, "Head Librarian");
        Member member1 = new Member("Suyash", "s@gmail.com", 1);
        Member member2 = new Member("Aryan","y@gmail.com",2);
        librarian.registerMember(member1, library);
        librarian.registerMember(member2, library);
        System.out.println("✅ Registered Members: " + member1.getName() + ", " + member2.getName());

        // 2️⃣ Add Books
        Book book1 = new Book("Harry Potter", "J.K. Rowling", "9780747532743", 2);
        Book book2 = new Book("1984", "George Orwell", "9780451524935", 1);
        library.addBook(book1);
        library.addBook(book2);
        System.out.println("✅ Added books: " + book1.getTitle() + ", " + book2.getTitle());



        // 3️⃣ Member1 borrows Harry Potter
        System.out.println("\n➡️ " + member1.getName() + " tries to borrow " + book1.getTitle());
        librarian.issueBook(book1, member1, library);

        // 4️⃣ Member2 borrows Harry Potter (should succeed, 2 copies)
        System.out.println("\n➡️ " + member2.getName() + " tries to borrow " + book1.getTitle());
        librarian.issueBook(book1, member2, library);

        // 5️⃣ Member1 tries to borrow 1984
        System.out.println("\n➡️ " + member1.getName() + " tries to borrow " + book2.getTitle());
        librarian.issueBook(book2, member1, library);

        // 6️⃣ Member2 tries to borrow 1984 (should fail, only 1 copy)
        System.out.println("\n➡️ " + member2.getName() + " tries to borrow " + book2.getTitle());
        librarian.issueBook(book2, member2, library);

        // 7️⃣ Print Book Status
        System.out.println("\n📚 Book Status:");
        for (Book b : library.getBooks()) {
            System.out.println(b.getTitle() + " - Available: " + b.getCopiesAvailable() + "/" + b.getTotalCopies());
        }

        // 8️⃣ Member1 returns Harry Potter
        System.out.println("\n🔄 " + member1.getName() + " returns " + book1.getTitle());
        librarian.returnBook(book1, member1, library);

        // 9️⃣ Member1 returns 1984
        System.out.println("\n🔄 " + member1.getName() + " returns " + book2.getTitle());
        librarian.returnBook(book2, member1, library);

        // 🔟 Member2 tries to return 1984 (should fail or do nothing if not borrowed)
        System.out.println("\n🔄 " + member2.getName() + " tries to return " + book2.getTitle());
        librarian.returnBook(book2, member2, library);

        // 1️⃣1️⃣ Simulate overdue: Manually set a past borrow date for fine calculation (if your Transaction/fine logic allows)
        // For demo, you can add a method or tweak Transaction to simulate overdue and calculate fine.

        // 1️⃣2️⃣ Show all Transactions
        System.out.println("\n📒 All Transactions:");
        for (Transaction t : library.getTransactions()) {
            System.out.println(t);
        }

        // 1️⃣3️⃣ Show Member Info
        System.out.println("\n👤 Member Info:");
        System.out.println(member1.getInfo());
        System.out.println(member2.getInfo());
        System.out.println("👨‍💼 Librarian Info: " + librarian.getInfo());
        System.out.println("📚 Library has " + library.getBooks().size() + " books and " + library.getMembers().size() + " members.");
        System.out.println("📖 Library has " + library.getTransactions().size() + " transactions recorded.");
        // 1️⃣4️⃣ Show Available Books
        System.out.println("\n📖 Available Books:");
        library.getAvailableBooks();
        // 1️⃣5️⃣ Show All Books
        System.out.println("\n📚 All Books in Library:");
        for (Book b : library.getBooks()) {
            System.out.println(b.getInfo());
        }
        // 1️⃣6️⃣ Show All Members
        System.out.println("\n👥 All Members in Library:");
        for (Member m : library.getMembers()) {
            System.out.println(m.getInfo());
        }
        // 1️⃣7️⃣ Show All Transactions
        System.out.println("\n📜 All Transactions in Library:");
        for (Transaction t : library.getTransactions()) {
            System.out.println(t.getTransactionInfo());
        }



        System.out.println("\n🎉 All tests complete! If the output above matches expectations, your code is working well, bro!");
    }
}

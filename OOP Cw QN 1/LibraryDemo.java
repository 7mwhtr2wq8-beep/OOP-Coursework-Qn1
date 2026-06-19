public class LibraryDemo {

    public static void main(String[] args) {

        Library library = new Library();

        // Books
        Book b1 = new Book(
                "ISBN001",
                "Clean Code",
                "Robert M");

        Book b2 = new Book(
                "ISBN002",
                "Java Programming",
                "James G");

        Book b3 = new Book(
                "ISBN003",
                "Data Structures",
                "Mark W");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Members
        Member m1 = new Member(
                "M001",
                "Alice");

        Member m2 = new Member(
                "M002",
                "Brian");

        library.registerMember(m1);
        library.registerMember(m2);

        System.out.println(" BEFORE OPERATIONS ");
        System.out.println(library);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(m1);
        System.out.println(m2);

        System.out.println();

        // Successful Loans
        library.lendBook("ISBN001", "M001");
        library.lendBook("ISBN002", "M002");

        // Rejected Loan
        library.lendBook("ISBN001", "M002");

        // Return
        library.returnBook("ISBN001");

        System.out.println();

        System.out.println(" AFTER OPERATIONS ");
        System.out.println(library);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(m1);
        System.out.println(m2);
    }
}

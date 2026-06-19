import java.util.ArrayList;
import java.util.Date;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Book searchBookByTitle(String title) {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    public Loan lendBook(String isbn, String memberId) {

        Book selectedBook = null;
        Member selectedMember = null;

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                selectedBook = book;
                break;
            }
        }

        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                selectedMember = member;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("Book not found.");
            return null;
        }

        if (selectedMember == null) {
            System.out.println("Member not found.");
            return null;
        }

        // Business Rule:
        if (!selectedBook.isAvailable()) {
            System.out.println("Loan Rejected: Book already on loan.");
            return null;
        }

        Date borrowDate = new Date();

        Date dueDate = new Date(
                borrowDate.getTime() + (7L * 24 * 60 * 60 * 1000));

        Loan loan = new Loan(
                selectedBook,
                selectedMember,
                borrowDate,
                dueDate);

        selectedBook.setAvailable(false);
        selectedMember.addLoan(loan);

        System.out.println(
                selectedBook.getTitle() +
                " successfully lent to " +
                selectedMember.getName());

        return loan;
    }

    public void returnBook(String isbn) {

        for (Member member : members) {

            ArrayList<Loan> loans =
                    new ArrayList<>(member.getLoans());

            for (Loan loan : loans) {

                if (loan.getBook().getIsbn().equals(isbn)) {

                    loan.getBook().setAvailable(true);
                    member.removeLoan(loan);

                    System.out.println(
                            loan.getBook().getTitle() +
                            " successfully returned.");

                    return;
                }
            }
        }

        System.out.println("No active loan found.");
    }

    @Override
    public String toString() {
        return "Library [Books=" + books.size() +
                ", Members=" + members.size() + "]";
    }
}
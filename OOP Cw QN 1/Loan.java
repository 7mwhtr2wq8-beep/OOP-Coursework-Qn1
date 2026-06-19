import java.util.Date;

public class Loan {
    private Book book;
    private Member member;
    private Date borrowDate;
    private Date dueDate;

    public Loan(Book book, Member member, Date borrowDate, Date dueDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Loan [Book=" + book.getTitle() +
                ", Member=" + member.getName() +
                ", Borrow Date=" + borrowDate +
                ", Due Date=" + dueDate + "]";
    }
}
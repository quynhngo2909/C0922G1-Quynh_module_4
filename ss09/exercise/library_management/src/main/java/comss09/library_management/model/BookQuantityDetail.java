package comss09.library_management.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BookQuantityDetail {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @OneToMany(mappedBy = "bookQuantityDetail" )
    private Set<BookLoanCard> bookLoanCard;

    public BookQuantityDetail() {
    }

    public BookQuantityDetail(String id, Book book, Set<BookLoanCard> bookLoanCard) {
        this.id = id;
        this.book = book;
        this.bookLoanCard = bookLoanCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<BookLoanCard> getBookLoanCard() {
        return bookLoanCard;
    }

    public void setBookLoanCard(Set<BookLoanCard> bookLoanCard) {
        this.bookLoanCard = bookLoanCard;
    }
}
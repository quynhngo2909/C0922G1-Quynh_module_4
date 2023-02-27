package comss09.library_management.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "loan_card_detail")
public class LoanCardDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "is_returned", columnDefinition = "boolean default false")
    private boolean isReturned = false;

    @ManyToOne
    @JoinColumn(name = "loan_card_id", referencedColumnName = "id")
    private LoanCard loanCard;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookLib book;

    @Min(value = 1, message = "Borrow quantity must be >= 1.")
    private int quantity;

    public LoanCardDetail() {
    }

    public LoanCardDetail(int id, LoanCard loanCard, BookLib book, int quantity) {
        this.id = id;
        this.loanCard = loanCard;
        this.book = book;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoanCard getLoanCard() {
        return loanCard;
    }

    public void setLoanCard(LoanCard loanCard) {
        this.loanCard = loanCard;
    }

    public BookLib getBook() {
        return book;
    }

    public void setBook(BookLib book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

}

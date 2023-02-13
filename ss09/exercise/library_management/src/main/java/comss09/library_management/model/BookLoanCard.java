package comss09.library_management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookLoanCard {
    @Id
    private String id;
    private String startedLoanDate;
    private String dueDate;

    private boolean isReturned = false;

    @ManyToOne
    @JoinColumn(name = "book_qty_detail_id", referencedColumnName = "id")
    private BookQuantityDetail bookQuantityDetail;


    public BookLoanCard() {
    }

    public BookLoanCard(String id, String startedLoanDate, String dueDate, boolean isReturned, BookQuantityDetail bookQuantityDetail) {
        this.id = id;
        this.startedLoanDate = startedLoanDate;
        this.dueDate = dueDate;
        this.isReturned = isReturned;
        this.bookQuantityDetail = bookQuantityDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartedLoanDate() {
        return startedLoanDate;
    }

    public void setStartedLoanDate(String startedLoanDate) {
        this.startedLoanDate = startedLoanDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public BookQuantityDetail getBookQuantityDetail() {
        return bookQuantityDetail;
    }

    public void setBookQuantityDetail(BookQuantityDetail bookQuantityDetail) {
        this.bookQuantityDetail = bookQuantityDetail;
    }
}

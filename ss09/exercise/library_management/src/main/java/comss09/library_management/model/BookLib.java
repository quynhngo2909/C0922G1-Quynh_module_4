package comss09.library_management.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookLib {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "description")
    private String description;
    @Column(name = "quantity")
    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<LoanCardDetail> loanCardDetails;

    public BookLib() {
    }

    public BookLib(int id, String name, String author, String description, int quantity, Set<LoanCardDetail> loanCardDetails) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.loanCardDetails = loanCardDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<LoanCardDetail> getLoanCardDetails() {
        return loanCardDetails;
    }

    public void setLoanCardDetails(Set<LoanCardDetail> loanCardDetails) {
        this.loanCardDetails = loanCardDetails;
    }
}
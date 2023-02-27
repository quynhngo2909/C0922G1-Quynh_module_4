package comss09.library_management.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "loan_card")
public class LoanCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany(mappedBy = "loanCard")
    private Set<LoanCardDetail> loanCardDetails;

    public LoanCard() {
    }

    public LoanCard(int id, String name, Set<LoanCardDetail> loanCardDetails) {
        this.id = id;
        this.name = name;
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

    public Set<LoanCardDetail> getLoanCardDetails() {
        return loanCardDetails;
    }

    public void setLoanCardDetails(Set<LoanCardDetail> loanCardDetails) {
        this.loanCardDetails = loanCardDetails;
    }
}

package comss09.library_management.repository.book_loan_card;


import comss09.library_management.model.BookLoanCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoanCardRepository extends JpaRepository<BookLoanCard, Integer> {
}

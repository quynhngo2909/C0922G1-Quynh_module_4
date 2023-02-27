package comss09.library_management.repository;

import comss09.library_management.model.LoanCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoanCardRepository extends JpaRepository<LoanCard, Integer> {

}

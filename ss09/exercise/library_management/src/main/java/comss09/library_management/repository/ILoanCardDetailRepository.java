package comss09.library_management.repository;

import comss09.library_management.model.LoanCardDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ILoanCardDetailRepository extends JpaRepository<LoanCardDetail, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update loan_card_detail set is_returned = true where id = :id", nativeQuery = true)
    void deActive(@Param("id") int id);

    @Query(value = "select * from `loan_card_detail` where is_returned = false", nativeQuery = true)
    Page<LoanCardDetail> getLoanCards(Pageable pageable);

}

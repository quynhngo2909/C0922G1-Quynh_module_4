package comss09.library_management.service;

import comss09.library_management.model.LoanCardDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILoanCardDetailService extends  IGeneralService<LoanCardDetail> {
    void deActive(int id);
    Page<LoanCardDetail> getLoanCards(Pageable pageable);
}

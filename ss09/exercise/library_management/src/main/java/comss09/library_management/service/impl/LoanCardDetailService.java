package comss09.library_management.service.impl;

import comss09.library_management.model.LoanCardDetail;
import comss09.library_management.repository.ILoanCardDetailRepository;
import comss09.library_management.service.ILoanCardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanCardDetailService implements ILoanCardDetailService {
    @Autowired
    private ILoanCardDetailRepository loanCardDetailRepository;
    @Override
    public List<LoanCardDetail> getAll() {
        return loanCardDetailRepository.findAll();
    }

    @Override
    public void save(LoanCardDetail loanCardDetail) {
        loanCardDetailRepository.save(loanCardDetail);
    }

    @Override
    public void delete(int id) {
        loanCardDetailRepository.deleteById(id);
    }

    @Override
    public LoanCardDetail findById(int id) {
        return loanCardDetailRepository.findById(id).get();
    }

    @Override
    public void deActive(int id) {
        loanCardDetailRepository.deActive(id);
    }

    @Override
    public Page<LoanCardDetail> getLoanCards(Pageable pageable) {
        return loanCardDetailRepository.getLoanCards(pageable);
    }
}

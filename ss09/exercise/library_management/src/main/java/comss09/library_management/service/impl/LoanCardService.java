package comss09.library_management.service.impl;

import comss09.library_management.model.LoanCard;
import comss09.library_management.repository.ILoanCardRepository;
import comss09.library_management.service.ILoanCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanCardService implements ILoanCardService {
    @Autowired
    private ILoanCardRepository loanCardRepository;

    @Override
    public List<LoanCard> getAll() {
        return loanCardRepository.findAll();
    }

    @Override
    public void save(LoanCard loanCard) {
        loanCardRepository.save(loanCard);
    }

    @Override
    public void delete(int id) {
        loanCardRepository.deleteById(id);
    }

    @Override
    public LoanCard findById(int id) {
        return loanCardRepository.findById(id).get();
    }
}



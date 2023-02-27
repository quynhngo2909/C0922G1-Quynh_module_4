package comss09.library_management.controller;

import comss09.library_management.model.LoanCardDetail;
import comss09.library_management.service.ILoanCardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loanCard")
public class LoanCardController {
    @Autowired
    private ILoanCardDetailService loanCardDetailService;

    @GetMapping("")
    private String getAll(Model model, @PageableDefault(size = 2)Pageable pageable){
        Page<LoanCardDetail> loanCardDetails = loanCardDetailService.getLoanCards(pageable);
        model.addAttribute("loanCardDetails", loanCardDetails);
        return "/loanCard/loanCardList";
    }
}

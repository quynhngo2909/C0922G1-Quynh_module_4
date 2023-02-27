package comss09.library_management.controller;

import comss09.library_management.dto.BookLibDto;
import comss09.library_management.dto.LoanCardDetailDto;
import comss09.library_management.dto.LoanCardDto;
import comss09.library_management.model.BookLib;
import comss09.library_management.model.LoanCard;
import comss09.library_management.model.LoanCardDetail;
import comss09.library_management.service.IBookLibService;
import comss09.library_management.service.ILoanCardDetailService;
import comss09.library_management.service.ILoanCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookLibService bookLibService;
    @Autowired
    private ILoanCardService loanCardService;
    @Autowired
    private ILoanCardDetailService loanCardDetailService;

    @GetMapping("")
    public String getBooks(Model model, @PageableDefault(size = 2, sort = "name", direction = Sort.Direction.DESC) Pageable pageable,
                           @RequestParam(name = "name", defaultValue = "") String name, @RequestParam(name = "author", defaultValue = "") String author) {
        Page<BookLib> books = bookLibService.getBooks(name, author, pageable);
        model.addAttribute("books", books);
        model.addAttribute("name", name);
        model.addAttribute("author", author);
        return "/book/listBook";
    }

    @GetMapping("/borrow-book/{id}")
    public String borrowBookForm(Model model, @PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        BookLib book = bookLibService.findById(id);
        LoanCardDto loanCardDto = new LoanCardDto();
        loanCardDto.setBookId(book.getId());
        model.addAttribute("loanCardDto", loanCardDto);
        model.addAttribute("book", book);
        if (book == null) {
            redirectAttributes.addFlashAttribute("message", " This book is not existed!");
            return "redirect:/book";
        }
        if (book.getQuantity() < 1) {
            redirectAttributes.addFlashAttribute("message", " This book is not available. All is borrowed!");
            return "redirect:/book";
        }
        return "/book/borrowBook";
    }

    @PostMapping("/saveLoanCard")
    public String saveLoanCard(@ModelAttribute LoanCardDto loanCardDto, RedirectAttributes redirectAttributes) {
        BookLib book = bookLibService.findById(loanCardDto.getBookId());
        LoanCard loanCard = new LoanCard();
        LoanCardDetail loanCardDetail = new LoanCardDetail();
        BeanUtils.copyProperties(loanCardDto, loanCard);
        loanCardService.save(loanCard);
        bookLibService.leanBook(book.getId(), loanCardDto.getBookQty());
        loanCardDetail.setBook(book);
        loanCardDetail.setLoanCard(loanCard);
        loanCardDetail.setQuantity(loanCardDto.getBookQty());
        loanCardDetailService.save(loanCardDetail);

        redirectAttributes.addFlashAttribute("message", " The loan card was created" + loanCard.getName());
        return "redirect:/book";
    }

    @GetMapping("/return-book/{id}")
    public String returnBook(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes){
        LoanCardDetail loanCardDetail = loanCardDetailService.findById(id);
        if(loanCardDetail == null){
            redirectAttributes.addFlashAttribute("message", "The loan card is not existed!");
            return "redirect:/loanCard";
        }

        if(loanCardDetail.isReturned() == true){
            redirectAttributes.addFlashAttribute("message", "The loan card was returned!");
            return "redirect:/loanCard";
        }
        bookLibService.returnBook(loanCardDetail.getBook().getId(), loanCardDetail.getQuantity());
        loanCardDetailService.deActive(id);
        redirectAttributes.addFlashAttribute("message", "The loan card has been returned successful!");
        return "redirect:/book";
    }

}

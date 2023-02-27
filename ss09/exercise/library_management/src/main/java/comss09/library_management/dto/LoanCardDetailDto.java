package comss09.library_management.dto;


public class LoanCardDetailDto {

    private int id;
    private LoanCardDto loanCardDto;
    private BookLibDto bookDto;
    private int quantity;

    public LoanCardDetailDto() {
    }

    public LoanCardDetailDto(int id, LoanCardDto loanCardDtoName, BookLibDto book, int quantity) {
        this.id = id;
        this.loanCardDto = loanCardDtoName;
        this.bookDto = book;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoanCardDto getLoanCardDto() {
        return loanCardDto;
    }

    public void setLoanCardDto(LoanCardDto loanCardDto) {
        this.loanCardDto = loanCardDto;
    }

    public BookLibDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookLibDto bookDto) {
        this.bookDto = this.bookDto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

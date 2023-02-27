package comss09.library_management.dto;

public class LoanCardDto {
    private int id;
    private String name;
    private int bookId;
    private int bookQty;

    public LoanCardDto() {
    }

    public LoanCardDto(int id, String name, int bookId, int bookQty) {
        this.id = id;
        this.name = name;
        this.bookId = bookId;
        this.bookQty = bookQty;
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookQty() {
        return bookQty;
    }

    public void setBookQty(int bookQty) {
        this.bookQty = bookQty;
    }
}
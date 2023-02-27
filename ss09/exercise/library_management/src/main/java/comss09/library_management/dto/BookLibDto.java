package comss09.library_management.dto;


public class BookLibDto {
    private int id;
    private String name;
    private String author;
    private String description;
    private int quantity;

    public BookLibDto() {
    }

    public BookLibDto(int id, String name, String author, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

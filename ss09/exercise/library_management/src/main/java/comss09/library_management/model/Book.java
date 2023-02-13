package comss09.library_management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Book {
    @Id
    private String id;
    private String name;
    private String author;
    @OneToMany(mappedBy = "book")
    private Set<BookQuantityDetail> bookQuantityDetailList;

    public Book() {
    }

    public Book(String id, String name, String author, Set<BookQuantityDetail> bookQuantityDetailList) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.bookQuantityDetailList = bookQuantityDetailList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Set<BookQuantityDetail> getBookQuantityDetailList() {
        return bookQuantityDetailList;
    }

    public void setBookQuantityDetailList(Set<BookQuantityDetail> bookQuantityDetailList) {
        this.bookQuantityDetailList = bookQuantityDetailList;
    }
}


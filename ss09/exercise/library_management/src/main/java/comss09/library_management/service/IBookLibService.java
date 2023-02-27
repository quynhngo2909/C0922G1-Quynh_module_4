package comss09.library_management.service;

import comss09.library_management.model.BookLib;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.awt.print.Book;


public interface IBookLibService extends IGeneralService<BookLib>{

    Page<BookLib> getBooks(String name, String author, Pageable pageable);

    void leanBook(int id, int qty);

    void returnBook(int id, int qty);
}

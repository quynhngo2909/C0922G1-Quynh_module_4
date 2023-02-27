package comss09.library_management.service.impl;

import comss09.library_management.model.BookLib;
import comss09.library_management.repository.IBookLibRepository;
import comss09.library_management.service.IBookLibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookLibService implements IBookLibService {
    @Autowired
    private IBookLibRepository bookRepository;

    @Override
    public List<BookLib> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(BookLib bookLib) {
        bookRepository.save(bookLib);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookLib findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Page<BookLib> getBooks(String name, String author, Pageable pageable) {
        return bookRepository.getBooks(name, author, pageable);
    }

    @Override
    public void leanBook(int id, int qty) {
        bookRepository.leanBook(id, qty);
    }

    @Override
    public void returnBook(int id, int qty) {
        bookRepository.returnBook(id, qty );
    }
}

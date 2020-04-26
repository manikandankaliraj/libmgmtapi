package org.mk.librarymgmt.service.impl;

import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.entity.Library;
import org.mk.librarymgmt.repository.BookRepository;
import org.mk.librarymgmt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Manikandan
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> getLibBooks(Library library) throws Exception {
        return Optional.ofNullable(bookRepository.findAllBylibraryId(library.getId()))
                .orElse(new ArrayList<>());
    }

    @Override
    public Book getBookDetails(Long bookId) throws Exception {

        return Optional.ofNullable(bookRepository.findById(bookId))
                .orElseThrow(() -> new Exception("Book not exists"))
                .get();
    }

    @Override
    public List<Book> getAllBooks() throws Exception {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) throws Exception {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book ,Long bookId) throws Exception {
        Optional.ofNullable(bookRepository.findById(bookId))
                .orElseThrow(()-> new Exception("Book not exists"));
        book.setId(bookId);
       return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) throws Exception {
        Optional.ofNullable(bookRepository.findById(bookId))
                .orElseThrow(() -> new Exception("Book not exists"))
                .ifPresent(book -> bookRepository.delete(book));
    }
}

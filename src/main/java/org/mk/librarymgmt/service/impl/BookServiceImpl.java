package org.mk.librarymgmt.service.impl;

import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.entity.Library;
import org.mk.librarymgmt.repository.BookRepository;
import org.mk.librarymgmt.service.BookService;
import org.mk.librarymgmt.service.ValidationCollection;
import org.mk.librarymgmt.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    ValidationCollection validators;




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
        validators.addValidator(new BookValidator());
        for(Validator  validator:validators.getValidators()) {
            if (validator.validate(book))
                bookRepository.save(book);
            else
                throw new Exception("validation failed");
        }
        return book;
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

package org.mk.librarymgmt.service;

import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.entity.Library;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Manikandan
 */
public interface BookService {

    List<Book> getLibBooks(Library library) throws Exception;

    Book getBookDetails(Long bookId) throws Exception;

    List<Book> getAllBooks() throws Exception;

    Book addBook(Book book) throws Exception;

    Book updateBook(Book book,Long bookId) throws Exception;

    void deleteBook(Long bookId) throws Exception;


}

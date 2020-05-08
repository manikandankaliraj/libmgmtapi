package org.mk.librarymgmt.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.repository.BookRepository;
import org.mk.librarymgmt.service.BookService;
import org.mk.librarymgmt.service.ValidationCollection;
import org.mk.librarymgmt.service.impl.BookServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.Assert.assertEquals;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author Manikandan
 */
@RunWith(MockitoJUnitRunner.class)
public class BookServicesTest {
    @Mock
    BookRepository bookRepository;

    @Mock
    ValidationCollection validationCollection;

    @InjectMocks
    BookServiceImpl bookService;

    @Test
    public void when_save_book_it_should_return_book() throws Exception{
        Book book  = new Book("BugCoding in Java","Martin",Long.parseLong("1"));
//        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book book1 = bookService.addBook(book);
        assertEquals(book.getTitle(),book1.getTitle());
    }
}

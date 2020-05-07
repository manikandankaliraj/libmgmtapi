package org.mk.librarymgmt.controllers;

import org.mk.librarymgmt.dto.Response;
import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Manikandan
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BooksController {

    @Autowired
    BookService bookService;


    @GetMapping("/books")
    public List<Book> getAllBooks() throws Exception {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getAllBooks(@PathVariable Long bookId) throws Exception {
        return new ResponseEntity<Book>(bookService.getBookDetails(bookId), HttpStatus.OK);

    }

    @PostMapping("/books")
    public ResponseEntity addBook(@RequestBody Book book) throws Exception {
        try{
            bookService.addBook(book);
        }catch(Exception e){
            Response resp = new Response();
            resp.setSuccess(false);
            resp.setRespMsg(e.getMessage());
            return new ResponseEntity<Object>(resp, HttpStatus.OK);
        }
        return new ResponseEntity<Object>(book, HttpStatus.OK);

    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity updateBook(@RequestBody Book book, @PathVariable Long bookId) throws Exception {
        System.out.println(bookId);
        return new ResponseEntity<Book>(bookService.updateBook(book, bookId), HttpStatus.OK);
    }

    @DeleteMapping("/books/{bookId}")
    public Response deleteBook(@PathVariable Long bookId) throws Exception {
        try {
            bookService.deleteBook(bookId);
            return new Response(true, "Book deleted");
        } catch (Exception e) {
            return new Response(false, e.getMessage());
        }
    }


}

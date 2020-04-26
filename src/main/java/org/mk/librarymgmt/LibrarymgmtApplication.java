package org.mk.librarymgmt;

import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.entity.Library;
import org.mk.librarymgmt.service.BookService;
import org.mk.librarymgmt.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
public class LibrarymgmtApplication {

    @Autowired
    LibraryService libraryService;

    @Autowired
    BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(LibrarymgmtApplication.class, args);
    }

    @Bean
    public CommandLineRunner bookDemo() {
        return (args) -> {

            Library l1 = libraryService.addLibrary(new Library("Newyork Library"));



            bookService.addBook(new Book("Thinking in Java","Martin", l1.getId()));
            bookService.addBook(new Book("Master in finance","uno", l1.getId()));
            bookService.addBook(new Book("Arch the code","Billy", l1.getId()));
            bookService.addBook(new Book("Bug Coder","James", l1.getId()));
            bookService.addBook(new Book("Life with peace","kathrin", l1.getId()));
            bookService.addBook(new Book("Why should i work","Tin", l1.getId()));

           Library l2=  libraryService.addLibrary(new Library("SanFran Library"));

            bookService.addBook(new Book("BugCoding in Java","Martin", l2.getId()));
            bookService.addBook(new Book("Master in excel","Ice", l2.getId()));
            bookService.addBook(new Book("Arch the code","Billy",  l2.getId()));
            bookService.addBook(new Book("Bug Coder","James",  l2.getId()));
            bookService.addBook(new Book("No Money with peace","kathrin",  l2.getId()));
            bookService.addBook(new Book("Why should i work","KIM",  l2.getId()));

        };
    }


}

package org.mk.librarymgmt.service.impl;

import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.entity.Library;
import org.mk.librarymgmt.repository.BookRepository;
import org.mk.librarymgmt.repository.LibraryRepository;
import org.mk.librarymgmt.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Manikandan
 */
@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    LibraryRepository libRepo;

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Library> getAllLibs() throws Exception {
        return libRepo.findAll();
    }

    @Override
    public Library addLibrary(Library library) throws Exception {
        return libRepo.save(library);

    }

    @Override
    public List<Book> getLibBooks(Long libId) throws Exception {
        return Optional.ofNullable(bookRepository.findAllBylibraryId(libId)).orElse(new ArrayList<>());
    }
}

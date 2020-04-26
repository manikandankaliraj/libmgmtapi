package org.mk.librarymgmt.service;

import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.entity.Library;

import java.util.List;

/**
 * @author Manikandan
 */
public interface LibraryService {

    List<Library> getAllLibs() throws Exception;

    Library addLibrary(Library library) throws Exception;

    List<Book> getLibBooks(Long libId) throws Exception;

}

package org.mk.librarymgmt.controllers;

import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.entity.Library;
import org.mk.librarymgmt.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manikandan
 */
@RestController
@CrossOrigin(origins = "${cross.origin.url}")
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @GetMapping("/libraries")
    public List<Library> getAllLibs() throws Exception{
        return libraryService.getAllLibs();
    }

    @GetMapping("/libraries/{libId}")
    public List<Book> getAllLibs(@PathVariable Long libId) throws Exception{
        return libraryService.getLibBooks(libId);
    }



}

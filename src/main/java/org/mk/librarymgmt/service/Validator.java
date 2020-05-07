package org.mk.librarymgmt.service;

import org.mk.librarymgmt.entity.Book;

/**
 * @author Manikandan
 */
public interface Validator {
    boolean validate(Book book) throws Exception;
}

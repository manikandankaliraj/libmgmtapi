package org.mk.librarymgmt.service.impl;

import org.mk.librarymgmt.entity.Book;
import org.mk.librarymgmt.service.Validator;
import org.springframework.stereotype.Component;

/**
 * @author Manikandan
 */
@Component
public class BookValidator implements Validator {
    @Override
    public boolean validate(Book book) throws Exception {
        return false;
    }
}

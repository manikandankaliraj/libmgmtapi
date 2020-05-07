package org.mk.librarymgmt.service.impl;

import org.mk.librarymgmt.entity.Book;
import org.springframework.stereotype.Component;

/**
 * @author Manikandan
 */
@Component("zipcodevalidator")
public class ZipCodeValidator extends BookValidator {
    @Override
    public boolean validate(Book book) throws Exception {
        //My logic for validation
        return false;
    }
}

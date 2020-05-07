package org.mk.librarymgmt.service;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Manikandan
 */
@Component
public class ValidationCollection {
    public List<Validator> getValidators() {
        return validators;
    }

    public void setValidators(List<Validator> validators) {
        this.validators = validators;
    }

    private List<Validator> validators;


    public void addValidator(Validator validator){
        validators.add(validator);
    }

}

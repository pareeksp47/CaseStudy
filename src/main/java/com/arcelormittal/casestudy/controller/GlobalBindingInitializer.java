package com.arcelormittal.casestudy.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 
 * @author Pareek
 */
@ControllerAdvice
public class GlobalBindingInitializer {

    /**
     * Default constructor.
     */
    public GlobalBindingInitializer() {
        super();
    }

    /**
     * Sets the fields which can't be bound.
     * 
     * @param dataBinder
     *            data binder
     */
    @InitBinder
    public void setDisallowedFields(final WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}

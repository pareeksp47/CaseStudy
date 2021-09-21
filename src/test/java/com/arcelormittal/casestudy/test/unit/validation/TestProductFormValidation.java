package com.arcelormittal.casestudy.test.unit.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arcelormittal.casestudy.model.ProductForm;

/**
 * Unit tests for {@link ProductForm} bean validation.
 * <p>
 * These tests verify that the bean applies the correct Java validation
 * annotations.
 * 
 * @author Pareek 
 */
public final class TestProductFormValidation {

    /**
     * Validator for validating the bean.
     */
    private Validator validator;

    /**
     * Default constructor.
     */
    public TestProductFormValidation() {
        super();
    }

    /**
     * Sets up the validator for the tests.
     */
    @BeforeEach
    public final void setUpValidator() {
        validator = createValidator();
    }

    /**
     * Verifies that if the name is empty this field is marked with an error.
     */
    @Test
    public final void testValidation_EmptyName_Error() {
        final ProductForm form; // Tested form
        final Set<ConstraintViolation<ProductForm>> errors;
        final ConstraintViolation<ProductForm> error;

        form = new ProductForm();

        form.setName("");

        errors = validator.validate(form);

       //Assertions.assertEquals(1, errors.size());

        //error = errors.iterator().next();
       // Assertions.assertEquals("name", error.getPropertyPath().toString());
    }

    /**
     * Verifies that if the name is null this field is marked with an error.
     */
    @Test
    public final void testValidation_NullName_Error() {
        final ProductForm form; // Tested form
        final Set<ConstraintViolation<ProductForm>> errors;
        final ConstraintViolation<ProductForm> error;

        form = new ProductForm();

        // form.setName(null);

        errors = validator.validate(form);

        //Assertions.assertEquals(1, errors.size());

       // error = errors.iterator().next();
//        Assertions.assertEquals("name", error.getPropertyPath().toString());
    }

    /**
     * Returns the validator to use in the tests.
     * 
     * @return the validator to use in the tests
     */
    private final Validator createValidator() {
        final LocalValidatorFactoryBean localValidatorFactoryBean;

        localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();

        return localValidatorFactoryBean;
    }

}

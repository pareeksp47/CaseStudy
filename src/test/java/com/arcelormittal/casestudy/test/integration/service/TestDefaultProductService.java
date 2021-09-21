package com.arcelormittal.casestudy.test.integration.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.arcelormittal.casestudy.Application;
import com.arcelormittal.casestudy.model.ProductForm;

import com.arcelormittal.casestudy.service.ProductService;
import com.google.common.collect.Iterables;

/**
 * Integration tests for the {@link ExampleEntityService}.
 * <p>
 * As this service doesn't contain any actual business logic, and it just wraps
 * the example entities repository, these tests are for verifying everything is
 * set up correctly and working.
 */
@SpringJUnitConfig
@Transactional
@SpringBootTest(classes = Application.class)
public class TestDefaultProductService {

    /**
     * Service being tested.
     */
    @Autowired
    private ProductService service;

    /**
     * Default constructor.
     */
    public TestDefaultProductService() {
        super();
    }

    /**
     * Verifies that the service adds entities into persistence.
     */
    @Test
    public void testGetAllProduct() {
        final Integer productSize;       // Original number of products

        productSize = Iterables.size(service.getAllProduct());

        Assertions.assertEquals(productSize, 3);
    }

    /**
     * Verifies that the service adds entities into persistence.
     */
    @Test
    public void testCalculatePrice() {
        
    	ProductForm product = new ProductForm(1, "product1", 0.0, "euro");        // Created product
    	service.calculatePrice(product);
    	// price is calculated and the field value is updated.
        Assertions.assertNotEquals(0.0, product.getValue(),"price is calculated and it should be zero"); 
    }

    /**
     * Verifies that the service adds entities into persistence.
     */
    @Test
    public void testExchangeRateValue() {
        
    	ProductForm product = new ProductForm(1, "product1", 100.0, "euro");        // Created product
    	service.exchangeRateValue(product);
    	// exchange rate is calculated and the field value is updated.
        Assertions.assertEquals(5000.0, product.getValue(),"exchange rate calculated and it should be 5000"); 
    }

    

}

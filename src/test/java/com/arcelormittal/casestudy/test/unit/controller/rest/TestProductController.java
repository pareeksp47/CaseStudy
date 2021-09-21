package com.arcelormittal.casestudy.test.unit.controller.rest;

import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;


import com.arcelormittal.casestudy.controller.product.ProductController;
import com.arcelormittal.casestudy.model.Product;
import com.arcelormittal.casestudy.model.ProductForm;
import com.arcelormittal.casestudy.service.ProductService;
import com.arcelormittal.casestudy.test.config.RequestBuilderConfig;
import com.jayway.jsonpath.JsonPath;

/**
 * Verifies that {@link ExampleEntityController} handles HTTP requests.
 * 
 * @author Pareek 
 */
public final class TestProductController {

	/**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor;
     */
    public TestProductController() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeEach
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .build();
    }
    
    /**
     * Verifies that the data read from the service is returned.
     */
    @Test
    public final void testGet_ExpectedResults() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(RequestBuilderConfig.getGetRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response model contains the expected attributes
        result.andExpect(MockMvcResultMatchers.jsonPath("$.content",
                Matchers.hasSize(3)));
    }

    /**
     * Verifies that the data read from the service is returned.
     */
    @Test
    public final void testCalulatePrice() throws Exception {
        final ResultActions result; // Request result
       
        result = mockMvc.perform(RequestBuilderConfig.getPutRequest());
        
        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());
       
     // The response model contains the expected attributes
        result.andDo(mvcResult -> {
        	String json = mvcResult.getResponse().getContentAsString();
            Double value = JsonPath.parse(json).read("$.content.value");
            Assert.isTrue(RequestBuilderConfig.getProduct().getValue().equals(value),"Value matched");
        });
    }
    
    /**
     * Verifies that the data read from the service is returned.
     */
    @Test
    public final void testExchangeRateValue() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(RequestBuilderConfig.getPatchRequest());
        
        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());
     // The response model contains the expected attributes
        result.andDo(mvcResult -> {
        	String json = mvcResult.getResponse().getContentAsString();
            Double value = JsonPath.parse(json).read("$.content.value");
            Assert.isTrue(RequestBuilderConfig.getProduct().getValue().equals(value),"Value matched");
        });
    }
    

    /**
     * Returns a controller with mocked dependencies.
     * 
     * @return a controller with mocked dependencies
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private final ProductController getController() {
    	ProductService service; // mocked service
    	service = Mockito.mock(ProductService.class);
    	
    	
    	ProductForm product = RequestBuilderConfig.getProduct();
    	
    	Collection<Product> products = new ArrayList<Product>();
    	products.add(Mockito.mock(Product.class));
    	products.add(Mockito.mock(Product.class));
    	products.add(Mockito.mock(Product.class));

    	
    	Mockito.doNothing().when(service).calculatePrice(product);
    	Mockito.when(service.getAllProduct()).thenReturn((Iterable)products);
        
    	Mockito.doNothing().when(service).exchangeRateValue(product);
        return new ProductController(service);
    }
    
    
    

    
    
    
}

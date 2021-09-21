package com.arcelormittal.casestudy.test.unit.error;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.arcelormittal.casestudy.controller.GlobalExceptionHandler;
import com.arcelormittal.casestudy.controller.product.ProductController;
import com.arcelormittal.casestudy.model.ProductForm;
import com.arcelormittal.casestudy.service.ProductService;
import com.arcelormittal.casestudy.test.config.RequestBuilderConfig;

/**
 * Unit tests for {@link GlobalExceptionHandler}, checking that it catches and
 * handles errors.
 * 
 * @author Pareek 
 */
public final class TestGlobalExceptionHandler {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor.
     */
    public TestGlobalExceptionHandler() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     * <p>
     * It expects all the responses to have the OK (200) HTTP code.
     */
    @BeforeEach
    public final void setUpMockContext() {
        final GlobalExceptionHandler exceptionHandler;

        exceptionHandler = new GlobalExceptionHandler();
        mockMvc = MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().is5xxServerError())
                .setControllerAdvice(exceptionHandler).build();
    }

    /**
     * Verifies that when an exception is thrown in the backend an error
     * response is returned.
     */
    @Test
    public final void testGetAllProduct_ErrorResponse() throws Exception {
        mockMvc.perform(RequestBuilderConfig.getGetRequest());
    }
    
    /**
     * Verifies that when an exception is thrown in the backend an error
     * response is returned.
     */
    @Test
    public final void testCalculatePrice_ErrorResponse() throws Exception {
        mockMvc.perform(RequestBuilderConfig.getPutRequest());
    }
    
    /**
     * Verifies that when an exception is thrown in the backend an error
     * response is returned.
     */
    @Test
    public final void testExchangeRateValue_ErrorResponse() throws Exception {
        mockMvc.perform(RequestBuilderConfig.getPatchRequest());
    }

    /**
     * Returns a controller with mocked dependencies.
     * 
     * @return a mocked controller
     */
    private final ProductController getController() {
        final ProductService service; // Mocked service

        service = Mockito.mock(ProductService.class);

        Mockito.when(service.getAllProduct())
                .thenThrow(RuntimeException.class);
        Mockito.doThrow(new RuntimeException()).when(service).calculatePrice(Mockito.any(ProductForm.class));
        Mockito.doThrow(new RuntimeException()).when(service).exchangeRateValue(Mockito.any(ProductForm.class));

        return new ProductController(service);
    }

    

}

package com.arcelormittal.casestudy.test.config;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.arcelormittal.casestudy.model.ProductForm;

/**
 * Contains configuration information for the controller URLs.
 * 
 * @author Pareek 
 */
public final class RequestBuilderConfig {

	/**
     * Returns a request builder prepared for reading entities.
     * 
     * @return a request builder prepared for reading entities
     */
    public final static RequestBuilder getGetRequest() {
        return MockMvcRequestBuilders.get(UrlConfig.PRODUCT_URL_REST)
                .contentType(MediaType.APPLICATION_JSON);
    }

    /**
     * Returns a request builder prepared for reading entities.
     * 
     * @return a request builder prepared for reading entities
     */
    public final static RequestBuilder getPutRequest() {
        return MockMvcRequestBuilders.put(UrlConfig.PRODUCT_URL_REST)
                .contentType(MediaType.APPLICATION_JSON).content(getProduct().toString());
    }
    
    /**
     * Returns a request builder prepared for calculating value with exchange rate.
     * 
     * @return a request builder prepared for calculating value with exchange rate. 
     */
    public final static RequestBuilder getPatchRequest() {
        return MockMvcRequestBuilders.patch(UrlConfig.PRODUCT_URL_REST)
                .contentType(MediaType.APPLICATION_JSON).content(getProduct().toString());
    }

    /**
     * Default constructor to avoid initialization.
     */
    private RequestBuilderConfig() {
        super();
    }
    
    public static ProductForm getProduct() {
    	return new ProductForm(1, "product1", 100.0, "euro"); 
    }

}

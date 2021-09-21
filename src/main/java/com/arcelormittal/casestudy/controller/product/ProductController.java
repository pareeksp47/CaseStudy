/**
 * Controller
 */

package com.arcelormittal.casestudy.controller.product;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arcelormittal.casestudy.model.Product;
import com.arcelormittal.casestudy.model.ProductForm;
import com.arcelormittal.casestudy.response.DefaultResponse;
import com.arcelormittal.casestudy.response.Response;
import com.arcelormittal.casestudy.service.ProductService;

/**
 * Rest controller for the example entities.
 * 
 * @author Pareek 
 */
@RestController
@RequestMapping("/rest/product")
public class ProductController {

    /**
     * product service.
     */
    private final ProductService productService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            example entity service
     */
    @Autowired
    public ProductController(final ProductService service) {
        super();

        productService = checkNotNull(service,
                "Received a null pointer as service");
    }

    
    /**
     *  Get all products
     *  
     *  @return Product
     */
    @GetMapping
    public Response<Iterable<? extends Product>> getAllProducts(){
    	
    	 final Iterable<? extends Product> result;
    	 
    	 result = productService.getAllProduct();
    	 return new DefaultResponse<>(result);
    }
    /**
     * Returns calculate price.
     * @param product entity to calculate the price of this product. 
     * @return a product entity with calculate price
     */
    @PutMapping
    public Response<ProductForm> calculatePrice(@RequestBody ProductForm product) {
        
        productService.calculatePrice(product);
        return new DefaultResponse<>(product);
    }

    /**
     * Updates the price with exchange rate.
     * 
     * @param product
     *            entity to update
     * @return the updated entity
     */
    @PatchMapping
    public Response<ProductForm>
            exchangeRateValue(@RequestBody ProductForm product) {
        
        	productService.exchangeRateValue(product);
        return new DefaultResponse<>(product);
    }

}

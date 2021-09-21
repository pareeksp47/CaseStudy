/**
 * 
 */
package com.arcelormittal.casestudy.service;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcelormittal.casestudy.model.Product;
import com.arcelormittal.casestudy.model.ProductForm;
import com.arcelormittal.casestudy.repository.ProductRepository;

/**
 * Implementation of the Price service.
 * 
 * @author Pareek
 *
 */
@Service
public class DefaultProductService implements ProductService{

	private static final int MAX_INT = 100;
	private static final int MIN_INT = 1;
	
	private static final double EXCHANGE_RATE = 50;
	
	/**
     * Repository for the domain entities handled by the service.
     */
    private final ProductRepository productRepository;
    
    /**
     * Constructs an entities service with the specified repository.
     *
     * @param repository
     *            the repository for the entity instances
     */
    @Autowired
    public DefaultProductService(
            final ProductRepository repository) {
        super();

        productRepository = checkNotNull(repository,
                "Received a null pointer as repository");
    }

	
	/**
	 *  calculate the price based of random value.
	 */
	@Override
	public void calculatePrice(ProductForm product) {
		product.setValue((((Math.random() * (MAX_INT - MIN_INT)) + MIN_INT)));
	}

	/**
	 *  calculate the value based on exchange rate.
	 */
	@Override
	public void exchangeRateValue(ProductForm product) {
		
		product.setValue(product.getValue() * EXCHANGE_RATE);
	}

	@Override
	public Iterable<? extends Product> getAllProduct() {
		return productRepository.findAll();
	}

}

package com.arcelormittal.casestudy.service;

import com.arcelormittal.casestudy.model.Product;
import com.arcelormittal.casestudy.model.ProductForm;

/**
 * Service for the price calculation.
 * <p>
 * This is a price service to calculate the price.
 *
 * @author Pareek 
 */
public interface ProductService {
   

	/**
     * Returns all the products.
     * 
     * @return all the products.
     */
    public Iterable<? extends Product> getAllProduct();
	
	/**
	 * calculate price
	 * @param product for which the price needs to be calculated.
	 * 
	 */
	public void calculatePrice(ProductForm product);
	
	/**
	 * Calculate the value based input value and product exchange rate.
	 *
	 * @param product : product provided by the user.
	 * 
	 */
	public void exchangeRateValue(ProductForm product);
	

}

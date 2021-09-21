/**
 */

package com.arcelormittal.casestudy.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;


/**
 * Product entity.
 *
 * @author Pareek 
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public interface Product extends Serializable {	
	
	/**
     * Returns the identifier assigned to this entity.
     * <p>
     * If no identifier has been assigned yet, then the value is expected to be
     * {@code null} or lower than zero.
     *
     * @return the entity's identifier
     */
    public Integer getId();
    
    /**
     * Sets the identifier assigned to this product.
     *
     * @param identifier
     *            the identifier for the product
     */
    public void setId(final Integer identifier);

	/**
     * Returns the value assigned to this product.
     * <p>
     * If no value has been assigned yet, then the value is expected to be
     * {@code null}
     *
     * @return the product value.
     */
    public Double getValue();
    
    /**
     *
     * @return the product name.
     */
    public String getName();
    
    /**
     * Sets the name assigned to this product.
     *
     * @param name
     *            the name for the product
     */
    public void setName(final String name);
    

    /**
     * Sets the value assigned to this product.
     *
     * @param value
     *            the value for the product
     */
    public void setValue(final Double value);

    /**
    *
    * @return the product currency.
    */
	public String getCurrency();

	/**
     * Sets the currency assigned to this product.
     *
     * @param currency
     *            the currency for the product
     */
	public void setCurrency(String currency);

}

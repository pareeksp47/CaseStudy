/**
 */

package com.arcelormittal.casestudy.model;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Default implementation of the product.
 * <p>
 * TODO: Rename to EntityForm
 *
 * @author Pareek 
 */
public class ProductForm implements Serializable {

    

    /**
	 * Serialization ID.
	 */
	private static final long serialVersionUID = 4993496481908613531L;

	/**
     * Product's ID.
     */
    private Integer           id               = -1;

    /**
     * Name of the prodcut.
     * 
     */
    private String            name             = "";
    
    /**
     * Currency of the product.
     *
     */
    private String            currency             = "";
    
    /**
     * Value of the product.
     *
     */
    private Double            value             = 0.0;

    /**
     * Constructs an example entity.
     */
    public ProductForm() {
        super();
    }

    /**
     * Constructs an example entity.
     * @param id of the product
     * @param name of the product
     * @param value of the product
     * @param currency of the product
     */
    public ProductForm(Integer id, String name, Double value, String currency) {
        super();
        this.id = id;
        this.name = name;
        this.value = value;
        this.currency = currency;
    }
    
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final ProductForm other = (ProductForm) obj;
        return Objects.equals(id, other.id);
    }

    /**
     * Returns the identifier assigned to this entity.
     * <p>
     * If no identifier has been assigned yet, then the value will be lower than
     * zero.
     *
     * @return the entity's identifier
     */
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Double getValue() {
		
		return value;
	}
    
	public String getCurrency() {
		return currency;
	}

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public void setId(final Integer id) {
        this.id = checkNotNull(id, "Received a null pointer as identifier");
    }

    public void setName(final String name) {
        this.name = checkNotNull(name, "Received a null pointer as name");
    }
    
	public void setValue(Double value) {
		 this.value = checkNotNull(value, "Received a null pointer as value");
		 if(this.value < 0.0 ) throw new IllegalArgumentException("Recieved a negative value for the product"); 
	}
	
	public void setCurrency(String currency) {
		this.currency = checkNotNull(currency, "Received a null pointer as currency");
		
	}

    public final String toString() {
        try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			 throw new RuntimeException(e);
		}
    }

}

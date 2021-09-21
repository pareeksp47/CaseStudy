
package com.arcelormittal.casestudy.model.persistence;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.arcelormittal.casestudy.model.Product;
import com.google.common.base.MoreObjects;

/**
 * Persistent entity for the product.
 * <p>
 * This makes use of JPA annotations for the persistence configuration.
 *
 * @author Pareek 
 */
@Entity(name = "Product")
@Table(name = "product")

public class PersistentProduct implements Product {
	

	/**
     * Serialization ID.
     */
    @Transient
    private static final long serialVersionUID = -5848948418982154440L;

    /**
     * Product's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer           id               = -1;

    /**
     * Name of the entity.
     * 
     */
    @Column(name = "name", nullable = false)
    private String            name             = "";
    
    /**
     * Currency of the product.
     *
     */
    @Column(name = "currency", nullable = false)
    private String            currency             = "";
    
    /**
     * Value of the entity.
     * 
     */
    @Column(name = "value", nullable = false)
    private Double            value             = 0.0;

    /**
     * Constructs an example entity.
     */
    public PersistentProduct() {
        super();
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

        final PersistentProduct other = (PersistentProduct) obj;
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
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
	public Double getValue() {
		
		return value;
	}
    
    @Override
	public String getCurrency() {
		return currency;
	}

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void setId(final Integer value) {
        id = checkNotNull(value, "Received a null pointer as identifier");
    }

    @Override
    public void setName(final String value) {
        name = checkNotNull(value, "Received a null pointer as name");
    }
    
    @Override
	public void setValue(Double value) {
		 value = checkNotNull(value, "Received a null pointer as value");
		
	}

	@Override
	public void setCurrency(String currency) {
		currency = checkNotNull(currency, "Received a null pointer as value");
		
	}

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("name", name).add("currency", currency).add("value", value)
                .toString();
    }

	

}

package com.arcelormittal.casestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arcelormittal.casestudy.model.persistence.PersistentProduct;

/**
 * Spring-JPA repository for {@link PersistentProduct}.
 * <p>
 * This is a simple repository just to allow the endpoints querying the entities
 * they are asked for.
 *
 * @author Pareek 
 */
public interface ProductRepository
        extends JpaRepository<PersistentProduct, Integer> {

    /**
     * Returns all products.
     * 
     * 
     * @return all products
     */
    public List<PersistentProduct> findAll(); 

}

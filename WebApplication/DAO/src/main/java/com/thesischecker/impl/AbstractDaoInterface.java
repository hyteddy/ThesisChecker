package com.thesischecker.impl;

import java.io.Serializable;
import java.util.List;

/**
 * Abstract DAO interface to implements by all DAO class
 * @author Tomasz Morek
 */
public interface AbstractDaoInterface<E, I extends Serializable > {

    /**
     * Save or update object from DB
     * @param e
     */
    void saveOrUpdate(E e);

    /**
     * Delete object from DB
     * @param e
     */
    void delete(E e);

    /**
     * Find object on DB by primary key
     * @param id object ID
     * @return Object
     */
    E findById(I id);

    /**
     * Find all entity records
     * @return
     */
    List<E> findAll();
}

package com.thesischecker.dao.interfaces;

import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Abstract DAO interface to implements by all DAO class
 * @author Tomasz Morek
 */
public interface IAbstractDao<E> {

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
    E findById(Long id);

    /**
     * Find by HQL query
     */
    List<E> findByQuery(String query);

    /**
     * Find object by criteria
     * @param criterion criterion
     * @return
     */
    List<E> findByCriteria(Criterion criterion);
}

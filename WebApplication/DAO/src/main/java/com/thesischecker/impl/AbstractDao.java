package com.thesischecker.impl;

import com.thesischecker.interfaces.AbstractDaoInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Implementation AbstractDao
 * @author Tomasz Morek
 */
public class AbstractDao<E, I extends Serializable> implements
        AbstractDaoInterface {

    /**
     * Dto class
     */
    private Class<E> dtoClass;

    /**
     * Session factory
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Constructor
     * @param dtoClass
     */
    protected AbstractDao(Class<E> dtoClass) {
        this.dtoClass = dtoClass;
    }

    /**
     * Get current session from SessionFactory
     * @return Session
     */
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(Object o) {
        this.getSession().saveOrUpdate(o);
    }

    @Override
    public void delete(Object o) {
        this.getSession().delete(o);
    }

    @Override
    public Object findById(Long id) {
        return this.getSession().get(this.dtoClass, id);
    }

    @Override
    public List find(Criterion criterion) {
        return null;
    }
}

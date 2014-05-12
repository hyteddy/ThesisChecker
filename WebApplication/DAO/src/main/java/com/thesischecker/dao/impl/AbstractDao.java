package com.thesischecker.dao.impl;

import com.thesischecker.dao.interfaces.IAbstractDao;
import com.thesischecker.dto.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

/**
 * Implementation AbstractDao
 * @author Tomasz Morek
 */
public abstract class AbstractDao<E, I extends Serializable> implements
        IAbstractDao<E, I> {

    /**
     * Dto class
     */
    private Class<E> dtoClass;

    /**
     * Session factory
     */
    private SessionFactory sessionFactory;

    /**
     * Constructor
     * @param dtoClass
     */
    protected AbstractDao(Class<E> dtoClass) {
        this.dtoClass = dtoClass;
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * Get current session from SessionFactory
     * @return Session
     */
    protected Session getSession() {
        return this.sessionFactory.openSession();
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
    public E findById(Long id) {
        return (E) this.getSession().get(this.dtoClass, id);
    }

    @Override
    public List find(Criterion criterion) {
        Criteria criteria = this.getSession().createCriteria(this.dtoClass);
        criteria.add(criterion);
        return criteria.list();
    }
}

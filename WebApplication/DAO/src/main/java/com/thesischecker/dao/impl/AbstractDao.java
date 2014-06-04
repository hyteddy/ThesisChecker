package com.thesischecker.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.thesischecker.dto.HibernateUtil;

/**
 * Implementation AbstractDao
 * 
 * @author Tomasz Morek
 */
public abstract class AbstractDao {

    /**
     * Session factory
     */
    private SessionFactory sessionFactory;

    /**
     * Constructor
     */
    protected AbstractDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * Get current session from SessionFactory
     * 
     * @return Session
     */
    protected Session getSession() {
        return this.sessionFactory.openSession();
    }
}

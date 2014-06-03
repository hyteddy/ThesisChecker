package com.thesischecker.dao.impl;

import com.thesischecker.dto.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Implementation AbstractDao
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
     * @return Session
     */
    protected Session getSession() {
        return this.sessionFactory.openSession();
    }
}

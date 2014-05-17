package com.thesischecker.dto;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by awilczyn on 12.04.2014.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = createSessionFactory();

    private static SessionFactory createSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void closeSession(){
        sessionFactory.close();
    }
}

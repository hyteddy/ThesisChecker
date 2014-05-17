package com.thesischecker.dto;

import java.io.InputStream;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by awilczyn on 12.04.2014.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = createSessionFactory();

    private static SessionFactory createSessionFactory() {
        try {
            InputStream in = HibernateUtil.class
                    .getResourceAsStream("/hibernate.cfg.xml");
            Configuration configuration = new Configuration()
                    .addInputStream(in).configure();
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void closeSession() {
        sessionFactory.close();
    }
}

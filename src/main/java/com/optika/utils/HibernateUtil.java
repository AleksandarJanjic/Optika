package com.optika.utils;

import com.optika.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.setProperty("connection.url", System.getenv("SPRING_DATASOURCE_URL"));
            configuration.addAnnotatedClass(Buyer.class);
            configuration.addAnnotatedClass(Contact.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(Diopter.class);
            configuration.addAnnotatedClass(Angle.class);
            configuration.addAnnotatedClass(Type.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    private static Session session;

    public static Session getSession() {
        if(session == null || (!session.isOpen())) {
            session = getSessionFactory().openSession();
            return session;
        } else {
            return session;
        }
    }

    public static void closeSession(Session session) {
        session.close();
    }
}

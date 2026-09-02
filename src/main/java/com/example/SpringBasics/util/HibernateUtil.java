package com.example.SpringBasics.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Utility class that bootstraps a Hibernate SessionFactory from hibernate.cfg.xml.
 * This is the plain-Hibernate approach — no Spring Data JPA / EntityManagerFactory.
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Load DB/dialect settings from src/main/resources/hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            // Explicitly register entity class (belt-and-suspenders alongside <mapping class> in XML)
            configuration.addAnnotatedClass(com.example.SpringBasics.model.Student.class);

            ServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception ex) {
            throw new ExceptionInInitializerError("Failed to create SessionFactory: " + ex.getMessage());
        }
    }

    /**
     * Returns the shared SessionFactory instance.
     */
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    /**
     * Closes the SessionFactory on application shutdown.
     */
    public static void shutdown() {
        if (SESSION_FACTORY != null) {
            SESSION_FACTORY.close();
        }
    }
}

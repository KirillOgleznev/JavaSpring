package manager;

import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class DAO {
    static ThreadLocal<Session> session = new ThreadLocal<>();
    static SessionFactory sessionFactory = getSessionFactory();
    static Transaction transaction = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Cinema.class);
                configuration.addAnnotatedClass(Hall.class);
                configuration.addAnnotatedClass(HallInfo.class);
                configuration.addAnnotatedClass(Seat.class);
                configuration.addAnnotatedClass(models.Session.class);
                configuration.addAnnotatedClass(Ticket.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());


        }
        return sessionFactory;
    }

    public static Session getSession() {
        if (session.get() == null || !session.get().isOpen())
            session.set(sessionFactory.openSession());
        return session.get();
    }

    public static void begin() {
        try {
            transaction = getSession().beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commit() {
        if (transaction != null && transaction.isActive()) {
            transaction.commit();
        }
    }

    public static void close() {
        if (transaction != null && transaction.isActive()) {
            getSession().clear();
            getSession().close();
        }
    }

    public static void transaction() {
        begin();
        commit();
        close();
    }
}

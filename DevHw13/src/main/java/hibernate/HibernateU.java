package hibernate;

import entity.Client;
import entity.Planet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateU implements AutoCloseable{
    private static final HibernateU INSTANCE;
    private final SessionFactory factory;

    private HibernateU(){
        factory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    static {
        INSTANCE = new HibernateU();
    }

    public static HibernateU getInstance(){
        return INSTANCE;
    }

    public SessionFactory getFactory(){
        return factory;
    }

    @Override
    public void close(){
        factory.close();
    }
}

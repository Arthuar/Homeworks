package crud;

import entity.Ticket;
import hibernate.HibernateU;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketCr {
    private final SessionFactory factory = HibernateU.getInstance().getFactory();
    private final static String NOT_VALID_ENTITY = "One or more fields are 'null', created failed";
    private boolean checkParameterValidity(Ticket entity){
        return entity.getClient() != null
                && entity.getFromPlanet() != null
                && entity.getToPlanet() != null;
    }

    public void save(Ticket entity) {
        if (checkParameterValidity(entity)){
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                session.persist(entity);
                tx.commit();
            }
        }else {
            System.out.println(NOT_VALID_ENTITY);
        }

    }


    public Ticket findById(long id) {
        try(Session session = factory.openSession()){
            return session.find(Ticket.class, id);
        }
    }


    public void update(Ticket entity) {
        if(checkParameterValidity(entity)){
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                session.merge(entity);
                tx.commit();
            }
        } else {
            System.out.println(NOT_VALID_ENTITY);
        }

    }


    public void delete(Ticket entity) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();
        }
    }
}

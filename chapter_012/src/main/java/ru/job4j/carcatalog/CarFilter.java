package ru.job4j.carcatalog;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Class for creating car filter.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 01.12.2017.
 */
public class CarFilter {
    /**
     * Factory.
     */
    private final SessionFactory factory;

    /**
     * Constructor.
     */
    public CarFilter() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Interface for realize commander pattern.
     * @param <T>
     */
    public interface Command<T> {
        /**
         * Method for action.
         * @param session - session.
         * @return T.
         */
        T process(Session session);
    }

    /**
     * Method for do transaction.
     * @param command - command.
     * @param <T> - param.
     * @return T.
     */
    private <T> T transaction(final Command<T> command) {
        final Session session = factory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            return command.process(session);
        } finally {
            transaction.commit();
            session.close();
        }
    }

    /**
     * Return all Cars.
     * @return List.
     */
    public List<Car> getAllCars() {
        return transaction((Session session) -> session.createQuery("from Car ").list());
    }

    /**
     * Return car.
     * @param id - id.
     * @return Car.
     */
    public Car getCarById(int id) {
       return transaction(session -> session.get(Car.class, id));
    }

    /**
     * Find cars by body.
     * @param body - car body.
     * @return List.
     */
    public List<Car> getCarsByBody(String body) {
        return transaction(new Command<List<Car>>() {
            @Override
            public List<Car> process(Session session) {

                final Query query = session.createQuery("from Car as c "
                        + "inner join fetch c.body "
                        + "inner join fetch c.engine  "
                        + "inner join fetch c.transmission "
                        + "inner join fetch c.producer where c.body.type=:body");
                query.setString("body", body);

                return query.list();
            }
        });
    }

    /**
     * Find car by producer.
     * @param producer - car producer.
     * @return List.
     */
    public List<Car> findCarsByProducer(String producer) {
        return transaction(new Command<List<Car>>() {
            @Override
            public List<Car> process(Session session) {

                final Query query = session.createQuery("from Car as c "
                        + "inner join fetch c.body "
                        + "inner join fetch c.engine  "
                        + "inner join fetch c.transmission "
                        + "inner join fetch c.producer where c.producer.mark=:producer"
                );
                query.setString("producer", producer);

                return query.list();
            }
        });
    }

    /**
     * Find car by params.
     * @param body - car body.
     * @param producer - car producer.
     * @param engineVolume - car engine volume.
     * @param engineFuel - car fuel.
     * @param transmission - car transmission.
     * @return List.
     */
    public List<Car> getCarsByParam(String body, String producer, String engineVolume, String engineFuel, String transmission) {
        return transaction(new Command<List<Car>>() {
            @Override
            public List<Car> process(Session session) {

                final Query query = session.createQuery("from Car as c "
                        + "inner join fetch c.body "
                        + "inner join fetch c.engine  "
                        + "inner join fetch c.transmission "
                        + "inner join fetch c.producer "
                        + "where c.producer.mark=:producer "
                        + "and c.body.type=:body "
                        + "and c.engine.volume=:engineVolume "
                        + "and c.engine.fuel.type =:engineFuel "
                        + "and c.transmission.type=:transmission"
                );
                query.setString("body", body);
                query.setString("producer", producer);
                query.setString("engineVolume", engineVolume);
                query.setString("engineFuel", engineFuel);
                query.setString("transmission", transmission);

                return query.list();
            }
        });
    }
}

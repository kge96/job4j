package ru.job4j.carcatalog;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.carcatalog.models.Car;

import java.util.List;


/**
 * Class for creating carcatalog filter.
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
     * Return carcatalog.
     * @param id - id.
     * @return Car.
     */
    public Car getCarById(int id) {
       return transaction(session -> session.get(Car.class, id));
    }

    /**
     * Find cars by body.
     * @param body - carcatalog body.
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
     * Find carcatalog by producer.
     * @param producer - carcatalog producer.
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
     * Find carcatalog by params.
     * @param body - carcatalog body.
     * @param producer - carcatalog producer.
     * @param engineVolume - carcatalog engine volume.
     * @param engineFuel - carcatalog fuel.
     * @param transmission - carcatalog transmission.
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

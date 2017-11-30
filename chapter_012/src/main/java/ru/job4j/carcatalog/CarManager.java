package ru.job4j.carcatalog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.carcatalog.modules.Producer;
import ru.job4j.carcatalog.modules.Body;
import ru.job4j.carcatalog.modules.Engine;
import ru.job4j.carcatalog.modules.Fuel;
import ru.job4j.carcatalog.modules.Transmission;


/**
 * Class creating car.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.11.2017.
 */
public class CarManager {
    /**
     * Session factory.
     */
    private  SessionFactory factory = new Configuration().configure().buildSessionFactory();
    /**
     * Session.
     */
    private  Session session = factory.openSession();

    /**
     * Add fuel to database.
     * @param fuel - fuel.
     */
    public void addFuel(Fuel fuel) {
        session.beginTransaction();
        session.saveOrUpdate(fuel);
        session.getTransaction().commit();
    }

    /**
     * Add or update transmission to db.
     * @param transmission - transmission.
     */
     public void addTransmission(Transmission transmission) {
         session.beginTransaction();
         session.saveOrUpdate(transmission);
         session.getTransaction().commit();
     }

    /**
     * Add or update body to db.
     * @param body - body.
     */
     public void addBody(Body body) {
         session.beginTransaction();
         session.saveOrUpdate(body);
         session.getTransaction().commit();
     }

    /**
     * Add or update engine to db.
     * @param engine - engine.
     */
     public void addEngine(Engine engine) {
         session.beginTransaction();
         session.saveOrUpdate(engine);
         session.getTransaction().commit();
     }

    /**
     * Add or update producer to db.
     * @param producer - producer.
     */
     public void addProducer(Producer producer) {
         session.beginTransaction();
         session.saveOrUpdate(producer);
         session.getTransaction().commit();
     }

    /**
     * Add or update car to db.
     * @param car car.
     */
     public void addCar(Car car) {
         session.beginTransaction();
         session.saveOrUpdate(car);
         session.getTransaction().commit();
     }

    /**
     * Return car from db.
     * @param id - id.
     * @return Car.
     */
     public Car getCar(int id) {
         session.beginTransaction();
         Car car = session.get(Car.class, id);
         session.getTransaction().commit();
         return car;
     }

    /**
     * Return session.
     * @return Session.
     */
     public Session getSession() {
         return this.session;
     }

    /**
     * Close session.
     */
    public void closeSession() {
        session.close();
        factory.close();
    }
}

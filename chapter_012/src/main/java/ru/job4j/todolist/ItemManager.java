package ru.job4j.todolist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Class for creating ItemManager.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 29.11.2017.
 */
public class ItemManager {
    /**
     * SessionFactory.
     */
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    /**
     * Session.
     */
    private Session session = factory.openSession();
    /**
     * Interface for realize commander pattern.
     * @param <T>
     */
    public interface Command<T> {
        /**
         * Method for action.
         * @param session - session.
         * @param object - object.
         */
        void process(Session session, T object);
    }
    /**
     * Method for do transaction.
     * @param command - command.
     * @param obj - object.
     * @param <T> - param.
     */
    private <T> void transaction(final Command<T> command, T obj) {
        try {
            beginTransaction();
            command.process(session, obj);
        } catch (Exception e) {
            session.evict(obj);
        } finally {
            commitTransaction();
        }
    }

    /**
     * Add Item to DB.
     * @param item - item.
     */
    public void addItem(Item item) {
        transaction(new Command<Item>() {
            @Override
            public void process(Session session, Item item) {
                session.save(item);
            }
        }, item);
    }

    /**
     * Add or update item.
     * @param item item.
     */
    public void addOrUpdate(Item item) {
        transaction(new Command<Item>() {
            @Override
            public void process(Session session, Item item) {
                session.saveOrUpdate(item);
            }
        }, item);

    }

    /**
     * Delete item.
     * @param item item.
     */
    public void deleteItem(Item item) {
        transaction(new Command<Item>() {
            @Override
            public void process(Session session, Item item) {
                session.delete(item);
            }
        }, item);
    }

    /**
     * Return item.
     * @param id - item id.
     * @return Item.
     */
    public Item getItem(int id) {
        beginTransaction();
       Item result = null;
        List<Item> items = session.createQuery("FROM Item").list();
       for (Item item : items) {
           if (item.getId() == id) {
               result = item;
               break;
           }
       }
        commitTransaction();
        return result;
    }

    /**
     * Close session.
     */
    public void closeSession() {
        this.session.close();
        this.factory.close();
    }

    /**
     * Start transaction.
     */
    private void beginTransaction() {
        this.session.beginTransaction();
    }

    /**
     * Commit transaction.
     */
    private void commitTransaction() {
        this.session.getTransaction().commit();
    }
}

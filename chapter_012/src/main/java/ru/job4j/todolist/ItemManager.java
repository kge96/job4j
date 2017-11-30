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
     * Add Item to DB.
     * @param item - item.
     */
    public void addItem(Item item) {
        beginTransaction();
        this.session.save(item);
        commitTransaction();
    }

    /**
     * Add or update item.
     * @param item item.
     */
    public void addOrUpdate(Item item) {
        beginTransaction();
        this.session.saveOrUpdate(item);
        commitTransaction();
    }

    /**
     * Delete item.
     * @param item item.
     */
    public void deleteItem(Item item) {
        beginTransaction();
        this.session.delete(item);
        commitTransaction();
    }

    /**
     * Delete item.
     * @param query - item.
     */
    public void deleteItem(String query) {
        beginTransaction();
        this.session.delete(query);
        commitTransaction();
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

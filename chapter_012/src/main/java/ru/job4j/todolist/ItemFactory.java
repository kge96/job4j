package ru.job4j.todolist;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 29.11.2017.
 */
public class ItemFactory {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setDesc("description");
        item.setDone(false);
        session.saveOrUpdate(item);
        System.out.println(session.createQuery("from Item").list());
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}

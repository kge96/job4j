package ru.job4j.crudservlet;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Class for testing crud servlet task.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 31.10.2017.
 */
public class DBConnectorTest {
    /**
     * Database connection test.
     */
    @Test
    public void testingConnectionToDb() {
        UsersDBConnector connector = new UsersDBConnector();
        User user1 = new User("Ivan", "Ivan1", "Ivan@rambler.ru");
        User user2 = new User("Ivan", "Ivan2", "Ivan@mail.ru");
        User user3 = new User("Ivan", "Ivan3", "Ivan@yandex.ru");
        User user4 = new User("Ivan", "Ivan4", "Ivan@gmail.ru");
        connector.add(user1);
        connector.add(user2);
        connector.add(user3);
        connector.add(user4);
        User result = connector.getUser("Ivan3");
        assertThat(result.getEmail(), is("Ivan@yandex.ru"));
    }
}

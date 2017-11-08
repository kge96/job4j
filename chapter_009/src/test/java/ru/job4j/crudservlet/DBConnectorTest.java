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
        UserStorage connector = UserStorage.getInstance();
        User user1 = new User("Ivan", "Ivan1", "1234", "Ivan@rambler.ru", "user");
        User user2 = new User("Ivan", "Ivan2", "1234", "Ivan@mail.ru", "user");
        User user3 = new User("Ivan", "Ivan3", "1234", "Ivan@yandex.ru", "user");
        User user4 = new User("Ivan", "Ivan4", "1234", "Ivan@gmail.ru", "user");
        connector.add(user1);
        connector.add(user2);
        connector.add(user3);
        connector.add(user4);
        User result = connector.getUser("Ivan3");
        assertThat(result.getEmail(), is("Ivan@yandex.ru"));
    }
}

package ru.job4j.crudservlet;

import org.junit.Test;

import java.util.ArrayList;

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
        User user1 = new User("Ivan", "Ivan1", "1234", "Ivan@rambler.ru", "Russia", "Pickulovo", "user");
        User user2 = new User("Ivan", "Ivan2", "1234", "Ivan@mail.ru", "Russia", "Pickulovo", "user");
        User user3 = new User("Ivan", "Ivan3", "1234", "Ivan@yandex.ru", "Russia", "Pickulovo", "user");
        User user4 = new User("Ivan", "Ivan4", "1234", "Ivan@gmail.ru", "Russia", "Pickulovo", "user");
        connector.add(user1);
        connector.add(user2);
        connector.add(user3);
        connector.add(user4);
        User result = connector.getUser("Ivan3");
        assertThat(result.getEmail(), is("Ivan@yandex.ru"));
    }

    /**
     * Test.
     */
    @Test
    public void testGettingCities() {
        UserStorage storage = UserStorage.getInstance();
        ArrayList<String> cities = storage.getAllCities("Russia");
        for (String city : cities) {
            System.out.println(city);
        }
    }

    /**
     * Test.
     */
    @Test
    public void testGettingCountries() {
        UserStorage storage = UserStorage.getInstance();
        ArrayList<String> countries = storage.getAllCountries();
        for (String city : countries) {
            System.out.println(city);
        }
    }
}

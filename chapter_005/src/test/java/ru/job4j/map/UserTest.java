package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for testing user.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.10.2017.
 */
public class UserTest {
    /**
     * Testing addition same objects into map.
     */
    @Test
    public void whenAddUsersWithoutHashCodeAndEqualsShouldAddBoth() {
        Map<User, Object> hmap = new HashMap<>();
        User user1 = new User("Ivan", 1, new GregorianCalendar(1989, 3, 12));
        User user2 = new User("Ivan", 1, new GregorianCalendar(1989, 3, 12));

        hmap.put(user1, new Object());
        hmap.put(user2, new Object());

        for (Map.Entry<User, Object> user : hmap.entrySet()) {
            System.out.println(user.getKey().hashCode());
        }
    }

}

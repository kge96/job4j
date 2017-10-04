package ru.job4j.store;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing Store.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.10.2017.
 */
public class StoreTest {
    /**
     * Testing add element.
     */
    @Test
    public void whenAddNewItemInUserStorageThenItAdded() {
        AbstractStore<User> userStore = new UserStore();
        User user = new User("1", "Ivan");
        User user2 = new User("2", "Oleg");

        userStore.add(user);
        User result = (User) userStore.add(user2);
        assertThat(result, is(user2));
    }
    /**
     * Testing update element.
     */
    @Test
    public void whenUpdateItemInUserStorageThenItUpdated() {
        AbstractStore<User> userStore = new UserStore();
        User user = new User("1", "Ivan");
        User user2 = new User("1", "Sergey");
        User user3 = new User("2", "Sergey2");
        userStore.add(user);
        userStore.add(user2);
        userStore.add(user3);

        Base result = userStore.update(user2);
        assertThat(result, is(user));
    }
    /**
     * Testing remove element.
     */
    @Test
    public void whenDeleteItemInUserStorageThenItDeleted() {
        AbstractStore<User> userStore = new UserStore();
        User user = new User("1", "Ivan");
        User user2 = new User("2", "Sergey");
        User user3 = new User("3", "Vasiliy");
        userStore.add(user);
        userStore.add(user2);
        userStore.add(user3);

        boolean result = userStore.delete("2");

        User element = (User) userStore.getStorage().get(1);
        String name = element.getName();

        assertThat(name, is("Vasiliy"));
    }
}

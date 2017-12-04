package ru.job4j.ioc.storages;

import org.springframework.stereotype.Component;
import ru.job4j.ioc.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for creating memory storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.12.2017.
 */

@Component
public class MemoryStorage implements Storage {
    /**
     * Storage.
     */
    private final Map<Long, User> memoryStor = new HashMap<>();

    @Override
    public void add(User user) {
        memoryStor.put(user.getPassport(), user);
        System.out.println(String.format("Was added %s", user.getName()));
    }

    /**
     * Return user from storage.
     * @param passport - passport.
     * @return User.
     */
    public User getUser(long passport) {
        return memoryStor.get(passport);
    }

    /**
     * Remove user from storage.
     * @param passport
     * @return
     */
    public User removeUser(long passport) {
        User user = getUser(passport);
        memoryStor.remove(passport);
        return user;
    }

}

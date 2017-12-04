package ru.job4j.storages;

import org.springframework.stereotype.Component;
import ru.job4j.User;

/**
 * Class for creating memory storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.12.2017.
 */

@Component
public class MemoryStorage implements Storage {
    @Override
    public void add(User user) {
        System.out.println(String.format("Was added %s", user.getName()));

    }
}

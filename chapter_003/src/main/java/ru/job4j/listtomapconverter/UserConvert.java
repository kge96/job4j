package ru.job4j.listtomapconverter;

import java.util.HashMap;
import java.util.List;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.09.2017.
 */
public class UserConvert {
    /**
     * Convert List to HashMap.
     * @param list - origin list.
     * @return HashMap - result.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}

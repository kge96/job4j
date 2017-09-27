package ru.job4j.listtomapconverter;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class for sorting.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 27.09.2017.
 */
public class SortUser {
    /**
     * Get collection with sorting by age.
     * @param list - origin user list.
     * @return Set.
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        for (User user : list) {
            result.add(user);
        }
        return result;
    }
}

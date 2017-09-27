package ru.job4j.listtomapconverter;

import java.util.*;

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

    /**
     * Sorted list by name.
     * @param list - origin list.
     * @return List - sorted list.
     */
    public List<User>sortNameLength(List<User> list) {
       list.sort(new Comparator<User>() {
           @Override
           public int compare(User o1, User o2) {
               return o2.getName().compareTo(o1.getName());
           }
       });
        return list;
    }

    /**
     * Sorted list by name then by age.
     * @param list - list.
     * @return List.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}

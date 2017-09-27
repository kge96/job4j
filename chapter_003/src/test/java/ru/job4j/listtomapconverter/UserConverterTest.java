package ru.job4j.listtomapconverter;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;



import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class for testing user converter.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.09.2017.
 */
public class UserConverterTest {
    /**
     * Testing convert LinkedList to HashMap.
     */
    @Test
    public void whenLinkedListUserConvertThanUserMap() {
        List<User> userList = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            String name = String.format("Name %s", i);
            String city = String.format("City %s", i);
            userList.add(new User(i, i + 20, name, city));
        }
        UserConvert convert = new UserConvert();
        Map<Integer, User> result = convert.process(userList);
        Map<Integer, User> expected = new HashMap<Integer, User>();

        for (int i = 1; i < 6; i++) {
            String name = String.format("Name %s", i);
            String city = String.format("City %s", i);
            expected.put(i, new User(i, i + 20, name, city));
        }
        assertThat(result, is(expected));
    }
    /**
     * Testing convert ArrayList to HashMap.
     */
    @Test
    public void whenArrayListUserConvertThanUserMap() {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            String name = String.format("Name %s", i);
            String city = String.format("City %s", i);
            userList.add(new User(i, i + 20, name, city));
        }
        UserConvert convert = new UserConvert();
        Map<Integer, User> result = convert.process(userList);
        Map<Integer, User> expected = new HashMap<Integer, User>();

        for (int i = 1; i < 6; i++) {
            String name = String.format("Name %s", i);
            String city = String.format("City %s", i);
            expected.put(i, new User(i, i + 20, name, city));
        }
        assertThat(result, is(expected));
    }
    /**
     * Testing convert ArrayList to HashMap when there are duplicates in ArrayList.
     */
    @Test
    public void whenArrayListUserConvertThanUserMap2() {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            String name = String.format("Name %s", i);
            String city = String.format("City %s", i);
            userList.add(new User(i, i + 20, name, city));
        }
        for (int i = 1; i < 4; i++) {
            String name = String.format("Name %s", i + 2);
            String city = String.format("City %s", i + 2);
            userList.add(new User(i, i + 20, name, city));
        }
        UserConvert convert = new UserConvert();
        Map<Integer, User> result = convert.process(userList);
        Map<Integer, User> expected = new HashMap<Integer, User>();

        for (int i = 1; i < 4; i++) {
            String name = String.format("Name %s", i + 2);
            String city = String.format("City %s", i + 2);
            expected.put(i, new User(i, i + 20, name, city));
        }
        assertThat(result, is(expected));
    }

    /**
     * Testing user sort.
     */
    @Test
    public void whenUserListToSortThenSortedTreeSet() {
        List<User> userList = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            String name = String.format("Name %s", i);
            String city = String.format("City %s", i);
            userList.add(new User(i, i + 20, name, city));
        }
        userList.add(new User(0, 15, "Vasya", "Bobruisk"));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(userList);

        assertThat(result.iterator().next().getAge(), is(15));
    }
    /**
     * Testing user sort by name.
     */
    @Test
    public void whenSortListByNameLengthThenSortedListByName() {
        List<User> userList = new LinkedList<>();
        userList.add(new User(0, 15, "Kit", "Bobruisk"));
        userList.add(new User(1, 45, "Gorg", "Bobruisk"));
        userList.add(new User(2, 38, "Alexander", "Bobruisk"));
        userList.add(new User(3, 22, "Boris", "Bobruisk"));
        SortUser sortUser = new SortUser();

        List<User> result = sortUser.sortNameLength(userList);
        assertThat(result.get(0).getName(), is("Kit"));
    }
    /**
     * Testing user sort by name than age.
     */
    @Test
    public void whenSortListByNameLengthAndAgeThenSortedListByName() {
        List<User> userList = new LinkedList<>();
        userList.add(new User(1, 45, "Ivan", "Bobruisk"));
        userList.add(new User(2, 38, "Sergey", "Bobruisk"));
        userList.add(new User(0, 15, "Ivan", "Bobruisk"));
        userList.add(new User(3, 22, "Sergey", "Bobruisk"));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(userList);
        assertThat(result.get(0).getId(), is(0));
    }
}


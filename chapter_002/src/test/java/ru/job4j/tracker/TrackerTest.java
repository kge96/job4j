package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing Tracker.
 * @author gkuznetsov.
 * @since 19.09.17.
 * @version 0.1.
 */
public class TrackerTest {
    /**
     * Testing addition new elements in Tracker.
     */
    @Test
    public void whenAddNewItemThenHasSameItem() {
       Item item0 = new Item("test0", "testMethods1");
       Item item1 = new Item("test1", "testMethods2");
       Item item2 = new Item("test2", "testMethods1");
       Item item3 = new Item("test3", "testMethods2");
        Tracker tracker = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findAll().get(1), is(item1));
    }

    /**
     * Testing update element in Tracker.
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Item item0 = new Item("test0", "testMethods1");
        Item item1 = new Item("test1", "testMethods2");
        Item item2 = new Item("test2", "testMethods1");
        Tracker tracker = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        item1.setId("task777");
        tracker.update(item1);
        assertThat(tracker.findAll().get(1).getId(), is(item1.getId()));
    }

    /**
     * Testing delete elemetn from Tracker.
     */
    @Test
    public void whenDeleteItemThenLeftDisplacementItems() {
        Item item0 = new Item("test0", "testMethods1");
        Item item1 = new Item("test1", "testMethods2");
        Item item2 = new Item("test2", "testMethods1");
        Item item3 = new Item("test3", "testMethods2");
        Tracker tracker = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2);
        assertThat(tracker.findAll().get(2).getName() + "", is("test3"));
    }

    /**
     * Testing searching elements by name.
     */
    @Test
    public void whenSearchElementByNameThenReturnArrayElementsWithNames() {
        Item item0 = new Item("test0", "testMethods1");
        Item item1 = new Item("test1", "testMethods2");
        Item item2 = new Item("test0", "testMethods1");
        Item item3 = new Item("test3", "testMethods2");
        Item item5 = new Item("test0", "testMethods2");
        Tracker tracker = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item5);
        int result = tracker.findByName("test0").size();
        assertThat(result, is(3));
    }

    /**
     * Testing getting all elements from Track.
     */
    @Test
    public void whenAllElemensThenReturnArraysWithoutNull() {
        Item item0 = new Item("test0", "testMethods1");
        Item item1 = new Item("test1", "testMethods2");
        Item item2 = new Item("test2", "testMethods1");
        Item item3 = new Item("test3", "testMethods2");
        Item item4 = new Item("test4", "testMethods3");
        Item item5 = new Item("test5", "testMethods2");
        Tracker tracker = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.delete(item1);
        tracker.delete(item3);
        tracker.delete(item4);
        assertThat(tracker.findAll().size(), is(3));
    }

    /**
     * Testing getting elemtnt by ID from Track.
     */
    @Test
    public void whenSearchElementByIDThenReturnElementWithId() {
        Item item0 = new Item("test0", "testMethods1");
        Item item1 = new Item("test1", "testMethods2");
        Item item2 = new Item("test2", "testMethods1");
        Item item3 = new Item("test3", "testMethods2");
        Item item4 = new Item("test4", "testMethods3");
        Item item5 = new Item("test5", "testMethods2");
        Tracker tracker = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        String result = item3.getId();
        assertThat(tracker.findById(result), is(item3));
    }
}

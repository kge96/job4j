package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

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
       Item item0 = new Item("Tes-1", "Description-1", new String[]{"comment - 1", "comment - 1"});
       Item item1 = new Item("Tes-2", "Description-2", new String[]{"comment - 2", "comment - 2"});
       Item item2 = new Item("Tes-3", "Description-3", new String[]{"comment - 3", "comment - 3"});
       Item item3 = new Item("Tes-4", "Description-4", new String[]{"comment - 4", "comment - 4"});
       Tracker tracker = new Tracker();

       tracker.add(item0);
       tracker.add(item1);
       tracker.add(item2);
       tracker.add(item3);

       List<Item> result = tracker.findAll();
        assertThat(result.get(1).getName(), is("Tes-2"));
        tracker.clearTable();

    }

    /**
     * Testing update element in Tracker.
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Item item0 = new Item("Tes-1", "Description-1", new String[]{"comment - 1", "comment - 1"});
        Item item1 = new Item("Tes-2", "Description-2", new String[]{"comment - 2", "comment - 2"});
        Item item2 = new Item("Tes-3", "Description-3", new String[]{"comment - 3", "comment - 3"});
        Tracker tracker = new Tracker();

        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);

        item1.setName("task777");
        tracker.update(item1);

        String result = tracker.findById(item1.getId()).getName();

        assertThat(result, is("task777"));
        tracker.clearTable();
    }

    /**
     * Testing delete elemetn from Tracker.
     */
    @Test
    public void whenDeleteItemThenLeftDisplacementItems() {
        Item item0 = new Item("Tes-1", "Description-1", new String[]{"comment - 1", "comment - 1"});
        Item item1 = new Item("Tes-2", "Description-2", new String[]{"comment - 2", "comment - 2"});
        Item item2 = new Item("Tes-3", "Description-3", new String[]{"comment - 3", "comment - 3"});
        Item item3 = new Item("Tes-4", "Description-4", new String[]{"comment - 4", "comment - 4"});
        Tracker tracker = new Tracker();

        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2);
        assertThat(tracker.findAll().get(2).getName(), is("Tes-4"));
        tracker.clearTable();
    }

    /**
     * Testing searching elements by name.
     */
    @Test
    public void whenSearchElementByNameThenReturnArrayElementsWithNames() {
        Item item0 = new Item("Test-0", "Description-1", new String[]{"comment - 1", "comment - 1"});
        Item item1 = new Item("Test-2", "Description-2", new String[]{"comment - 2", "comment - 2"});
        Item item2 = new Item("Test-0", "Description-3", new String[]{"comment - 3", "comment - 3"});
        Item item3 = new Item("Test-4", "Description-4", new String[]{"comment - 4", "comment - 4"});
        Item item4 = new Item("Test-0", "Description-5", new String[]{"comment - 5", "comment - 5"});
        Tracker tracker = new Tracker();

        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        int result = tracker.findByName("Test-0").size();
        assertThat(result, is(3));
        tracker.clearTable();
    }

    /**
     * Testing getting all elements from Track.
     */
    @Test
    public void whenAllElementsThenReturnArraysWithoutNull() {
        Item item0 = new Item("Tes-1", "Description-1", new String[]{"comment - 1", "comment - 1"});
        Item item1 = new Item("Tes-2", "Description-2", new String[]{"comment - 2", "comment - 2"});
        Item item2 = new Item("Tes-3", "Description-3", new String[]{"comment - 3", "comment - 3"});
        Item item3 = new Item("Tes-4", "Description-4", new String[]{"comment - 4", "comment - 4"});
        Item item4 = new Item("Tes-5", "Description-5", new String[]{"comment - 5", "comment - 5"});
        Tracker tracker = new Tracker();

        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(item1);
        tracker.delete(item3);
        tracker.delete(item4);
        assertThat(tracker.findAll().size(), is(2));
        tracker.clearTable();
    }

    /**
     * Testing getting elemtnt by ID from Track.
     */
    @Test
    public void whenSearchElementByIDThenReturnElementWithId() {
        Item item0 = new Item("Tes-1", "Description-1", new String[]{"comment - 1", "comment - 1"});
        Item item1 = new Item("Tes-2", "Description-2", new String[]{"comment - 2", "comment - 2"});
        Item item2 = new Item("Tes-3", "Description-3", new String[]{"comment - 3", "comment - 3"});
        Item item3 = new Item("Tes-4", "Description-4", new String[]{"comment - 4", "comment - 4"});
        Item item4 = new Item("Tes-5", "Description-5", new String[]{"comment - 5", "comment - 5"});
        Item item5 = new Item("Tes-6", "Description-6", new String[]{"comment - 6", "comment - 6"});
        Tracker tracker = new Tracker();

        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        String result = tracker.findById(item3.getId()).getId();
        assertThat(result, is(item3.getId()));
        tracker.clearTable();
    }

}

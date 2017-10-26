package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class testing tracker app.
 *
 * @author gkuznetsov.
 * @since 21.12.17.
 * @version 0.1.
 */
public class StartUITest {
    /**
     * Test addition item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "User 1", "description for user 1", "some comment", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("User 1"));
        tracker.clearTable();
    }

    /**
     * Test updating item.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test-1", "Description-1", new String[]{"comment - 1", "comment - 1"}));
        String id = item.getId();
        Input input = new StubInput(new String[]{"2", id, "New User", "New Description", "Some comment", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id).getName(), is("New User"));
        tracker.clearTable();
    }
    /**
     * Testing deleting item.
     */
    @Test
    public void whenUserDeleteItemThenItemDeleteFromTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test-1", "Description-1", new String[]{"comment - 1", "comment - 1"}));
        tracker.add(new Item("Test-1", "Description-1", new String[]{"comment - 1", "comment - 1"}));
        String id = item.getId();
        Input input = new StubInput(new String[]{"3", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("Test-1"));
        tracker.clearTable();
    }

    /**
     * Test searching item by ID.
     */
    @Test
    public void whenUserSearchItemByIDThenReturnItemWithSameID() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test-1", "Description-1", new String[]{"comment - 1", "comment - 1"}));
        String id = item.getId();
        Input input = new StubInput(new String[]{"4", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getId(), is(id));
        tracker.clearTable();
    }

    /**
     * Test searching items by name.
     */
    @Test
    public void whenUserSearchItemByNameThenReturnItemsSameWithNames() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("User-1", "Description-1", new String[]{"comment - 1", "comment - 1"}));
        tracker.add(new Item("Tes-2", "Description-2", new String[]{"comment - 2", "comment - 1"}));
        tracker.add(new Item("Tes-3", "Description-3", new String[]{"comment - 3", "comment - 3"}));
        tracker.add(new Item("Tes-4", "Description-4", new String[]{"comment - 4", "comment - 4"}));
        Input input = new StubInput(new String[]{"0", "User-1", "description for user 1", "some comment", "y"});
        new StartUI(input, tracker).init();
        Item result = tracker.findByName("User-1").get(1);
        assertThat(result.getName(), is("User-1"));
        tracker.clearTable();
    }
}

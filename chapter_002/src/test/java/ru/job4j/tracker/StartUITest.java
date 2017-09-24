package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
<<<<<<< HEAD
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
        Input input = new StubInput(new String[]{"0", "User 1", "description for user 1", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("User 1"));
    }

    /**
     * Test updating item.
     */
=======
 * Class for...
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @sinse 17.
 */
public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "User 1", "description for user 1", "6"});
        new StartUI(input,tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("User 1"));
    }
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("User-1", "Description"));
        String id = item.getId();
<<<<<<< HEAD
        Input input = new StubInput(new String[]{"2", id, "New User", "New Description", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id).getName(), is("New User"));
    }
    /**
     * Testing deleting item.
     */
=======
        Input input = new StubInput(new String[]{"2", id, "New User", "New Description", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id).getName(), is("New User"));
    }
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
    @Test
    public void whenUserDeleteItemThenItemDeleteFromTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("User-1", "Description"));
        tracker.add(new Item("User-2", "Description2"));
        String id = item.getId();
<<<<<<< HEAD
        Input input = new StubInput(new String[]{"3", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("User-2"));
    }

    /**
     * Test searching item by ID.
     */
=======
        Input input = new StubInput(new String[]{"3", id, "6"});
        new StartUI(input,tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("User-2"));
    }
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
    @Test
    public void whenUserSearchItemByIDThenReturnItemWithSameID() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("User-1", "Description"));
        String id = item.getId();
<<<<<<< HEAD
        Input input = new StubInput(new String[]{"4", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getId(), is(id));
    }

    /**
     * Test searching items by name.
     */
=======
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input,tracker).init();
        assertThat(tracker.findAll()[0].getId(), is(id));
    }
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
    @Test
    public void whenUserSearchItemByNameThenReturnItemsSameWithNames() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("User-121", "Description"));
        tracker.add(new Item("User-122", "Description"));
        tracker.add(new Item("User-121", "Description"));
        tracker.add(new Item("User-123", "Description"));
<<<<<<< HEAD
        Input input = new StubInput(new String[]{"5", "User-121", "y"});
        new StartUI(input, tracker).init();
=======

        Input input = new StubInput(new String[]{"5", "User-121", "6"});
        new StartUI(input,tracker).init();
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
        assertThat(tracker.findByName("User-121")[1].getName(), is("User-121"));
    }
}

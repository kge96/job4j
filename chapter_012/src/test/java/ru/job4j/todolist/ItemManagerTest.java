package ru.job4j.todolist;

import org.junit.Test;

import java.sql.Timestamp;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class for Item integration testing.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.12.2017.
 */
public class ItemManagerTest {
    /**
     * Item manager.
     */
    private final ItemManager manager = new ItemManager();

    /**
     * Test addition item to storage.
     */
    @Test
    public void testAddItem() {
        Item item = new Item();
        item.setDesc("storage test");
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        item.setDone(true);
        this.manager.addItem(item);
        String result = "storage test";
        assertThat(result, is(this.manager.getItem(1).getDesc()));
    }

    /***
     * Testing update item.
     */
    @Test
    public void testAddOrUpdate() {
        Item item = new Item();
        item.setDesc("storage test");
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        item.setDone(true);
        this.manager.addItem(item);
        item.setDesc("new description");
        item.setId(1);
        this.manager.addOrUpdate(item);
        String result = "new description";
        assertThat(result, is(this.manager.getItem(1).getDesc()));
    }

    /**
     * Testing get item by id.
     */
    @Test
    public void testGetItemById() {
        Item item = new Item();
        item.setDesc("Comment");
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        item.setDone(true);
        this.manager.addItem(item);
        assertThat(item, is(this.manager.getItem(1)));
    }
}

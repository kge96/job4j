package ru.job4j;

import org.junit.Test;
import ru.job4j.todolist.Item;
import ru.job4j.todolist.ItemManager;

import java.sql.Timestamp;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing item manager.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 29.11.2017.
 */
public class ItemManagerTest {
    /**
     * Test.
     */
    @Test
    public void whenAddNewItemThenItAddedIntoDatabase() {
        ItemManager manager = new ItemManager();

        Item item = new Item();
        item.setId(3);
        item.setDesc("description-4");
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        item.setDone(true);
        manager.addOrUpdate(item);
        String result = manager.getItem(5).getDesc();
        assertThat(result, is("description-4"));
        manager.closeSession();
    }
}

package ru.job4j.tracker.actions;

import ru.job4j.tracker.Action;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
/**
 * Class for search item by ID on tracker.
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class FindItemByIDAction implements Action {
    /**
     * Search item by ID on tracker.
     * @param tracker - item storage.
     * @param input - messenger for ask question, get parameters and tell answer.
     */
    @Override
    public void execute(Tracker tracker, Input input) {
        String id = input.ask("Enter item ID: ");
        Item item = tracker.findById(id);
        if (item == null) {
            input.print("Item not found\n");
        } else {
            input.print("Was founded:\n" + "ID: " + item.getId() + "; Name: " + item.getName() + "; Description: " + item.getDesc() + ";");
        }
    }
}

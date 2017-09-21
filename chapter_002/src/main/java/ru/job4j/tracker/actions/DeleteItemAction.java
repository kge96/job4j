package ru.job4j.tracker.actions;

import ru.job4j.tracker.Action;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Class for deleting items from tracker.
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class DeleteItemAction implements Action {
    @Override
    /**
     * Delete item from tracker.
     * @param tracker - item storage.
     * @param input - messenger for ask question, get parameters and tell answer.
     */
    public void execute(Tracker tracker, Input input) {
        String id = input.ask("Enter item ID which you want delete: ");
        Item  deleteItem = tracker.findById(id);
        if (deleteItem == null) {
            input.print("Item not found\n");
        } else {
            tracker.delete(deleteItem);
        }

    }
}

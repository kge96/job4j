package ru.job4j.tracker.actions;

import ru.job4j.tracker.Action;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Class for edit ection.
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class EditItemAction implements Action {
    /**
     * Run edit action.
     * @param tracker - item storage.
     * @param input - messenger.
     */
    @Override
    public void execute(Tracker tracker, Input input) {
        String id = input.ask("Enter item ID");
        Item item = tracker.findById(id);
        if (item == null) {
            input.print("Item not found\n");
        } else {
            String newName = input.ask("Enter new user name");
            String newDesc = input.ask("Enter new item description");
            Item newItem = new Item(newName, newDesc);
            item.setId(id);
            tracker.update(newItem);
        }
    }
}

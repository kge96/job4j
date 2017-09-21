package ru.job4j.tracker.actions;

import ru.job4j.tracker.Action;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Class for add item to tracker.
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class AddItemAction implements Action {
    /**
     * Ask name and description and add new item in tracker.
     * @param tracker - item storage.
     * @param input - messenger for ask question, get parameters and tell answer.
     */
    @Override
    public void execute(Tracker tracker, Input input) {
        String name = input.ask("Pleas enter user name");
        String description = input.ask("Pleas enter item description");
        Item item = tracker.add(new Item(name, description));
        if (item != null) {
            input.print("Item " + item.getName() + " was added\n");
        } else {
            input.print("Error! Item " + item.getName() + "was not added!!!\n");
        }
    }
}

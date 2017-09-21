package ru.job4j.tracker.actions;

import ru.job4j.tracker.Action;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
/**
 * Class for show all items from tracker.
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class ShowAllItemsAction implements Action {
    /**
     * Show all item from tracker.
     * @param tracker - item storage.
     * @param input - messenger for ask question, get parameters and tell answer.
     */
    @Override
    public void execute(Tracker tracker, Input input) {
        Item[] elements = tracker.findAll();
        if (elements.length == 0) {
            input.print("Does't find any items\n");
        } else {
            input.print("Was find " + elements.length + " items:\n");
        }

        for (Item item : elements) {
            input.print(ItemInfo.getInfo(item));
        }
    }
}

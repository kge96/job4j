package ru.job4j.tracker;

import ru.job4j.tracker.actions.AddItemAction;
import ru.job4j.tracker.actions.EditItemAction;
import ru.job4j.tracker.actions.DeleteItemAction;
import ru.job4j.tracker.actions.ShowAllItemsAction;
import ru.job4j.tracker.actions.FindItemByIDAction;
import ru.job4j.tracker.actions.FindItemsByNameAction;

/**
 * Class for select action.
 *
 * @author gkuznetsov.
 * @since 20.09.17.
 * @version 0.1.
 */
public class MenuTracker {
    /**
     * Actions array.
     */
    private Action[] actions = {
            new AddItemAction(),
            new ShowAllItemsAction(),
            new EditItemAction(),
            new DeleteItemAction(),
            new FindItemByIDAction(),
            new FindItemsByNameAction()
    };

    /**
     * Take index of action and return action.
     * @param index - index of action.
     * @return Action.
     */
    public Action select(int index) {
        Action result = null;
        if (actions[index] != null) {
            result = actions[index];
        }
        return result;
    }
}

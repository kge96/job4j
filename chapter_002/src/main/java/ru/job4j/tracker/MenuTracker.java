package ru.job4j.tracker;


/**
 * Class for select action.
 *
 * @author gkuznetsov.
 * @since 20.09.17.
 * @version 0.1.
 */
public class MenuTracker {
    /**
     * Input.
     */
    private Input input;
    /**
     * Item storage.
     */
    private Tracker tracker;
    /**
     * Action storage.
     */
    private UserAction[] actions = new UserAction[6];

    /**
     * Constructor.
     *
     * @param input   - input.
     * @param tracker - input storage.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Fill the array storage with data.
     *
     * @return int - storage size.
     */
    public int fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemByName();
        this.actions[5] = new FindItemByID();

        return actions.length;
    }

    /**
     * Take index of action and return action.
     *
     * @param key - index of action.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Print menu items.
     */
    public void showMenu() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Inner class for add item.
     */
    private class AddItem implements UserAction {
        /**
         * Get operation index.
         *
         * @return int.
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * Add item in item storage.
         *
         * @param input   - input.
         * @param tracker - input storage.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Pleas enter user name");
            String description = input.ask("Pleas enter item description");
            Item item = tracker.add(new Item(name, description));
            if (item != null) {
                input.print("Item " + item.getName() + " was added\n");
            } else {
                input.print("Error! Item " + item.getName() + "was not added!!!\n");
            }
        }

        /**
         * Print operation name in menu.
         *
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new item.");
        }
    }

    /**
     * Inner class for show all items.
     */
    private class ShowAllItems implements UserAction {
        /**
         * Get operation index.
         *
         * @return int.
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * Add item in item storage.
         *
         * @param input   - input.
         * @param tracker - item storage.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] elements = tracker.findAll();
            if (elements.length == 0) {
                input.print("Does't find any items\n");
            } else {
                input.print("Was find " + elements.length + " items:\n");
            }
            for (Item item : elements) {
                input.print(String.format("ID: %s;  Name: %s; Description: %s;", item.getId(), item.getName(), item.getDesc()));
            }
        }

        /**
         * Print operation name in menu.
         *
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    /**
     * Inner class for edit item.
     */
    private class EditItem implements UserAction {
        /**
         * Get operation index.
         *
         * @return int.
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * Edit selected item.
         *
         * @param input   - input.
         * @param tracker - input storage.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter item ID");
            Item item = tracker.findById(id);
            if (item == null) {
                input.print("Item not found\n");
            } else {
                String newName = input.ask("Enter new user name");
                String newDesc = input.ask("Enter new item description");
                Item newItem = new Item(newName, newDesc);
                newItem.setId(item.getId());
                tracker.update(newItem);
            }
        }

        /**
         * Print operation name in menu.
         *
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }

    /**
     * Inner class for delete item.
     */
    private class DeleteItem implements UserAction {
        /**
         * Get operation index.
         *
         * @return int.
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * Add item in item storage.
         *
         * @param input - input.
         * @param tracker - input storage.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter item ID which you want delete: ");
            Item deleteItem = tracker.findById(id);
            if (deleteItem == null) {
                input.print("Item not found\n");
            } else {
                tracker.delete(deleteItem);
            }
        }

        /**
         * Print operation name in menu.
         *
         * @return
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    /**
     * Inner class for searching item by name.
     */
    private class FindItemByName implements UserAction {
        /**
         * Get operation index.
         *
         * @return int.
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * Search item by Name.
         *
         * @param input   - input.
         * @param tracker - input storage.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter user name: ");
            Item[] items = tracker.findByName(name);
            if (items.length == 0) {
                input.print("Item not found\n");
            } else {
                input.print("Was founded " + items.length + " items: ");
                for (Item item : items) {
                    input.print(String.format("ID: %s;  Name: %s; Description: %s;", item.getId(), item.getName(), item.getDesc()));
                }
            }
        }

        /**
         * Print operation name in menu.
         *
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Name");
        }
    }

    /**
     * Inner class for item searching by ID.
     */
    private class FindItemByID implements UserAction {
        /**
         * Get operation index.
         *
         * @return int.
         */
        @Override
        public int key() {
            return 5;
        }

        /**
         * Search item by ID.
         *
         * @param input   - input.
         * @param tracker - input storage.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter item ID: ");
            Item item = tracker.findById(id);
            if (item == null) {
                input.print("Item not found\n");
            } else {
                input.print("Was founded:\n" + "ID: " + item.getId() + "; Name: " + item.getName() + "; Description: " + item.getDesc() + ";");
            }
        }

        /**
         * Print operation name in menu.
         *
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by ID.");
        }
    }


}
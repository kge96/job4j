package ru.job4j.tracker;

/**
 * Class for start application Tracker.
 * @author gkuznetsov.
 * @since 20.09.17.
 * @version 0.1.
 */

public class StartUI {
    /**
     * Rage of menu numbers value.
     */
    private int[] ranges;
    /**
     * Input.
     */
    private Input input;
    /**
     * Inputs storage.
     */
    private Tracker tracker;
    /**
     * Starting program.
     * @param input - input.
     * @param tracker - input storage.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Initialization program.
     */
    public void init() {
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillActions();
        UserAction findByIdAction = new BaseAction("Find item by ID", 5) {
            @Override
            public int key() {
                return 5;
            }

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
        };
        menuTracker.addAction(findByIdAction);

        int sizeMenu = menuTracker.getMenuSize();
        ranges = new int[sizeMenu + 1];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }

        do {
            menuTracker.showMenu();
            System.out.println(sizeMenu + ". Exit program.");
            int selected = input.ask("select:", ranges);

            if (selected == sizeMenu) {
                break;
            }

            menuTracker.select(selected);
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }
    /**
     * Main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}


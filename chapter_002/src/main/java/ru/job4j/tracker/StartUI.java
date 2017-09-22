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
        int sizeMenu = menuTracker.fillActions();
        ranges = new int[sizeMenu + 1];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }

        do {
            menuTracker.showMenu();
            System.out.println(sizeMenu + ". Exit Program.");
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


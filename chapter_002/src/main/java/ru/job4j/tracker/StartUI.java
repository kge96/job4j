package ru.job4j.tracker;

/**
 * Class for start application Tracker.
 * @author gkuznetsov.
 * @since 20.09.17.
 * @version 0.1.
 */

public class StartUI {
    /**
     * Command for add new item.
     */
    private static final String ADD = "0";
    /**
     * Command for show all item.
     */
    private static final String SHOW_ALL = "1";
    /**
     * Command for edit item.
     */
    private static final String EDIT = "2";
    /**
     * Command for delete item.
     */
    private static final String DELETE = "3";
    /**
     * Command for find item by ID.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Command for find item by name.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Command for exit.
     */
    private static final String EXIT = "6";
    /**
     * Input.
     */
    private Input input;
    private Tracker tracker;
    /**
     * Programm menu.
     */
    private String menu =
            "0. Add new Item\n"
            + "1. Show all items\n"
            + "2. Edit item\n"
            + "3. Delete item\n"
            + "4. Find item by Id\n"
            + "5. Find items by name\n"
            + "6. Exit Program\n"
            + "Select: ";

    /**
     * Starting program.
     * @param input - input.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Check user answer and return operation number.
     * if user input incorrect data return -1;
     * @param answer - user input data.
     * @return int.
     */
    public int checkAnswer(String answer) {
        switch (answer) {
            case ADD :
                return 0;
            case SHOW_ALL:
                return 1;
            case EDIT:
                return 2;
            case DELETE:
                return 3;
            case FIND_BY_ID:
                return 4;
            case FIND_BY_NAME:
                return 5;
            case EXIT:
                return 6;
            default:
                return -1;
        }
    }

    /**
     * Initialization program.
     */
    public void init() {
        MenuTracker menuTracker = new MenuTracker();
        int answer = -1;
        while (answer != 6) {
                answer = checkAnswer(this.input.ask(menu));
                if (answer == -1 || answer == 6) {
                    continue;
                }
                menuTracker.select(answer).execute(this.tracker, this.input);
        }
    }

    /**
     * Main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}


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
    private Tracker tracker;
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
<<<<<<< HEAD
=======
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
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
    }

    /**
     * Initialization program.
     */
    public void init() {
<<<<<<< HEAD
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
=======
        MenuTracker menuTracker = new MenuTracker();
        int answer = -1;
        while (answer != 6) {
                answer = checkAnswer(this.input.ask(menu));
                if (answer == -1 || answer == 6) {
                    continue;
                }
                menuTracker.select(answer).execute(this.tracker, this.input);
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
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
<<<<<<< HEAD
        new StartUI(new ValidateInput(), new Tracker()).init();
=======
        new StartUI(new ConsoleInput(), new Tracker()).init();
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
    }
}


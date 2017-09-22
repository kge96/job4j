package ru.job4j.tracker;

/**
 * Class validate user data.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 22.09.2017.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Ask question and return answer.
     * @param question - question.
     * @param range - range of menu.
     * @return String.
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Pleas, select key from menu");
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter validate data again");
            }
        } while (invalid);
        return value;
    }
}

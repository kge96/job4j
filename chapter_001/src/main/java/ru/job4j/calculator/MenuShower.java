package ru.job4j.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for showing menu.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 25.11.2017.
 */
public class MenuShower {
    /**
     * List of operation.
     */
    private List<String> operations = new ArrayList<>();
    /**
     * Unmodified list operation.
     */
    private List<String> unmodifiedList;

    /**
     * Constructor.
     * @param lists - list of operation name.
     */
    public MenuShower(List... lists) {
        for (List list : lists) {
            operations.addAll(list);
        }
        unmodifiedList = Collections.unmodifiableList(operations);
    }

    /**
     * Method for print menu.
     */
    public void showCalcMenu() {
        for (String item : unmodifiedList) {
            System.out.println(String.format("%s) %s", unmodifiedList.indexOf(item) + 1, item));
        }
        System.out.println(String.format("%s) %s", unmodifiedList.size() + 1, "Exit"));
    }

    /**
     * Return list of operation.
     * @return List.
     */
    public List<String> getList() {
        return this.unmodifiedList;
    }
}

package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing LinkedContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.10.2017.
 */
public class LinkedContainerTest {
    /**
     * Testing add new Integer element.
     */
    @Test
    public void whenAddNewIntegerElementThenItAdded() {
        LinkedContainer<Integer> container = new LinkedContainer<>();
        container.add(1);
        int result = container.get(0);
        assertThat(result, is(1));
    }
    /**
     * Testing add a few new Integer elements.
     */
    @Test
    public void whenAddNewIntegerElementsThenTheyAreAdded() {
        LinkedContainer<Integer> container = new LinkedContainer<>();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
        int result = container.get(4);
        assertThat(result, is(5));
    }
    /**
     * Testing add a few new String elements.
     */
    @Test
    public void whenAddNewStringElementsThenTheyAreAdded() {
        LinkedContainer<String> container = new LinkedContainer<>();
        container.add("A");
        container.add("B");
        container.add("C");
        container.add("D");
        container.add("E");
        String result = container.get(4);
        assertThat(result, is("E"));
    }
    /**
     * Testing iterator work with String elements.
     */
    @Test
    public void whenGetStringElementByForeEachThenItGetting() {
        LinkedContainer<String> stringArray = new LinkedContainer<>();
        stringArray.add("A");
        stringArray.add("B");
        stringArray.add("C");
        stringArray.add("D");
        stringArray.add("E");
        stringArray.add("F");
        String result = null;
        for (String str : stringArray) {
            if (str.equals("F")) {
                result = "Bingo";
                break;
            }
        }
        assertThat(result, is("Bingo"));
    }
    /**
     * Testing iterator work with Integer elements.
     */
    @Test
    public void whenGetIntegerElementByForeEachThenItGetting() {
        LinkedContainer<Integer> intArray = new LinkedContainer<>();
        for (int i = 1; i < 8; i++) {
            intArray.add(i);
        }
        String result = null;
        for (Integer itm : intArray) {
            if (itm == 7) {
                result = "Bingo";
            }
        }
        assertThat(result, is("Bingo"));

    }
}

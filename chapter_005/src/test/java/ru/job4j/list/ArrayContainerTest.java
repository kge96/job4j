package ru.job4j.list;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing ArrayContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.10.2017.
 */
public class ArrayContainerTest {
    /**
     * Testing add string element.
     */
    @Test
    public void whenAddNewStringElementThenItAdded() {
        ArrayContainer<String> stringArray = new ArrayContainer<>();
        stringArray.add("A");
        stringArray.add("B");
        stringArray.add("C");
        stringArray.add("D");
        stringArray.add("E");
        stringArray.add("F");
        String result = stringArray.get(5);
        assertThat(result, is("F"));

    }
    /**
     * Testing add integer element.
     */
    @Test
    public void whenAddNewIntegerElementThenItAdded() {
        ArrayContainer<Integer> intArray = new ArrayContainer<>();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        intArray.add(5);
        intArray.add(6);
        int result = intArray.get(5);
        assertThat(result, is(6));

    }

    /**
     * Testing iterator work with integer elements.
     */
    @Test
    public void whenGetIntegerElementByForeEachThenItGetting() {
        ArrayContainer<Integer> intArray = new ArrayContainer<>();
        for (int i = 1; i < 8; i++) {
            intArray.add(i);
        }
        String result = null;
        for (Integer itm : intArray) {
            if (itm == 4) {
                result = "Bingo";
            }
        }
        assertThat(result, is("Bingo"));

    }
    /**
     * Testing iterator work with string elements.
     */
    @Test
    public void whenGetStringElementByForeEachThenItGetting() {
        ArrayContainer<String> stringArray = new ArrayContainer<>();
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
}

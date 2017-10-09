package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing Directory.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 07.10.2017.
 */
public class DirectoryTest {
    /**
     * Testing insert element into Directory collection.
     */
    @Test
    public void whenPutNewElementIntoDirectoryThenItAddInIt() {
        Directory<String, Integer> directory = new Directory<>();
        directory.insert("Ivan", 24);
        directory.insert("Oleg", 21);
        directory.insert("Vladimir", 28);

        int result = directory.get("Oleg");
        assertThat(result, is(21));
    }

    /**
     * Testing delete element from Directory collection.
     */
    @Test
    public void whenDeleteElementIntoDirectoryThenItAddInDelete() {
        Directory<String, Integer> directory = new Directory<>();
        directory.insert("Ivan", 24);
        directory.insert("Oleg", 21);
        directory.insert("Vladimir", 28);
        directory.insert("Olga", 21);

        boolean result = directory.delete("Oleg");
        assertThat(result, is(true));
    }

    /**
     * Testing iterator.
     */
    @Test
    public void whenGetElementByIteratorThenItGet() {
        Directory<String, Integer> directory = new Directory<>();
        directory.insert("Ivan", 24);
        directory.insert("Oleg", 21);
        directory.insert("Vladimir", 28);
        directory.insert("Olga", 21);
        String result = null;
        for (Iterator<Integer> it = directory.iterator(); it.hasNext();) {
           if (it.next().equals(28)) {
               result = "Yes";
           }
        }

        assertThat(result, is("Yes"));
    }
    /**
     * Testing insert same elements into Directory collection.
     */
    @Test
    public void whenPutFewSameElementIntoDirectoryThenAddJustOne() {
        Directory<String, Integer> directory = new Directory<>();
        directory.insert("Ivan", 24);
        directory.insert("Vladimir", 28);
        directory.insert("Olga", 21);
        directory.insert("Oleg", 21);
        directory.insert("Oleg", 15);

        int result = directory.get("Oleg");
        assertThat(result, is(15));
    }
    /**
     * Testing insert same elements into Directory collection.
     */
    @Test
    public void whenAddTwoElementsAndCallHasNextThenOnThirdAttemptReturnFalse() {
        Directory<String, Integer> directory = new Directory<>();
        directory.insert("Ivan", 24);
        directory.insert("Vladimir", 28);

        directory.iterator().hasNext();
        directory.iterator().next();
        directory.iterator().hasNext();
        directory.iterator().next();

        assertThat(directory.iterator().hasNext(), is(false));

    }

}

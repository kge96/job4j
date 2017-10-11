package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for creating SetLinkedContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.10.2017.
 */
public class SetLinkedContainerTest {
    /**
     * Testing add String values.
     */
    @Test
    public void whenAddNewStringElementsThenItAdded() {
        SetLinkedContainer<String> container = new SetLinkedContainer<>();
        container.add("A");
        container.add("B");
        container.add("C");
        container.add("D");
        assertThat(container.get(3), is("D"));
    }
    /**
     * Testing add the same String values.
     */
    @Test
    public void whenAddTheSameStringElementsThenOneOfSameElementsNotAdded() {
        SetLinkedContainer<String> container = new SetLinkedContainer<>();
        container.add("A");
        container.add("B");
        container.add("A");
        container.add("D");
        assertThat(container.get(2), is("D"));
    }

    /**
     * Testing add Integer values.
     */
    @Test
    public void whenAddNewIntegerElementsThenItAdded() {
        SetLinkedContainer<Integer> container = new SetLinkedContainer<>();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        assertThat(container.get(3), is(4));
    }

    /**
     * Testing add the same Integer values.
     */
    @Test
    public void whenAddTheSameIntegerElementsThenOneOfSameElementsNotAdded() {
        SetLinkedContainer<Integer> container = new SetLinkedContainer<>();
        container.add(1);
        container.add(1);
        container.add(1);
        container.add(3);
        assertThat(container.get(1), is(3));
    }

    /**
     * Testing speed adding.
     */
    @Test
    public void testAdditionSpeed() {
        SetLinkedContainer<Integer> container1 = new SetLinkedContainer<>();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            container1.add((int) (Math.random() * 100));
        }
        long total1 = System.currentTimeMillis() - start1;

        SetLinkedContainer<Integer> container2 = new SetLinkedContainer<>();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            container2.fastAdd((int) (Math.random() * 100));
        }
        long total2 = System.currentTimeMillis() - start2;

        System.out.println("Add with searching duplicate by foreach  - " + total1 + " ms");
        System.out.println("Add with searching duplicate by hashCode  - " + total2 + " ms");

    }
}

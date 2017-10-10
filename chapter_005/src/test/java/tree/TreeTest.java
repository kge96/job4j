package tree;

import org.junit.Test;
import ru.job4j.tree.Tree;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing Tree.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 09.10.2017.
 */
public class TreeTest {
    /**
     * Testing when add element which this tree contains.
     */
    @Test
    public void whenAddTheSameElementThenItDidNotAdd() {
        Tree<Integer> tree = new Tree<>();
        tree.add(0, 1);
        tree.add(0, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(3, 33333);
        boolean result = tree.add(3, 33333);

        assertThat(result, is(false));

    }

    /**
     * Testing iterator.
     */
    @Test
    public void whenCheckNextElementThenReturnFalse() {
        Tree<Integer> tree = new Tree<>();
        tree.add(0, 1);
        tree.add(0, 2);
        tree.add(0, 3);
        tree.add(2, 8);
        tree.add(3, 9);

        tree.iterator().next();
        tree.iterator().next();
        tree.iterator().next();
        tree.iterator().next();
        tree.iterator().next();
        boolean result = tree.iterator().hasNext();

        assertThat(result, is(false));
    }

    /**
     * Testing search element.
     */
    @Test
    public void whenSearchChildThenReturnChildValue() {
        Tree<Integer> tree = new Tree<>();
        tree.add(0, 1);
        tree.add(0, 2);
        tree.add(0, 3);
        tree.add(2, 9);
        tree.add(3, 8);

        int result = tree.getChildValue(3, 0);
        assertThat(result, is(8));
    }
    /**
     * Testing binary.
     */
    @Test
    public void whenCheckThatTreeIsBinaryThenReturnFalse() {
        Tree<Integer> tree = new Tree<>();
        tree.add(0, 1);
        tree.add(0, 2);
        tree.add(0, 3);

        tree.add(1, 9);
        tree.add(1, 10);

        tree.add(2, 11);
        tree.add(2, 12);

        boolean result = tree.isBinary();
        assertThat(result, is(false));
    }
    /**
     * Testing binary.
     */
    @Test
    public void whenCheckThatTreeIsBinaryThenReturnTrue() {
        Tree<Integer> tree = new Tree<>();
        tree.add(0, 1);
        tree.add(0, 2);

        tree.add(1, 9);
        tree.add(1, 10);

        tree.add(2, 11);
        tree.add(2, 12);

        boolean result = tree.isBinary();
        assertThat(result, is(true));
    }
    /**
     * Testing binary.
     */
    @Test
    public void whenAddElementsAtTreeThenTheyAdded() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        tree.add(5);
        tree.add(2);
        tree.add(0);
        tree.add(3);
        tree.add(7);
        tree.add(9);
        tree.add(6);
        tree.add(6);

        tree.iterator().next();
        tree.iterator().next();
        tree.iterator().next();

        int result = tree.getChildValue(7, 0);
        assertThat(result, is(6));
    }
}

package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test for Board.
 * @author gkuznetsov.
 * @since 16.09.17.
 * @version 0.1.
 */
public class BoardTest {
    /**
     * line - определяет переход на новую строку в зависимости от ОС.
     */
    private final String line = System.getProperty("line.separator");

    /**
     * Testing class Board.
     */
    @Test
    public void whenBoardPaintWithWidthThreeAndHeightThreeThenStringWithThreeColsAndRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String expected = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(result, is(expected));
    }
    /**
     * Testing class Board.
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(result, is(expected));
    }
}

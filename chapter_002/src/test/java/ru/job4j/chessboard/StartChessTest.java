package ru.job4j.chessboard;

import org.junit.Test;
import ru.job4j.chessboard.chessexeptions.FigureNotFoundException;
import ru.job4j.chessboard.chessexeptions.ImpossibleMoveException;
import ru.job4j.chessboard.chessexeptions.OccupiedWayException;
import ru.job4j.chessboard.figures.Elephant;
import ru.job4j.chessboard.figures.Figure;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing chess board.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 25.09.2017.
 */
public class StartChessTest {
    /**
     * Test moving elephant from E3 to A7.
     */
    @Test
    public void whenMoveElephantFromE3ToA7ThenItMoved() {
        Board board = new Board();
        Figure elephant = new Elephant(board.getCell(4, 2));
        board.addFigure(elephant);
        boolean expected = true;
        boolean result = board.move(board.getCell(4, 2), board.getCell(0, 6));

        assertThat(result, is(expected));
    }
    /**
     * Test moving elephant from E3 to H6.
     */
    @Test
    public void whenMoveElephantFromE3ToH6ThenItMoved() {
        Board board = new Board();
        Figure elephant = new Elephant(board.getCell(4, 2));
        board.addFigure(elephant);
        boolean expected = true;
        boolean result = board.move(board.getCell(4, 2), board.getCell(7, 5));

        assertThat(result, is(expected));
    }
    /**
     * Test moving elephant from E3 to G1.
     */
    @Test
    public void whenMoveElephantFromE3ToG1ThenItMoved() {
        Board board = new Board();
        Figure elephant = new Elephant(board.getCell(4, 2));
        board.addFigure(elephant);
        boolean expected = true;
        boolean result = board.move(board.getCell(4, 2), board.getCell(6, 0));

        assertThat(result, is(expected));
    }
    /**
     * Test moving elephant from E3 to C1.
     */
    @Test
    public void whenMoveElephantFromE3ToC1ThenItMoved() {
        Board board = new Board();
        Figure elephant = new Elephant(board.getCell(4, 2));
        board.addFigure(elephant);
        boolean expected = true;
        boolean result = board.move(board.getCell(4, 2), board.getCell(2, 0));

        assertThat(result, is(expected));
    }

    /**
     * Test when figure not found.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenGetElephantFromE1ThenFigureNotFoundException() {
        Board board = new Board();
        Figure elephant = new Elephant(board.getCell(4, 2));
        board.addFigure(elephant);
        board.move(board.getCell(4, 0), board.getCell(2, 0));
    }

    /**
     * Test when figure when received wrong position.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveElephantFromE3ToE5ThenImpossibleMoveException() {
        Board board = new Board();
        Figure elephant = new Elephant(board.getCell(4, 2));
        board.addFigure(elephant);
        board.move(board.getCell(4, 2), board.getCell(4, 4));
    }

    /**
     * Test when destination cell is occupied.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenMoveElephantFromE3ToA7ThenOccupiedWayException() {
        Board board = new Board();
        Figure elephant = new Elephant(board.getCell(4, 2));
        Figure elephant2 = new Elephant(board.getCell(0, 6));
        board.addFigure(elephant);
        board.addFigure(elephant2);
        board.move(board.getCell(4, 2), board.getCell(0, 6));
    }
}

package ru.job4j.chessboard;

import ru.job4j.chessboard.figures.Figure;

/**
 * Class for creating cell.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 24.09.2017.
 */
public class Cell {
    /**
     * X - coordinate(numbers at chess).
     */
    private int positionX;
    /**
     * Y coordinate(letters at chess board).
     */
    private int positionY;
    /**
     * Figure at this cell.
     */
    private Figure figure = null;
    /**
     * Board which this cell belongs.
     */
    private Board board = null;

    /**
     * Constructor.
     * @param positionX - X - coordinate(numbers at chess).
     * @param positionY -  Y coordinate(letters at chess board).
     * @param board - Board which this cell belongs.
     */
    public Cell(int positionX, int positionY, Board board) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.board = board;
    }

    /**
     * Get position of cell with this coordinate.
     * @return int[];
     */
    public int[] getPosition() {
        return new int[]{this.positionX, this.positionY};
    }

    /**
     * Return figure which place in this cell.
     * @return Figure.
     */
    public Figure getFigure() {
        return this.figure;
    }

    /**
     * Return the board which this cell belongs.
     * @return Board.
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Set the figure in this cell.
     * @param figure - figure.
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}

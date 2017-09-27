package ru.job4j.chessboard.figures;

import ru.job4j.chessboard.Cell;
import ru.job4j.chessboard.chessexeptions.ImpossibleMoveException;

/**
 * Abstract class for chess figures.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 24.09.2017.
 */
public abstract class Figure {
    /**
     * Get cell.
     * @return Cell.
     */
    public Cell getCell() {
        return position;
    }

    /**
     * Position of this figure on the chess board.
     */
     private final Cell position;
    /**
     * Constructor.
     * @param position - figure position.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Method for description of the motion.
     * @param dist - destination cell.
     * @return Cell[].
     * @throws ImpossibleMoveException  - if this figure can't go to specified cell.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Move figure at new position.
     * @param dist - destination cell.
     */
    public void clone(Cell dist) {
        position.setFigure(null);
        dist.setFigure(this);
    }
}

package ru.job4j.chessboard.figures;

import ru.job4j.chessboard.Cell;
import ru.job4j.chessboard.chessexeptions.ImpossibleMoveException;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 24.09.2017.
 */
public abstract class Figure {
    final Cell position;

    protected Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;
}

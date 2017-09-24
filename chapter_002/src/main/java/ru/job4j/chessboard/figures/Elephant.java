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
public class Elephant extends Figure{

    public Elephant(Cell position) {
        super(position);
        position.setFigure(this);
    }

    @Override
    Cell[] way(Cell dist) throws ImpossibleMoveException {
        int[] thisPosition = this.position.getPosition();
        int[] distPosition = dist.getPosition();
        boolean canGo = Math.abs(thisPosition[0] - distPosition[0]) == Math.abs(thisPosition[1] - distPosition[1]);

        if (canGo) {

        } else {
            throw new ImpossibleMoveException();
        }
    }
}

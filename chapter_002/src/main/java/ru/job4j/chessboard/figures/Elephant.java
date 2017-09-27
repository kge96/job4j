package ru.job4j.chessboard.figures;

import ru.job4j.chessboard.Board;
import ru.job4j.chessboard.Cell;
import ru.job4j.chessboard.chessexeptions.ImpossibleMoveException;

/**
 * Class for create figure of elephants.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 24.09.2017.
 */
public class Elephant extends Figure {
    /**
     * Constructor.
     * @param position - position of this figure on the chess board.
     */
    public Elephant(Cell position) {
        super(position);
        position.setFigure(this);
    }

    /**
     * Method for check figure way.
     * @param dist - leaf cell.
     * @return Cell[].
     * @throws ImpossibleMoveException - if this figure can't go to specified cell.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int thisX = this.getCell().getPosition()[0];
        int thisY = this.getCell().getPosition()[1];
        int distX = dist.getPosition()[0];
        int distY = dist.getPosition()[1];
        Board board = this.getCell().getBoard();
        Cell[] cells;

        boolean canGo = Math.abs(thisX - distX) == Math.abs(thisY - distY);

        if (canGo) {
            cells = new Cell[Math.abs(thisX - distX)];
            int deltaX = Math.abs(distX - thisX) / (distX - thisX);
            int deltaY = Math.abs(distY - thisY) / (distY - thisY);

            int k = 0;
            int startX = thisX + deltaX;
            int startY = thisY + deltaY;

            while (startX != distX + deltaX) {
                cells[k++] = board.getCell(startX, startY);
                startX += deltaX;
                startY += deltaY;

            }

        } else {
            throw new ImpossibleMoveException();
        }
        return cells;
    }
}

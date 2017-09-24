package ru.job4j.chessboard;

import ru.job4j.chessboard.figures.Figure;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 24.09.2017.
 */
public class Cell {
    private int positionX;
    private int positionY;
    private Figure figure = null;

    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int[] getPosition() {
        return new int[]{this.positionX, this.positionY};
    }

    public Figure getFigure(){
        return this.figure;
    }
    public void setFigure(Figure figure) {
        this.figure = figure;
    }
    public boolean equals(Cell cell) {
        if (this.positionX == cell.getPosition()[0] && this.positionY == cell.getPosition()[1]) {
            return true;
        } else {
            return false;
        }
    }
}

package ru.job4j.chessboard;

import ru.job4j.chessboard.figures.Figure;

public class Board {
    private Cell[][] boardField = new Cell[8][8];
    private Figure[] figures;

    public Board(){
        fillBoardByCell();
    }
    public boolean move(Cell source, Cell dist) {
    //todo
        return true;
    }

    private void fillBoardByCell () {
        for (int i = 0; i < boardField.length; i++) {
            for (int j = 0; j <boardField.length; i ++) {
                boardField[i][j] = new Cell(i, j);
            }
        }
    }
    private void setFigures

    public Cell getCell(int positionX, int positionY) {
        return boardField[positionX][positionY];
    }
}

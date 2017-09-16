package ru.job4j.loop;

/**
 * Класс для построения шахматной доски.
 * @author gkuznetsov.
 * @since 15.09.17.
 * @version 0.1.
 */
public class Board {
    /**
     * Строит шахматную доску указанного размера в псевдографике.
     * @param width - ширина доски.
     * @param height - высота доски.
     * @return String.
     */
    public String paint(int width, int height) {
        String s = System.getProperty("line.separator");
        StringBuilder board = new StringBuilder();
        String result;
        String field = " ";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (field.equals(" ")) {
                    field = "x";
                } else {
                    field = " ";
                }
               board.append(field);
            }
            board.append(System.getProperty("line.separator"));
        }
        result = board.toString();
        return result;
    }
}

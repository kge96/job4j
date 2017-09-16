package ru.job4j.loop;

/**
 * Класс для отрисовки пирамиды в псевдографике.
 * @author gkuznetsov.
 * @since 16.09.17.
 * @version 0.1.
 */
public class Paint {
    /**
     * Отрисоввывает пирамиду в псевдографике.
     * @param h - высота пирамиды.
     * @return String.
     */
    public String piramid(int h) {
        StringBuilder builder = new StringBuilder();
        int width = h * 2 - 1;
        int center = width / 2 + 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < width; j++) {
                if (j >= center - i - 1 && j <= center + i - 1) {
                    builder.append("^");
                } else {
                    builder.append(" ");
                }
            }
            builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
    }
}

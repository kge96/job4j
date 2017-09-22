package ru.job4j.shape;

/**
 * Class for painting triangle.
 *
 * @author gkuznetsov.
 * @since 22.09.2017.
 * @version 0.1.
 */
public class Triangle implements Shape {
    /**
     * Painting triangle.
     * @return String.
     */
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        String sep = System.getProperty("line.separator");
        sb.append("     +" + sep);
        sb.append("    +++" + sep);
        sb.append("   +++++" + sep);
        sb.append("  +++++++");
        return sb.toString();
    }
}

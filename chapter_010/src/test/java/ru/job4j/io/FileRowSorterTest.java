package ru.job4j.io;

import org.junit.Test;

import java.io.File;

/**
 * Class for file sort.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 25.11.2017.
 */
public class FileRowSorterTest {
    /**
     * Test.
     */
    @Test
    public void testFileRowSorter() {
        String source = "..\\chapter_010\\src\\main\\java\\ru\\job4j\\io\\sources\\1.txt";
        String sortedCopy = "..\\chapter_010\\src\\main\\java\\ru\\job4j\\io\\sources\\2.txt";
        File fPathSource = new File(source);
        File fPathDist = new File(sortedCopy);
        FileRowSorter sorter = new FileRowSorter();
        sorter.sort(fPathSource, fPathDist);
    }
}

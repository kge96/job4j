package ru.job4j.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.io.IOException;

/**
 * Class for creating stream filter.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 21.11.2017.
 */
public class StreamAbusesFilter {
    /**
     * Drop word from abuses array.
     * @param in - InputStream.
     * @param out - OutputStream.
     * @param abuse - Array.
     * @return String.
     */
    public String dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        StringBuffer result = new StringBuffer();
        Scanner sc = new Scanner(in);
        String word;
        boolean equals = false;

        try {
            while (sc.hasNext()) {
                word = sc.next().toString();
                for (String abuses : abuse) {
                    if (word.equals(abuses) || word.endsWith(abuses) || word.startsWith(abuses)) {
                       equals = true;
                       break;
                    }
                }
                if (!equals) {
                    result.append(word);
                    result.append(" ");
                }
                equals = false;
            }
            out.write(result.toString().getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString().trim();
    }
}


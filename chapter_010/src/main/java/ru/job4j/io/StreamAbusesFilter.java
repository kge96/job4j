package ru.job4j.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
        StringBuffer buffer = new StringBuffer();
        try {
            while (in.available() > 0) {
                char symb = (char) in.read();
                if (symb != ' ') {
                    buffer.append(symb);
                } else {
                    if (!checkWord(buffer.toString(), abuse)) {
                        buffer.append(symb);
                        out.write(buffer.toString().getBytes());

                        result.append(buffer.toString());
                    }

                    buffer.setLength(0);
                }
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString().trim();
    }

    /**
     * Check word.
     * @param word - word.
     * @param abuses - Array.
     * @return boolean.
     */
    public boolean checkWord(String word, String[] abuses) {
        boolean result = false;
        for (String s : abuses) {
            if (s.equals(word)) {
                result = true;
                break;
            }
        }
    return result;
    }

}


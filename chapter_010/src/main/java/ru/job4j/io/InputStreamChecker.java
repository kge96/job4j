package ru.job4j.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class for checking InputStream.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 20.11.2017.
 */
public class InputStreamChecker {
    /**
     * Check parity of number in stream.
     * @param in - input stream
     * @return boolean.
     */
    public boolean isNumber(InputStream in) {
        boolean result = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            int number = Integer.parseInt(reader.readLine());

            if (number % 2 == 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

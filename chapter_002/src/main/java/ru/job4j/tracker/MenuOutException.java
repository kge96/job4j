package ru.job4j.tracker;

/**
 * Class for throws exception.
 *
 * @author gkuznetsov.
 * @since 22.09.2017.
 * @version 0.1.
 */
public class MenuOutException extends RuntimeException {
    /**
     * Send message.
     * @param msg - message.
     */
    public MenuOutException(String msg) {
        super(msg);
    }

}

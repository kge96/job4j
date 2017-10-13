package ru.job4j.orderbook;

import org.junit.Test;

/**
 * Class for testing order book.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 11.10.2017.
 */
public class OrderHandlerTest {
    /**
     * Testing parsing data.
     */
    @Test
    public void whenParsingDataFromXmlThenTotalTimeIsLessSevenSeconds() {
        long start = System.currentTimeMillis();
        OrderHandler orderHandler = new OrderHandler();
        orderHandler.distributeOrderBook(orderHandler.doHandle());
        orderHandler.doMuch();
        long total = System.currentTimeMillis() - start;
        System.out.println("Total time is - " + total);
    }
}
